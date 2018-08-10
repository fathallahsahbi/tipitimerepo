/**
 * 
 */
package jsonmodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

/**
 * @author Hanios
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//creating json data for the template just testing perpose
		Lorem lorem = LoremIpsum.getInstance();
		ObjectMapper mapper = new ObjectMapper();
		List<Employer> employers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Employer employer = new Employer();
			employer.setName(i % 2 == 0 ? lorem.getNameMale() : lorem.getNameFemale());
			Entry entry = new Entry();
			entry.setProjectName(lorem.getTitle(1));
			entry.setCategorie(lorem.getWords(1));
			entry.setNbrHours(new Random().nextDouble());
			employer.setEntries(Collections.singletonList(entry));
			employers.add(employer);
		}

		template template = new template();
		template.setDate("" + new Date());
		template.setEmployers(employers);

		// Object to JSON in file
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/heni/Documents/template.json"), template);

		// Object to JSON in String
		try {
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(template);
			System.out.println(jsonInString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
