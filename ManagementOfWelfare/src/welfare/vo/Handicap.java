package welfare.vo;

public class Handicap {
	private boolean handiType;
	private String handiGrade;
	private boolean dayCare;
	private boolean handiHelper;
	private String ctId;

	public Handicap() {
		// TODO Auto-generated constructor stub
	}

	public Handicap(boolean handiType, String handiGrade, boolean dayCare, boolean handiHelper, String ctId) {
		super();
		this.handiType = handiType;
		this.handiGrade = handiGrade;
		this.dayCare = dayCare;
		this.handiHelper = handiHelper;
		this.ctId = ctId;
	}


	
	public boolean isHandiType() {
		return handiType;
	}

	public void setHandiType(boolean handiType) {
		this.handiType = handiType;
	}

	public String getHandiGrade() {
		return handiGrade;
	}

	public void setHandiGrade(String handiGrade) {
		this.handiGrade = handiGrade;
	}

	public boolean isDayCare() {
		return dayCare;
	}

	public void setDayCare(boolean dayCare) {
		this.dayCare = dayCare;
	}

	public boolean isHandiHelper() {
		return handiHelper;
	}

	public void setHandiHelper(boolean handiHelper) {
		this.handiHelper = handiHelper;
	}

	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
	public String tfHandiType() {
		String tf;
		if(this.isHandiType()==true) {
			tf= "지적장애";
		}else {
			tf= "지체장애";
		}
		return tf;
	}
	
	public String tfDayCare() {
		String tf;
		if(this.isDayCare()==true) {
			tf= "O";
		}else {
			tf= "X";
		}
		return tf;
	}
	
	public String tfHandiHelper() {
		String tf;
		if(this.isHandiHelper()==true) {
			tf= "O";
		}else {
			tf= "X";
		}
		return tf;
	}

	@Override
	public String toString() {
		return "장애인대상자 [장애유형: " + tfHandiType() + ", 장애등급: " + handiGrade + ", 시설이용: " + tfDayCare()
				+ ", 활동보조인파견: " + tfHandiHelper() + ", 대상자Id: " + ctId + "]";
	}

	

}
