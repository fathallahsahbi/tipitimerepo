package sessionbeans.stafftimetracking;

import java.util.List;

import javax.ejb.Local;

import persistence.StaffTimetracking;
import persistence.StaffTimetrackingPK;;

@Local
public interface StaffTimetrackingBeanLocal {
	void addStaffTimetracking(StaffTimetracking staffTimetracking);

	void editStaffTimetracking(StaffTimetracking staffTimetracking);

	void deleteStaffTimetracking(StaffTimetracking staffTimetracking);

	StaffTimetracking getStaffTimetrackingById(StaffTimetrackingPK staffTimetrackingPK);

	List<StaffTimetracking> getAllStaffTimetrackings();

}
