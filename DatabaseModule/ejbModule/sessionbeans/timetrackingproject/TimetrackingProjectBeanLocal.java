package sessionbeans.timetrackingproject;

import java.util.List;

import javax.ejb.Local;

import persistence.TimetrackingProject;
import persistence.TimetrackingProjectPK;

@Local
public interface TimetrackingProjectBeanLocal {
	void addTimetrackingProject(TimetrackingProject timetrackingProject);

	void editTimetrackingProject(TimetrackingProject timetrackingProject);

	void deleteTimetrackingproject(TimetrackingProject timetrackingProject);

	TimetrackingProject getTimetrackingProjectById(TimetrackingProjectPK timetrackingProjectPK);

	List<TimetrackingProject> getAllTimetrackingProjects();

	List<TimetrackingProject> getAllTimetrackingProjectsByTimetracking(int idTimetracking);

}
