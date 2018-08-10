package persistence;

import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StaffTimetrackingPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStaff;
	private int idTimetracking;

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public int getIdTimetracking() {
		return idTimetracking;
	}

	public void setIdTimetracking(int idTimetracking) {
		this.idTimetracking = idTimetracking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStaff;
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
		StaffTimetrackingPK other = (StaffTimetrackingPK) obj;
		if (idStaff != other.idStaff)
			return false;
		if (idTimetracking != other.idTimetracking)
			return false;
		return true;
	}

}
