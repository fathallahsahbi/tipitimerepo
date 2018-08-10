package sessionbeans.stafftimetracking;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.StaffTimetracking;
import persistence.StaffTimetrackingPK;

/**
 * Session Bean implementation class StaffTimetrackingBean
 */
@Stateless
@LocalBean
public class StaffTimetrackingBean implements StaffTimetrackingBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public StaffTimetrackingBean() {
	}

	@Override
	public void addStaffTimetracking(StaffTimetracking staffTimetracking) {
		entityManager.persist(staffTimetracking);
	}

	@Override
	public void editStaffTimetracking(StaffTimetracking staffTimetracking) {
		entityManager.merge(staffTimetracking);
	}

	@Override
	public void deleteStaffTimetracking(StaffTimetracking staffTimetracking) {
		entityManager.remove(entityManager.merge(staffTimetracking));
	}

	@Override
	public StaffTimetracking getStaffTimetrackingById(StaffTimetrackingPK staffTimetrackingPK) {
		return entityManager.find(StaffTimetracking.class, staffTimetrackingPK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StaffTimetracking> getAllStaffTimetrackings() {
		try {
			Query query = entityManager.createQuery("select s from StaffTimetracking s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}
}
