package bit.com.a.dto;

public class ExpertUsersDto {
	private int eNUM;
	private String id;
	private String pwd;
	private String name;
	private String nickName;
	private String email;
	private String address;
	private String bDate;
	private String phone;
	
	private int experType;
	private String idCard;
	private String registration;
	private String regisName;
	private String regiNumber;
	private String ceoName;
	private String regAddress;
	
	
	private int part;//시공분야 종합인테리어 1 , 도배 타일만 2
	private String expertInfo;
	private String image;
	
	
	private String imageDetail1;
	private String imageDetail2;
	private String imageDetail3;
	
	private int recentCon;
	private int review;
	
	
	public ExpertUsersDto() {
		// TODO Auto-generated constructor stub
	}
	


	






	public ExpertUsersDto(int eNUM, String id, String pwd, String name, String nickName, String email, String address,
			String bDate, String phone, int experType, String idCard, String registration, String regisName,
			String regiNumber, String ceoName, String regAddress, int part, String expertInfo, String image,
			String imageDetail1, String imageDetail2, String imageDetail3, int recentCon, int review) {
		super();
		this.eNUM = eNUM;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.bDate = bDate;
		this.phone = phone;
		this.experType = experType;
		this.idCard = idCard;
		this.registration = registration;
		this.regisName = regisName;
		this.regiNumber = regiNumber;
		this.ceoName = ceoName;
		this.regAddress = regAddress;
		this.part = part;
		this.expertInfo = expertInfo;
		this.image = image;
		this.imageDetail1 = imageDetail1;
		this.imageDetail2 = imageDetail2;
		this.imageDetail3 = imageDetail3;
		this.recentCon = recentCon;
		this.review = review;
	}










	public ExpertUsersDto(int eNUM, String id, String pwd, String name, String nickName, String email, String address,
			String bDate, String phone, int experType, String idCard, String registration, String regisName,
			String regiNumber, String ceoName, String regAddress, int part, String expertInfo, String image,
			String imageDetail1, String imageDetail2, String imageDetail3, int recentCon) {
		super();
		this.eNUM = eNUM;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.bDate = bDate;
		this.phone = phone;
		this.experType = experType;
		this.idCard = idCard;
		this.registration = registration;
		this.regisName = regisName;
		this.regiNumber = regiNumber;
		this.ceoName = ceoName;
		this.regAddress = regAddress;
		this.part = part;
		this.expertInfo = expertInfo;
		this.image = image;
		this.imageDetail1 = imageDetail1;
		this.imageDetail2 = imageDetail2;
		this.imageDetail3 = imageDetail3;
		this.recentCon = recentCon;
	}






	



	public ExpertUsersDto(String id, String pwd, String name, String nickName, String email, String address,
			String bDate, String phone, int experType, String idCard, String registration, String regisName,
			String regiNumber, String ceoName, String regAddress, int part, String expertInfo, String image,
			String imageDetail1, String imageDetail2, String imageDetail3) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.bDate = bDate;
		this.phone = phone;
		this.experType = experType;
		this.idCard = idCard;
		this.registration = registration;
		this.regisName = regisName;
		this.regiNumber = regiNumber;
		this.ceoName = ceoName;
		this.regAddress = regAddress;
		this.part = part;
		this.expertInfo = expertInfo;
		this.image = image;
		this.imageDetail1 = imageDetail1;
		this.imageDetail2 = imageDetail2;
		this.imageDetail3 = imageDetail3;
	}










	public ExpertUsersDto(String id, String pwd, String name, String nickName, String email, String address,
			String bDate, String phone, int experType, String idCard, String registration, String regisName,
			String regiNumber, String ceoName, String regAddress, int part, String expertInfo, String image,
			String imageDetail1, String imageDetail2, String imageDetail3, int recentCon) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.bDate = bDate;
		this.phone = phone;
		this.experType = experType;
		this.idCard = idCard;
		this.registration = registration;
		this.regisName = regisName;
		this.regiNumber = regiNumber;
		this.ceoName = ceoName;
		this.regAddress = regAddress;
		this.part = part;
		this.expertInfo = expertInfo;
		this.image = image;
		this.imageDetail1 = imageDetail1;
		this.imageDetail2 = imageDetail2;
		this.imageDetail3 = imageDetail3;
		this.recentCon = recentCon;
	}





	




	public int getReview() {
		return review;
	}










	public void setReview(int review) {
		this.review = review;
	}










	public int getRecentCon() {
		return recentCon;
	}










	public void setRecentCon(int recentCon) {
		this.recentCon = recentCon;
	}










	public String getImageDetail1() {
		return imageDetail1;
	}





	public void setImageDetail1(String imageDetail1) {
		this.imageDetail1 = imageDetail1;
	}





	public String getImageDetail2() {
		return imageDetail2;
	}





	public void setImageDetail2(String imageDetail2) {
		this.imageDetail2 = imageDetail2;
	}





	public String getImageDetail3() {
		return imageDetail3;
	}





	public void setImageDetail3(String imageDetail3) {
		this.imageDetail3 = imageDetail3;
	}





	public String getImage() {
		return image;
	}







	public void setImage(String image) {
		this.image = image;
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




	public int geteNUM() {
		return eNUM;
	}

	public void seteNUM(int eNUM) {
		this.eNUM = eNUM;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getExperType() {
		return experType;
	}

	public void setExperType(int experType) {
		this.experType = experType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getRegisName() {
		return regisName;
	}

	public void setRegisName(String regisName) {
		this.regisName = regisName;
	}

	public String getRegiNumber() {
		return regiNumber;
	}

	public void setRegiNumber(String regiNumber) {
		this.regiNumber = regiNumber;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}










	@Override
	public String toString() {
		return "ExpertUsersDto [eNUM=" + eNUM + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickName="
				+ nickName + ", email=" + email + ", address=" + address + ", bDate=" + bDate + ", phone=" + phone
				+ ", experType=" + experType + ", idCard=" + idCard + ", registration=" + registration + ", regisName="
				+ regisName + ", regiNumber=" + regiNumber + ", ceoName=" + ceoName + ", regAddress=" + regAddress
				+ ", part=" + part + ", expertInfo=" + expertInfo + ", image=" + image + ", imageDetail1="
				+ imageDetail1 + ", imageDetail2=" + imageDetail2 + ", imageDetail3=" + imageDetail3 + ", recentCon="
				+ recentCon + ", review=" + review + "]";
	}











	


	
	
	
	
}
