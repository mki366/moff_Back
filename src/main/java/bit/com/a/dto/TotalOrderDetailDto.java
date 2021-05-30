package bit.com.a.dto;

public class TotalOrderDetailDto {
	private int prodNum;
	private String prodName;
	private int quantity;
	private int price;
	private int deliveryCost;
	private String color;
	private String prodOption;
	private String filename;
	private int weight;
	
	public TotalOrderDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public TotalOrderDetailDto(int prodNum, String prodName, int quantity, int price, int deliveryCost, String color,
			String prodOption, String filename, int weight) {
		super();
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.deliveryCost = deliveryCost;
		this.color = color;
		this.prodOption = prodOption;
		this.filename = filename;
		this.weight = weight;
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

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "TotalOrderDetailDto [prodNum=" + prodNum + ", prodName=" + prodName + ", quantity=" + quantity
				+ ", price=" + price + ", deliveryCost=" + deliveryCost + ", color=" + color + ", prodOption="
				+ prodOption + ", filename=" + filename + ", weight=" + weight + "]";
	}

	
	
}
