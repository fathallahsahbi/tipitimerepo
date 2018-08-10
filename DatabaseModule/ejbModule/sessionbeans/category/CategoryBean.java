package sessionbeans.category;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Category;

/**
 * Session Bean implementation class CategoryBean
 */
@Stateless
@LocalBean
public class CategoryBean implements CategoryBeanLocal {

	@PersistenceContext
	EntityManager entityManager;

	public CategoryBean() {
	}

	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
	}

	@Override
	public void editCategory(Category category) {
		entityManager.merge(category);
	}

	@Override
	public void deleteCategory(Category category) {
		entityManager.remove(entityManager.merge(category));
	}

	@Override
	public Category getCategoryById(int id) {
		return entityManager.find(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategorys() {
		try {
			Query query = entityManager.createQuery("select s from Category s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategoriesByProject(int idProject) {
		try {
			Query query = entityManager.createQuery("select c from Category c where c.idProject=:id").setParameter("id",
					idProject);
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

}
