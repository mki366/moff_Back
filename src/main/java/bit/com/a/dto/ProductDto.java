package bit.com.a.dto;

public class ProductDto {

	private int prodNum;
	private String category;
	private String subCategory;
	private String prodName;
	private String color;
	private String prodOption;
	private String info;
	private int weight;
	private int oriPrice;
	private int price;
	private int quantity;
	private String rdate;
	private int deliveryCost;
	private String filename;
	
	public ProductDto() {
	}

	public ProductDto(int prodNum, String category, String subCategory, String prodName, String color,
			String prodOption, String info, int weight, int oriPrice, int price, int quantity, String rdate,
			int deliveryCost, String filename) {
		super();
		this.prodNum = prodNum;
		this.category = category;
		this.subCategory = subCategory;
		this.prodName = prodName;
		this.color = color;
		this.prodOption = prodOption;
		this.info = info;
		this.weight = weight;
		this.oriPrice = oriPrice;
		this.price = price;
		this.quantity = quantity;
		this.rdate = rdate;
		this.deliveryCost = deliveryCost;
		this.filename = filename;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getOriPrice() {
		return oriPrice;
	}

	public void setOriPrice(int oriPrice) {
		this.oriPrice = oriPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "ProductDto [prodNum=" + prodNum + ", category=" + category + ", subCategory=" + subCategory
				+ ", prodName=" + prodName + ", color=" + color + ", prodOption=" + prodOption + ", info=" + info
				+ ", weight=" + weight + ", oriPrice=" + oriPrice + ", price=" + price + ", quantity=" + quantity
				+ ", rdate=" + rdate + ", deliveryCost=" + deliveryCost + ", filename=" + filename + "]";
	}
	
	
}

