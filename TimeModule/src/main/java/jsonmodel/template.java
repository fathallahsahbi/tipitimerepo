package jsonmodel;

import java.util.List;

public class template {
	private String date;
	private List<Employer> employers;

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the employers
	 */
	public List<Employer> getEmployers() {
		return employers;
	}

	/**
	 * @param employers
	 *            the employers to set
	 */
	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}
	
}
