package bit.com.a.dto;

public class DeliAcceptDto {
	//배송수락시 필요한 dto
	
	private int obNum; //주문번호
	private String id;	//배달원 아이디
	private String name;	// 배달원 이름
	private String phone;	// 배달원 전화번호
	public DeliAcceptDto(int obNum, String id, String name, String phone) {
		super();
		this.obNum = obNum;
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getObNum() {
		return obNum;
	}
	public void setObNum(int obNum) {
		this.obNum = obNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "DeliAcceptDto [obNum=" + obNum + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
}
