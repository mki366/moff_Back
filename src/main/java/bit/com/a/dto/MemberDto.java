package bit.com.a.dto;

public class MemberDto {

	private int memNum;
	private String id; //아이디
	private String pwd;	//비밀번호
	private String name;	//이름
	private String nickname;	//닉네임
	private String email;	//이메일
	private String address;	//주소
	private String phone;	//핸드폰번호
	private String bdate;	//생일
	private String jdate;	//가입일
	private int memDel;		
	private int memPoint;
	private int memberType; 
	private int deliveryAdmi; //0미승인, 1 승인
	private String license;	//민증
	private String bank;	//사본
	private String carNum;	//신고증
	
	public MemberDto() {
	}

	public MemberDto(int memNum, String id, String pwd, String name, String nickname, String email, String address,
			String phone, String bdate, String jdate, int memDel, int memPoint, int memberType, int deliveryAdmi,
			String license, String bank, String carNum) {
		super();
		this.memNum = memNum;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.bdate = bdate;
		this.jdate = jdate;
		this.memDel = memDel;
		this.memPoint = memPoint;
		this.memberType = memberType;
		this.deliveryAdmi = deliveryAdmi;
		this.license = license;
		this.bank = bank;
		this.carNum = carNum;
	}

	public MemberDto(String id) {
		   super();
		   this.id = id;
	}
	
	public MemberDto(String id, String pwd, String name, String nickname, String email, String address, String phone,
			String bdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.bdate = bdate;
	}

	public MemberDto(String id, String pwd, String name, String nickname, String email, String address, String phone,
			String bdate, String license, String bank, String carNum) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.bdate = bdate;
		this.license = license;
		this.bank = bank;
		this.carNum = carNum;
	}
	
	

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	public int getMemDel() {
		return memDel;
	}

	public void setMemDel(int memDel) {
		this.memDel = memDel;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public int getDeliveryAdmi() {
		return deliveryAdmi;
	}

	public void setDeliveryAdmi(int deliveryAdmi) {
		this.deliveryAdmi = deliveryAdmi;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	@Override
	public String toString() {
		return "MemberDto [memNum=" + memNum + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname="
				+ nickname + ", email=" + email + ", address=" + address + ", phone=" + phone + ", bdate=" + bdate
				+ ", jdate=" + jdate + ", memDel=" + memDel + ", memPoint=" + memPoint + ", memberType=" + memberType
				+ ", deliveryAdmi=" + deliveryAdmi + ", license=" + license + ", bank=" + bank + ", carNum=" + carNum
				+ "]";
	}

	
}