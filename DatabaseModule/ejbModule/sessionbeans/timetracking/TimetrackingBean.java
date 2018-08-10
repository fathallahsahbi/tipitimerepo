package sessionbeans.timetracking;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Timetracking;

/**
 * Session Bean implementation class TimetrackingBean
 */
@Stateless
@LocalBean
public class TimetrackingBean implements TimetrackingBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public TimetrackingBean() {
	}

	@Override
	public void addTimetracking(Timetracking timetracking) {
		entityManager.persist(timetracking);
	}

	@Override
	public void editTimetracking(Timetracking timetracking) {
		entityManager.merge(timetracking);
	}

	@Override
	public void deleteTimetracking(Timetracking timetracking) {
		entityManager.remove(entityManager.merge(timetracking));
	}

	@Override
	public Timetracking getTimetrackingById(int id) {
		return entityManager.find(Timetracking.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timetracking> getAllTimetrackings() {
		try {
			Query query = entityManager.createQuery("select s from Timetracking s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}
}
