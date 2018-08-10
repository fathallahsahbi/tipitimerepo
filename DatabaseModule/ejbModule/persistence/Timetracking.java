package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Timetracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTimetracking;
	private int month;
	private int year;
	private int numberTotalDays;
	private int numberWorkingDays;
	private List<StaffTimetracking> staffTimetrackings;
	private List<TimetrackingProject> timetrackingProjects;

	@Id
	@SequenceGenerator(name = "timetrackingSeq", sequenceName = "timetracking_idtimetracking_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timetrackingSeq")
	public int getIdTimetracking() {
		return idTimetracking;
	}

	public void setIdTimetracking(int idTimetracking) {
		this.idTimetracking = idTimetracking;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberTotalDays() {
		return numberTotalDays;
	}

	public void setNumberTotalDays(int numberTotalDays) {
		this.numberTotalDays = numberTotalDays;
	}

	public int getNumberWorkingDays() {
		return numberWorkingDays;
	}

	public void setNumberWorkingDays(int numberWorkingDays) {
		this.numberWorkingDays = numberWorkingDays;
	}

	@OneToMany(mappedBy = "timetracking")
	public List<StaffTimetracking> getStaffTimetrackings() {
		return staffTimetrackings;
	}

	public void setStaffTimetrackings(List<StaffTimetracking> staffTimetrackings) {
		this.staffTimetrackings = staffTimetrackings;
	}

	@OneToMany(mappedBy = "timetracking")
	public List<TimetrackingProject> getTimetrackingProjects() {
		return timetrackingProjects;
	}

	public void setTimetrackingProjects(List<TimetrackingProject> timetrackingProjects) {
		this.timetrackingProjects = timetrackingProjects;
	}

}
