package helpers;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import renderers.TimetrackingEntry;

public class TimetrackingHelper {

	public void createTimetrackingXMLFile(String staffName, int month, int year, int numberDays) {
		try {
			Element root = new Element("timetracking");
			Document document = new Document();
			document.setRootElement(root);
			Element entries = new Element("entries");

			for (int i = 1; i <= numberDays; i++) {
				Element day = new Element("day");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Calendar calendar = Calendar.getInstance();
				calendar.set(year, month, i);
				day.setAttribute("id", dateFormat.format(calendar.getTime()));
				entries.addContent(day);
			}
			root.addContent(entries);
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, new FileWriter("e:/timetrackings/" + staffName + ".xml"));

			System.out.println("File Saved!");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public boolean checkIfEntryExists(String staffName, TimetrackingEntry entry) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			File xmlFile = new File("e:/timetrackings/" + staffName + ".xml");
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(xmlFile);
			Element root = document.getRootElement();
			Element entries = root.getChild("entries");
			List<Element> elements = entries.getChildren();
			Element day = null;
			for (Element element : elements) {
				if (element.getAttributeValue("id").toString().equals(dateFormat.format(entry.getDate()))) {
					day = element;
					break;
				}
			}
			List<Element> entryList = day.getChildren();
			boolean exists = false;
			for (Element entryElement : entryList) {
				if (entryElement.getAttributeValue("project").equals(entry.getProjectName())) {
					if (entryElement.getAttribute("category") != null) {
						if (entryElement.getAttributeValue("category").equals(entry.getCategory())
								&& Float.parseFloat(entryElement.getText()) == (entry.getHours())) {
							exists = true;
						}
					} else {
						if (Float.parseFloat(entryElement.getText()) == (entry.getHours())) {
							exists = true;
						}

					}
				}
			}
			return exists;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public void addTimetrackingEntry(String staffName, TimetrackingEntry entry) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			File xmlFile = new File("e:/timetrackings/" + staffName + ".xml");
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(xmlFile);
			Element root = document.getRootElement();
			Element entries = root.getChild("entries");
			List<Element> elements = entries.getChildren();
			Element day = null;
			for (Element elem : elements) {
				if (elem.getAttributeValue("id").toString().equals(dateFormat.format(entry.getDate()))) {
					day = elem;
					break;
				}
			}
			Element entryElement = new Element("entry");
			entryElement.setAttribute("project", entry.getProjectName());
			if (entry.getCategory() != null) {
				entryElement.setAttribute("category", entry.getCategory());
			}
			entryElement.setText(String.valueOf(entry.getHours()));
			day.addContent(entryElement);

			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, new FileWriter("e:/timetrackings/" + staffName + ".xml"));

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public float collectTotalHoursPerStaff(String staffName) {
		try {
			File xmlFile = new File("e:/timetrackings/" + staffName + ".xml");
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(xmlFile);
			Element root = document.getRootElement();
			Element entries = root.getChild("entries");
			List<Element> days = entries.getChildren();
			float totalHours = 0f;
			for (Element day : days) {
				List<Element> entryList = day.getChildren();
				for (Element entry : entryList) {
					totalHours += Float.parseFloat(entry.getText());
				}
			}
			return totalHours;
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0f;
		}

	}

	public float collectTotalHoursPerProject(String projectName) {
		try {
			File directory = new File("e:/timetrackings");
			List<File> xmlFiles = Arrays.asList(directory.listFiles());
			SAXBuilder builder = new SAXBuilder();
			float totalHours = 0f;
			for (File xmlFile : xmlFiles) {
				Document document = builder.build(xmlFile);
				Element root = document.getRootElement();
				Element entries = root.getChild("entries");
				List<Element> days = entries.getChildren();
				for(Element day : days) {
					List<Element> entryList = day.getChildren();
					for(Element entryElement : entryList) {
						if(entryElement.getAttributeValue("project").equals(projectName)) {
							totalHours+= Float.parseFloat(entryElement.getText());
						}
					}
				}
			}
			return totalHours;
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0f;
		}
	}

}
