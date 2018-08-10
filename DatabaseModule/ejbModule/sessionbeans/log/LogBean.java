package sessionbeans.log;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Log;

/**
 * Session Bean implementation class LogBean
 */
@Stateless
@LocalBean
public class LogBean implements LogBeanLocal {

	@PersistenceContext
	EntityManager entityManager;

	public LogBean() {
	}

	@Override
	public void addLog(Log log) {
		entityManager.persist(log);
	}

	@Override
	public void editLog(Log log) {
		entityManager.merge(log);
	}

	@Override
	public void deleteLog(Log log) {
		entityManager.remove(entityManager.merge(log));
	}

	@Override
	public Log getLogById(int id) {
		return entityManager.find(Log.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> getAllLogs() {
		try {
			Query query = entityManager.createQuery("select s from Log s");
			return query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}
}
