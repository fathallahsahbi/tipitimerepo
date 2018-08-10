package sessionbeans.staff;

import java.util.List;

import javax.ejb.Local;

import persistence.Staff;

@Local
public interface StaffBeanLocal {
	void addStaff(Staff staff);

	void editStaff(Staff staff);

	void deleteStaff(Staff staff);

	Staff getStaffById(int id);

	List<Staff> getAllStaffs();

}
