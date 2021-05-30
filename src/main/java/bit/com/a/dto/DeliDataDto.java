package bit.com.a.dto;

public class DeliDataDto {

	
	private String id; //아이디
	private String pwd;	//비밀번호
	private String email1;	//비밀번호
	private String email2;	//비밀번호
	
	
	private String phone;	//핸드폰번호
	
	private String year;	//생일
	private String month;	//생일
	private String day;	//생일
	

	private String address1;	//주소1
	private String address2;	//주소2
	
	private String name;	//이름본명
	private String nickname;	//닉네임

	private String jdate;	//가입일
	
	public DeliDataDto() {
		// TODO Auto-generated constructor stub
	}

	public DeliDataDto(String id, String pwd, String email1, String email2, String phone, String year, String month,
			String day, String address1, String address2, String name, String nickname, String jdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email1 = email1;
		this.email2 = email2;
		this.phone = phone;
		this.year = year;
		this.month = month;
		this.day = day;
		this.address1 = address1;
		this.address2 = address2;
		this.name = name;
		this.nickname = nickname;
		this.jdate = jdate;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getJdate() {
		return jdate;
	}

	public void setJdate(String jdate) {
		this.jdate = jdate;
	}

	@Override
	public String toString() {
		return "DeliDataDto [id=" + id + ", pwd=" + pwd + ", email1=" + email1 + ", email2=" + email2 + ", phone="
				+ phone + ", year=" + year + ", month=" + month + ", day=" + day + ", address1=" + address1
				+ ", address2=" + address2 + ", name=" + name + ", nickname=" + nickname + ", jdate=" + jdate + "]";
	}
	
	
	
	
	
}
