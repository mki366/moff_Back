package bit.com.a.dto;

public class ExpertUsersParam {
	private String id;
	private String pwd;
	private String name;
	private String email1;
	private String email2;
	
	private String year;
	private String month;
	private String day;
	
	private int experType;//프리랜서 1 개인사업자 2 법인사업자 3
	//private String idCard;
	//private String registration;//사업자등록증
	private String regisName;//등록상호
	
	private String regiNumber1; //사업자번호
	private String regiNumber2;
	private String regiNumber3;
	
	private String ceoName;
	
	private String address1;
	private String address2;
	
	private int part;//시공분야 종합인테리어 1 , 도배 타일만 2
	private String expertInfo;
	private String phone;
	
	
	
	public ExpertUsersParam() {
		// TODO Auto-generated constructor stub
	}

	

	


	

	



	public ExpertUsersParam(String id, String pwd, String name, String email1, String email2, String year, String month,
			String day, int experType, String regisName, String regiNumber1, String regiNumber2, String regiNumber3,
			String ceoName, String address1, String address2, int part, String expertInfo, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email1 = email1;
		this.email2 = email2;
		this.year = year;
		this.month = month;
		this.day = day;
		this.experType = experType;
		this.regisName = regisName;
		this.regiNumber1 = regiNumber1;
		this.regiNumber2 = regiNumber2;
		this.regiNumber3 = regiNumber3;
		this.ceoName = ceoName;
		this.address1 = address1;
		this.address2 = address2;
		this.part = part;
		this.expertInfo = expertInfo;
		this.phone = phone;
	}












	





	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getExperType() {
		return experType;
	}

	public void setExperType(int experType) {
		this.experType = experType;
	}

	public String getRegisName() {
		return regisName;
	}

	public void setRegisName(String regisName) {
		this.regisName = regisName;
	}

	public String getRegiNumber1() {
		return regiNumber1;
	}

	public void setRegiNumber1(String regiNumber1) {
		this.regiNumber1 = regiNumber1;
	}

	public String getRegiNumber2() {
		return regiNumber2;
	}

	public void setRegiNumber2(String regiNumber2) {
		this.regiNumber2 = regiNumber2;
	}

	public String getRegiNumber3() {
		return regiNumber3;
	}

	public void setRegiNumber3(String regiNumber3) {
		this.regiNumber3 = regiNumber3;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public String getExpertInfo() {
		return expertInfo;
	}

	public void setExpertInfo(String expertInfo) {
		this.expertInfo = expertInfo;
	}












	@Override
	public String toString() {
		return "ExperUsersParam [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email1=" + email1 + ", email2="
				+ email2 + ", year=" + year + ", month=" + month + ", day=" + day + ", experType=" + experType
				+ ", regisName=" + regisName + ", regiNumber1=" + regiNumber1 + ", regiNumber2=" + regiNumber2
				+ ", regiNumber3=" + regiNumber3 + ", ceoName=" + ceoName + ", address1=" + address1 + ", address2="
				+ address2 + ", part=" + part + ", expertInfo=" + expertInfo + ", phone=" + phone + "]";
	}









	
	
	
	
	
}
