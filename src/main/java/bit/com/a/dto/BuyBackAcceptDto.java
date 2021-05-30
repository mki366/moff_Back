package bit.com.a.dto;

public class BuyBackAcceptDto {
	private int bNum; //주문번호
	private String bId;	//배달원 아이디
	private String bName;	// 배달원 이름
	private String bPhone;	// 배달원 전화번호
	
	public BuyBackAcceptDto() {
		// TODO Auto-generated constructor stub
	}

	public BuyBackAcceptDto(int bNum, String bId, String bName, String bPhone) {
		super();
		this.bNum = bNum;
		this.bId = bId;
		this.bName = bName;
		this.bPhone = bPhone;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbPhone() {
		return bPhone;
	}

	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	@Override
	public String toString() {
		return "BuyBackAcceptDto [bNum=" + bNum + ", bId=" + bId + ", bName=" + bName + ", bPhone=" + bPhone + "]";
	}
	
	
}
