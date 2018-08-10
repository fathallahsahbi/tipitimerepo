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
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProject;
	private String nameProject;
	private boolean invoiceable;
	private List<Category> categories;
	private List<TimetrackingProject> timetrackingProjects;

	@Id
	@SequenceGenerator(name = "projectSeq", sequenceName = "project_idproject_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	@OneToMany(mappedBy = "project")
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public boolean isInvoiceable() {
		return invoiceable;
	}

	public void setInvoiceable(boolean invoiceable) {
		this.invoiceable = invoiceable;
	}

	@OneToMany(mappedBy = "project")
	public List<TimetrackingProject> getTimetrackingProjects() {
		return timetrackingProjects;
	}

	public void setTimetrackingProjects(List<TimetrackingProject> timetrackingProjects) {
		this.timetrackingProjects = timetrackingProjects;
	}

}
