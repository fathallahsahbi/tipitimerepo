package sessionbeans.log;

import java.util.List;

import javax.ejb.Local;

import persistence.Log;

@Local
public interface LogBeanLocal {

	void addLog(Log log);

	void editLog(Log log);

	void deleteLog(Log log);

	Log getLogById(int id);

	List<Log> getAllLogs();

}
