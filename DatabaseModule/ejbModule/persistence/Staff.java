package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Staff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStaff;
	private String staffName;
	private int baseSalary;
	private String email;
	private String password;
	private List<StaffTimetracking> staffTimetrackings;

	@Id
	@SequenceGenerator(name = "staffSeq", sequenceName = "staff_idstaff_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staffSeq")
	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "staff")
	public List<StaffTimetracking> getStaffTimetrackings() {
		return staffTimetrackings;
	}

	public void setStaffTimetrackings(List<StaffTimetracking> staffTimetrackings) {
		this.staffTimetrackings = staffTimetrackings;
	}

}
