package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLog;
	private String nameAction;
	private Date dateAction;
	private String staffAction;

	@Id
	@SequenceGenerator(name = "logSeq", sequenceName = "log_idlog_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logSeq")
	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}

	public String getStaffAction() {
		return staffAction;
	}

	public void setStaffAction(String staffAction) {
		this.staffAction = staffAction;
	}

}
