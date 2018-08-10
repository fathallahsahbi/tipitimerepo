/**
 * 
 */
package jsonmodel;

import java.util.List;

/**
 * @author Hanios
 *
 */
public class Employer {
	private String name;
	private List<Entry> entries;

	/**
	 * @return the entries
	 */
	public List<Entry> getEntries() {
		return entries;
	}

	/**
	 * @param entries
	 *            the entries to set
	 */
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
