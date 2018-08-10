package sessionbeans.category;

import java.util.List;

import javax.ejb.Local;

import persistence.Category;

@Local
public interface CategoryBeanLocal {

	void addCategory(Category category);

	void editCategory(Category category);

	void deleteCategory(Category category);

	Category getCategoryById(int id);

	List<Category> getAllCategorys();

	List<Category> getAllCategoriesByProject(int idProject);

}
