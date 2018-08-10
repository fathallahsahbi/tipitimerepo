package sessionbeans.project;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Project;

/**
 * Session Bean implementation class ProjectBean
 */
@Stateless
@LocalBean
public class ProjectBean implements ProjectBeanLocal {

	@PersistenceContext
	EntityManager entityManager;

	public ProjectBean() {
	}

	@Override
	public void addProject(Project staff) {
		entityManager.persist(staff);
	}

	@Override
	public void editProject(Project staff) {
		entityManager.merge(staff);
	}

	@Override
	public void deleteProject(Project staff) {
		entityManager.remove(entityManager.merge(staff));
	}

	@Override
	public Project getProjectById(int id) {
		return entityManager.find(Project.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		try {
			Query query = entityManager.createQuery("select s from Project s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

}
