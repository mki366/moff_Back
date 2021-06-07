package bit.com.a.dto;

public class OrderDetailDto {
	private int odNum;		//--주문상세번호
	
	private int obNum;		//--주문번호
	private int prodNum;	//--상품번호 
	private String prodName;	//--상품이름
	private int quantity;	//--구매수량
	private int price;	//--상품판매가격
	private String color;	//색깔
	
	private String prodOption;	//
	private String filename;	//파일
	private int weight;	//상품무게
	
	private int obTakeback;	//반품여부 반품 안할시 0-> 1
	private int obExchange;	//교환여부 반품 안할시 0->1
	private String reason;	//사유
	private int exColorSeq;	//교환할 상품의 색상 번호	
	
	
	public OrderDetailDto() {
		super();
	}
	
	public OrderDetailDto(int obNum, int prodNum, String prodName, int quantity, int price, int weight) {
		super();
		this.obNum = obNum;
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
	}
	
	
	
	public OrderDetailDto(int odNum, int prodNum, int obTakeback, int obExchange, String reason, int exColorSeq) {
		super();
		this.odNum = odNum;
		this.prodNum = prodNum;
		this.obTakeback = obTakeback;
		this.obExchange = obExchange;
		this.reason = reason;
		this.exColorSeq = exColorSeq;
	}

	public OrderDetailDto(int odNum, int obNum, int prodNum, String prodName, int quantity, int price, String color,
			String prodOption, String filename, int weight, int obTakeback, int obExchange, String reason,
			int exColorSeq) {
		super();
		this.odNum = odNum;
		this.obNum = obNum;
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.color = color;
		this.prodOption = prodOption;
		this.filename = filename;
		this.weight = weight;
		this.obTakeback = obTakeback;
		this.obExchange = obExchange;
		this.reason = reason;
		this.exColorSeq = exColorSeq;
	}

	public int getOdNum() {
		return odNum;
	}
	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}
	public int getObNum() {
		return obNum;
	}
	public void setObNum(int obNum) {
		this.obNum = obNum;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getObTakeback() {
		return obTakeback;
	}

	public void setObTakeback(int obTakeback) {
		this.obTakeback = obTakeback;
	}

	public int getObExchange() {
		return obExchange;
	}

	public void setObExchange(int obExchange) {
		this.obExchange = obExchange;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getExColorSeq() {
		return exColorSeq;
	}

	public void setExColorSeq(int exColorSeq) {
		this.exColorSeq = exColorSeq;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [odNum=" + odNum + ", obNum=" + obNum + ", prodNum=" + prodNum + ", prodName=" + prodName
				+ ", quantity=" + quantity + ", price=" + price + ", color=" + color + ", prodOption=" + prodOption
				+ ", filename=" + filename + ", weight=" + weight + ", obTakeback=" + obTakeback + ", obExchange="
				+ obExchange + ", reason=" + reason + ", exColorSeq=" + exColorSeq + "]";
	}
	
	
	
}
