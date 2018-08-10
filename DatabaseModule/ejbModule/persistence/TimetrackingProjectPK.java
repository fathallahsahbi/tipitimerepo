package persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TimetrackingProjectPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTimetracking;
	private int idProject;

	public int getIdTimetracking() {
		return idTimetracking;
	}

	public void setIdTimetracking(int idTimetracking) {
		this.idTimetracking = idTimetracking;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProject;
		result = prime * result + idTimetracking;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimetrackingProjectPK other = (TimetrackingProjectPK) obj;
		if (idProject != other.idProject)
			return false;
		if (idTimetracking != other.idTimetracking)
			return false;
		return true;
	}

}
