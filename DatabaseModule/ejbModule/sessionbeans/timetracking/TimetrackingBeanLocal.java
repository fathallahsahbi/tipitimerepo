package sessionbeans.timetracking;

import java.util.List;

import javax.ejb.Local;

import persistence.Timetracking;

@Local
public interface TimetrackingBeanLocal {
	void addTimetracking(Timetracking timetracking);

	void editTimetracking(Timetracking timetracking);

	void deleteTimetracking(Timetracking timetracking);

	Timetracking getTimetrackingById(int id);

	List<Timetracking> getAllTimetrackings();

}
