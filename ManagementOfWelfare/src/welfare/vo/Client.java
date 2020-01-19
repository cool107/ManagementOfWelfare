package welfare.vo;

import java.sql.Date;

public class Client {
	private String ctId;
	private String ctName;
	private String address;
	private Date regiDate;
	private String ctType;
	private String employeeId;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String ctId, String ctName, String address, Date regiDate, String ctType, String employeeId) {
		super();
		this.ctId = ctId;
		this.ctName = ctName;
		this.address = address;
		this.regiDate = regiDate;
		this.ctType = ctType;
		this.employeeId = employeeId;
	}

	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public String getCtType() {
		return ctType;
	}

	public void setCtType(String ctType) {
		this.ctType = ctType;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "대상자 [대상자Id: " + ctId + ", 이름: " + ctName + ", 주소: " + address + ", 등록일: " + regiDate
				+ ", 대상유형: " + ctType + ", 담당직원id: " + employeeId + "]";
	}

}
