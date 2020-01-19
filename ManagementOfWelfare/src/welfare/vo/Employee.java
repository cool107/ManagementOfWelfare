package welfare.vo;

import java.sql.Date;

public class Employee {
	private String employeeId;
	private String eName;
	private String department;
	private String position;
	private Date enterDate;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeId, String eName, String department, String position, Date enterDate) {
		super();
		this.employeeId = employeeId;
		this.eName = eName;
		this.department = department;
		this.position = position;
		this.enterDate = enterDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String toString() {
		return "직원 Id: " + employeeId + ", 담당부서: " + department + ", 직책: " + position + ", 입사일: " + enterDate + ", 이름: "
				+ eName + "]";
	}

}
