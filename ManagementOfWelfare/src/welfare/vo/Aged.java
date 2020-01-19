package welfare.vo;

public class Aged {
	private boolean status;
	private String agedGrade;
	private boolean food;
	private boolean emotional;
	private boolean agedHelper;
	private String ctId;

	public Aged() {
		// TODO Auto-generated constructor stub
	}

	public Aged(boolean status, String agedGrad, boolean food, boolean emotional, boolean agedHelper, String ctId) {
		super();
		this.status = status;
		this.agedGrade = agedGrad;
		this.food = food;
		this.emotional = emotional;
		this.agedHelper = agedHelper;
		this.ctId = ctId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAgedGrad() {
		return agedGrade;
	}

	public void setAgedGrad(String agedGrad) {
		this.agedGrade = agedGrad;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isEmotional() {
		return emotional;
	}

	public void setEmotional(boolean emotional) {
		this.emotional = emotional;
	}

	public boolean isAgedHelper() {
		return agedHelper;
	}

	public void setAgedHelper(boolean agedHelper) {
		this.agedHelper = agedHelper;
	}

	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
	public String tfStatus() {
		String tf;
		if(this.isStatus()==true) {
			tf= "거동가능";
		}else {
			tf= "거동불가";
		}
		return tf;
	}
	public String tfFood() {
		String tf;
		if(this.isFood()==true) {
			tf= "O";
		}else {
			tf= "X";
		}
		return tf;
	}
	
	public String tfEmotional() {
		String tf;
		if(this.isEmotional()==true) {
			tf= "O";
		}else {
			tf= "X";
		}
		return tf;
	}
	
	public String tfAgedHelper() {
		String tf;
		if(this.isAgedHelper()==true) {
			tf= "O";
		}else {
			tf= "X";
		}
		return tf;
	}
	
	@Override
	public String toString() {
		return "노인대상자 [거동상태: " + tfStatus() + ", 위험등급: " + agedGrade + ", 식사지원서비스지원: " + tfFood() + ", 정서지원서비스지원: " + tfEmotional()
				+ ", 요양보호사파견: " + tfAgedHelper() + ", 대상자ID: " + ctId + "]";
	}

}
