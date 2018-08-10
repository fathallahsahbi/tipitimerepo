/**
 * 
 */
package jsonmodel;

/**
 * @author Hanios
 *
 */
public class Entry {
	private String projectName;
	private String categorie;
	private double nbrHours;

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the nbrHours
	 */
	public double getNbrHours() {
		return nbrHours;
	}

	/**
	 * @param nbrHours
	 *            the nbrHours to set
	 */
	public void setNbrHours(double nbrHours) {
		this.nbrHours = nbrHours;
	}

}
