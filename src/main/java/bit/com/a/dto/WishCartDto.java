package bit.com.a.dto;

public class WishCartDto {
	
	private int cNum;
	private String id;
	private int prodNum;
	private int quantity;
	private int cartORwish; 	// wish 0 // cart 1 
	
	private String prodName;
	private String color;
	private String prodOption;
	private String price;
	private String filename;
	private int weight;

	public WishCartDto() {
	}

	public WishCartDto(int cNum, String id, int prodNum, int quantity, int cartORwish, String prodName, String color,
			String prodOption, String price, String filename, int weight) {
		super();
		this.cNum = cNum;
		this.id = id;
		this.prodNum = prodNum;
		this.quantity = quantity;
		this.cartORwish = cartORwish;
		this.prodName = prodName;
		this.color = color;
		this.prodOption = prodOption;
		this.price = price;
		this.filename = filename;
		this.weight = weight;
	}
	
	

	public WishCartDto(String id, int prodNum) {
		super();
		this.id = id;
		this.prodNum = prodNum;
	}
	
	

	public WishCartDto(String id, int prodNum, int quantity) {
		super();
		this.id = id;
		this.prodNum = prodNum;
		this.quantity = quantity;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartORwish() {
		return cartORwish;
	}

	public void setCartORwish(int cartORwish) {
		this.cartORwish = cartORwish;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		return "WishCartDto [cNum=" + cNum + ", id=" + id + ", prodNum=" + prodNum + ", quantity=" + quantity
				+ ", cartORwish=" + cartORwish + ", prodName=" + prodName + ", color=" + color + ", prodOption="
				+ prodOption + ", price=" + price + ", filename=" + filename + "]";
	}

	
}
