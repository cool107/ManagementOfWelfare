package welfare.vo;

public class ShowAged {
	private String ctId;
	private String ctName;
	private String address;
	private String regiDate;
	private String ctType;
	private String employeeId;
	private String status;
	private String agedGrade;
	private String food;
	private String emotional;
	private String agedHelper;

	public ShowAged() {
		// TODO Auto-generated constructor stub
	}

	public ShowAged(String ctId, String ctName, String address, String regiDate, String ctType, String employeeId,
			String status, String agedGrad, String food, String emotional, String agedHelper) {
		super();
		this.ctId = ctId;
		this.ctName = ctName;
		this.address = address;
		this.regiDate = regiDate;
		this.ctType = ctType;
		this.employeeId = employeeId;
		this.status = status;
		this.agedGrade = agedGrad;
		this.food = food;
		this.emotional = emotional;
		this.agedHelper = agedHelper;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgedGrad() {
		return agedGrade;
	}

	public void setAgedGrad(String agedGrad) {
		this.agedGrade = agedGrad;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getEmotional() {
		return emotional;
	}

	public void setEmotional(String emotional) {
		this.emotional = emotional;
	}

	public String getAgedHelper() {
		return agedHelper;
	}

	public void setAgedHelper(String agedHelper) {
		this.agedHelper = agedHelper;
	}

	@Override
	public String toString() {
		return "노인대상자 [대상자Id=" + ctId + ", 이름: " + ctName + ", 주소: " + address + ", 등록일: " + regiDate + ", 대상유형: "
				+ ctType + ", 직원Id: " + employeeId + ", 거동상태: " + status + ", 위험등급: " + agedGrade + ", 식사지원서비스지원: "
				+ food + ", 정서지원서비스지원: " + emotional + ", 요양보호사파견: " + agedHelper + "]";
	}

}
