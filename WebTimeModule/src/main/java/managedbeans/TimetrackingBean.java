package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import persistence.Category;
import persistence.Timetracking;
import persistence.TimetrackingProject;
import renderers.EntryRenderer;
import sessionbeans.category.CategoryBeanLocal;
import sessionbeans.timetracking.TimetrackingBeanLocal;
import sessionbeans.timetrackingproject.TimetrackingProjectBeanLocal;

@Named
@SessionScoped
public class TimetrackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// declare arraylists
	private List<EntryRenderer> entryRenderers = new ArrayList<>();
	private List<Timetracking> timetrackings = new ArrayList<>();
	private List<TimetrackingProject> projects = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private Timetracking currentTimetracking;

	// dependency injection
	@Inject
	TimetrackingBeanLocal timetrackingBeanLocal;
	@Inject
	TimetrackingProjectBeanLocal timetrackingProjectBeanLocal;
	@Inject
	CategoryBeanLocal categoryBeanLocal;

	/**
	 * Managed bean constructor
	 * 
	 * @author Safubi
	 * @since upcoming version
	 * 
	 */
	@PostConstruct
	public void init() {
		// need to prepare data for renderer
		timetrackings = timetrackingBeanLocal.getAllTimetrackings();
		currentTimetracking = timetrackingBeanLocal.getTimetrackingById(1);
		projects = timetrackingProjectBeanLocal
				.getAllTimetrackingProjectsByTimetracking(currentTimetracking.getIdTimetracking());
		EntryRenderer entryRenderer = new EntryRenderer();
		entryRenderer.setDate(new Date());
		entryRenderer.setProject("");
		entryRenderer.setCategory("");
		entryRenderer.setEntry(0);
		entryRenderers.add(entryRenderer);
	}

	/**
	 * Method to add a new entry to timetracking
	 * 
	 * @author Safubi
	 * @since upcoming version
	 * @param ajaxBehaviorEvent
	 *            listener for Ajax event
	 */
	public void addNewEntry(AjaxBehaviorEvent ajaxBehaviorEvent) {
		EntryRenderer entryRenderer = new EntryRenderer();
		entryRenderer.setDate(new Date());
		entryRenderer.setProject("");
		entryRenderer.setCategory("");
		entryRenderer.setEntry(0);
		entryRenderers.add(entryRenderer);
	}

	/**
	 * Method to remove entry
	 * 
	 * @author Safubi
	 * @since upcoming version
	 * @param ajaxBehaviorEvent
	 *            listener for Ajax event
	 */
	public void removeEntry(AjaxBehaviorEvent ajaxBehaviorEvent) {
		int index = (int) ajaxBehaviorEvent.getComponent().getAttributes().get("index");
		entryRenderers.remove(index);
	}

	public void projectSelectionChangeListener(AjaxBehaviorEvent ajaxBehaviorEvent) {
		int idProject = (int) ajaxBehaviorEvent.getComponent().getAttributes().get("idProject");
		if (categoryBeanLocal.getAllCategoriesByProject(idProject) != null
				&& categoryBeanLocal.getAllCategoriesByProject(idProject).size() != 0) {
			categories = categoryBeanLocal.getAllCategoriesByProject(idProject);
		}
	}

	// getters & setters
	public List<EntryRenderer> getEntryRenderers() {
		return entryRenderers;
	}

	public void setEntryRenderers(List<EntryRenderer> entryRenderers) {
		this.entryRenderers = entryRenderers;
	}

	public List<Timetracking> getTimetrackings() {
		return timetrackings;
	}

	public void setTimetrackings(List<Timetracking> timetrackings) {
		this.timetrackings = timetrackings;
	}

	public List<TimetrackingProject> getProjects() {
		return projects;
	}

	public void setProjects(List<TimetrackingProject> projects) {
		this.projects = projects;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Timetracking getCurrentTimetracking() {
		return currentTimetracking;
	}

	public void setCurrentTimetracking(Timetracking currentTimetracking) {
		this.currentTimetracking = currentTimetracking;
	}

}
