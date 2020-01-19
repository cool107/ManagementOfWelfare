package welfare.vo;

public class ShowHandicap {
	private String ctId;
	private String ctName;
	private String address;
	private String regiDate;
	private String ctType;
	private String employeeId;
	private String handiType;
	private String handiGrade;
	private String dayCare;
	private String handiHelper;

	public ShowHandicap() {
		
	}

	public ShowHandicap(String ctId, String ctName, String address, String regiDate, String ctType, String employeeId,
			String handiType, String handiGrade, String dayCare, String handiHelper) {
		super();
		this.ctId = ctId;
		this.ctName = ctName;
		this.address = address;
		this.regiDate = regiDate;
		this.ctType = ctType;
		this.employeeId = employeeId;
		this.handiType = handiType;
		this.handiGrade = handiGrade;
		this.dayCare = dayCare;
		this.handiHelper = handiHelper;
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

	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
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

	public String getHandiType() {
		return handiType;
	}

	public void setHandiType(String handiType) {
		this.handiType = handiType;
	}

	public String getHandiGrade() {
		return handiGrade;
	}

	public void setHandiGrade(String handiGrade) {
		this.handiGrade = handiGrade;
	}

	public String getDayCare() {
		return dayCare;
	}

	public void setDayCare(String dayCare) {
		this.dayCare = dayCare;
	}

	public String getHandiHelper() {
		return handiHelper;
	}

	public void setHandiHelper(String handiHelper) {
		this.handiHelper = handiHelper;
	}

	@Override
	public String toString() {
		return "장애인대상자 [대상자Id: " + ctId + ", 이름: " + ctName + ", 주소: " + address + ", 등록일: " + regiDate
				+ ", 대상유형: " + ctType + ", 직원Id: " + employeeId + ", 장애유형: " + handiType + ", 장애등급: "
				+ handiGrade + ", 시설이용유무: " + dayCare + ", 요양보호사파견: " + handiHelper + "]";
	}

}
