package sessionbeans.project;

import java.util.List;

import javax.ejb.Local;

import persistence.Project;

@Local
public interface ProjectBeanLocal {
	void addProject(Project project);

	void editProject(Project project);

	void deleteProject(Project project);

	Project getProjectById(int id);

	List<Project> getAllProjects();

}
