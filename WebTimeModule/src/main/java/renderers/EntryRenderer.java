package renderers;

import java.util.Date;

/**
 * Renderer for time entry generation
 * 
 * @author Safubi
 * @since upcoming version
 * @category Renderers
 *
 */
public class EntryRenderer {
	private Date date;
	private String project;
	private String category;
	private double entry;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getEntry() {
		return entry;
	}

	public void setEntry(double entry) {
		this.entry = entry;
	}

}
