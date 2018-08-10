package persistence;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class StaffTimetracking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffTimetrackingPK staffTimetrackingPK;
	private float totalSalary;
	private boolean approved = false;
	private Staff staff;
	private Timetracking timetracking;

	@EmbeddedId
	public StaffTimetrackingPK getStaffTimetrackingPK() {
		return staffTimetrackingPK;
	}

	public void setStaffTimetrackingPK(StaffTimetrackingPK staffTimetrackingPK) {
		this.staffTimetrackingPK = staffTimetrackingPK;
	}

	public float getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	@ManyToOne
	@JoinColumn(name = "idStaff", referencedColumnName = "idStaff", insertable = false, updatable = false)
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne
	@JoinColumn(name = "idTimetracking", referencedColumnName = "idTimetracking", insertable = false, updatable = false)
	public Timetracking getTimetracking() {
		return timetracking;
	}

	public void setTimetracking(Timetracking timetracking) {
		this.timetracking = timetracking;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
