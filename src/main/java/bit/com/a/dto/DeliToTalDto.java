package bit.com.a.dto;

public class DeliToTalDto {
	//주문내역과 배송상태 확인가능하게
	private int obNum;
	private String name;
	private int quantify;
	private int price;
	private String obName;
	private String obPhone;
	private String obAddress;
	private String obDate;
	private String sta;
	private String did;
	private String dname;
	
	public DeliToTalDto() {
		// TODO Auto-generated constructor stub
	}

	public DeliToTalDto(int obNum, String name, int quantify, int price, String obName, String obPhone,
			String obAddress, String obDate, String sta, String did, String dname) {
		super();
		this.obNum = obNum;
		this.name = name;
		this.quantify = quantify;
		this.price = price;
		this.obName = obName;
		this.obPhone = obPhone;
		this.obAddress = obAddress;
		this.obDate = obDate;
		this.sta = sta;
		this.did = did;
		this.dname = dname;
	}

	public int getObNum() {
		return obNum;
	}

	public void setObNum(int obNum) {
		this.obNum = obNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantify() {
		return quantify;
	}

	public void setQuantify(int quantify) {
		this.quantify = quantify;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getObName() {
		return obName;
	}

	public void setObName(String obName) {
		this.obName = obName;
	}

	public String getObPhone() {
		return obPhone;
	}

	public void setObPhone(String obPhone) {
		this.obPhone = obPhone;
	}

	public String getObAddress() {
		return obAddress;
	}

	public void setObAddress(String obAddress) {
		this.obAddress = obAddress;
	}

	public String getObDate() {
		return obDate;
	}

	public void setObDate(String obDate) {
		this.obDate = obDate;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "DeliToTalDto [obNum=" + obNum + ", name=" + name + ", quantify=" + quantify + ", price=" + price
				+ ", obName=" + obName + ", obPhone=" + obPhone + ", obAddress=" + obAddress + ", obDate=" + obDate
				+ ", sta=" + sta + ", did=" + did + ", dname=" + dname + "]";
	}
	
	
	
	
}
