package sessionbeans.timetrackingproject;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.TimetrackingProject;
import persistence.TimetrackingProjectPK;

/**
 * Session Bean implementation class TimetrackingProjectBean
 */
@Stateless
@LocalBean
public class TimetrackingProjectBean implements TimetrackingProjectBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public TimetrackingProjectBean() {
	}

	@Override
	public void addTimetrackingProject(TimetrackingProject timetrackingProject) {
		entityManager.persist(timetrackingProject);
	}

	@Override
	public void editTimetrackingProject(TimetrackingProject timetrackingProject) {
		entityManager.merge(timetrackingProject);
	}

	@Override
	public void deleteTimetrackingproject(TimetrackingProject timetrackingProject) {
		entityManager.remove(entityManager.merge(timetrackingProject));
	}

	@Override
	public TimetrackingProject getTimetrackingProjectById(TimetrackingProjectPK timetrackingProjectPK) {
		return entityManager.find(TimetrackingProject.class, timetrackingProjectPK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimetrackingProject> getAllTimetrackingProjects() {
		try {
			Query query = entityManager.createQuery("select t from TimetrackingProject t");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimetrackingProject> getAllTimetrackingProjectsByTimetracking(int idTimetracking) {
		try {
			Query query = entityManager.createQuery("select t from TimetrackingProject t where t.idTimetracking=:id")
					.setParameter("id", idTimetracking);
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

}
