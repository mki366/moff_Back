package bit.com.a.dto;

public class PurchasesDto {

	private String id;
	private int obNum;
	private String obName;
	private String obDate;
	private String obWay;
	private String obPhone;
	private String obAddress;
	private String obMes;
	private String obCardN;
	private int totalPrice;
	
	private int prodNum;
	private String prodName;
	private int quantity;
	private int price;
	private String color;
	private String prodOption;
	private String filename;
	
	private String status;
	private String name;
	private String phone;
	private int cnt;
	
	public PurchasesDto() {
	}

	public PurchasesDto(String id, int obNum, String obName, String obDate, String obWay, String obPhone,
			String obAddress, String obMes, String obCardN, int totalPrice, int prodNum, String prodName, int quantity,
			int price, String color, String prodOption, String filename, String status, String name, String phone,
			int cnt) {
		super();
		this.id = id;
		this.obNum = obNum;
		this.obName = obName;
		this.obDate = obDate;
		this.obWay = obWay;
		this.obPhone = obPhone;
		this.obAddress = obAddress;
		this.obMes = obMes;
		this.obCardN = obCardN;
		this.totalPrice = totalPrice;
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.color = color;
		this.prodOption = prodOption;
		this.filename = filename;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.cnt = cnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getObNum() {
		return obNum;
	}

	public void setObNum(int obNum) {
		this.obNum = obNum;
	}

	public String getObDate() {
		return obDate;
	}

	public void setObDate(String obDate) {
		this.obDate = obDate;
	}

	public String getObWay() {
		return obWay;
	}

	public void setObWay(String obWay) {
		this.obWay = obWay;
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

	public String getObMes() {
		return obMes;
	}

	public void setObMes(String obMes) {
		this.obMes = obMes;
	}

	public String getObCardN() {
		return obCardN;
	}

	public void setObCardN(String obCardN) {
		this.obCardN = obCardN;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProdOption() {
		return prodOption;
	}

	public void setProdOption(String prodOption) {
		this.prodOption = prodOption;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getObName() {
		return obName;
	}

	public void setObName(String obName) {
		this.obName = obName;
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

	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "PurchasesDto [id=" + id + ", obNum=" + obNum + ", obName=" + obName + ", obDate=" + obDate + ", obWay="
				+ obWay + ", obPhone=" + obPhone + ", obAddress=" + obAddress + ", obMes=" + obMes + ", obCardN="
				+ obCardN + ", totalPrice=" + totalPrice + ", prodNum=" + prodNum + ", prodName=" + prodName
				+ ", quantity=" + quantity + ", price=" + price + ", color=" + color + ", prodOption=" + prodOption
				+ ", filename=" + filename + ", status=" + status + ", name=" + name + ", phone=" + phone + ", cnt="
				+ cnt + "]";
	}

}
