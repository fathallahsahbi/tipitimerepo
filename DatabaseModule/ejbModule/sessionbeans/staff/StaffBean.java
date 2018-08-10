package sessionbeans.staff;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Staff;

/**
 * Session Bean implementation class StaffBean
 */
@Stateless
@LocalBean
public class StaffBean implements StaffBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public StaffBean() {
	}

	@Override
	public void addStaff(Staff staff) {
		entityManager.persist(staff);
	}

	@Override
	public void editStaff(Staff staff) {
		entityManager.merge(staff);
	}

	@Override
	public void deleteStaff(Staff staff) {
		entityManager.remove(entityManager.merge(staff));
	}

	@Override
	public Staff getStaffById(int id) {
		return entityManager.find(Staff.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getAllStaffs() {
		try {
			Query query = entityManager.createQuery("select s from Staff s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

}
