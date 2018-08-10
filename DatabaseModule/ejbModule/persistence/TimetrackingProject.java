package persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimetrackingProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TimetrackingProjectPK timetrackingProjectPK;
	private int totalHours;
	private Timetracking timetracking;
	private Project project;

	@EmbeddedId
	public TimetrackingProjectPK getTimetrackingProjectPK() {
		return timetrackingProjectPK;
	}

	public void setTimetrackingProjectPK(TimetrackingProjectPK timetrackingProjectPK) {
		this.timetrackingProjectPK = timetrackingProjectPK;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	@ManyToOne
	@JoinColumn(name = "idTimetracking", referencedColumnName = "idTimetracking", insertable = false, updatable = false)
	public Timetracking getTimetracking() {
		return timetracking;
	}

	public void setTimetracking(Timetracking timetracking) {
		this.timetracking = timetracking;
	}

	@ManyToOne
	@JoinColumn(name = "idProject", referencedColumnName = "idProject", insertable = false, updatable = false)
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
