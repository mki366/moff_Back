package bit.com.a.dto;

public class OrderBuyDto {
	private int obNum;		//주문 번호
	private String id;		//--구매자아이디
	private String name; 	//--구매자이름
	private int quantity; 	//--총구매수량
	private int price;		// --상품결제 가격
	
	private String obName;	//--수령자이름
	private String obPhone;	//--수령자전화번호
	private String obAddress;	//--배송주소
	private String obMes;	//--배송전달메세지
	
	private String obWay;	// --결제방법
	private String obCardN;	//--결제카드회사이름
	private String obDate;	//--주문(구매)일시
	private int obTakeback; //--반품여부 반품 안할시 0
	private int obExchange;	//--교환여부 반품 안할시 0
	private int deliveryCost;	//--총 배송비
	
	public OrderBuyDto() {
		super();
	}

	public OrderBuyDto(int obNum, String id, String name, int quantity, int price, String obName, String obPhone,
			String obAddress, String obMes, String obWay, String obCardN, String obDate, int obTakeback, int obExchange,
			int deliveryCost) {
		super();
		this.obNum = obNum;
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.obName = obName;
		this.obPhone = obPhone;
		this.obAddress = obAddress;
		this.obMes = obMes;
		this.obWay = obWay;
		this.obCardN = obCardN;
		this.obDate = obDate;
		this.obTakeback = obTakeback;
		this.obExchange = obExchange;
		this.deliveryCost = deliveryCost;
	}

	public OrderBuyDto(String id, String name, int quantity, int price, String obName, String obPhone, String obAddress,
			String obMes, String obWay, String obCardN, int deliveryCost) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.obName = obName;
		this.obPhone = obPhone;
		this.obAddress = obAddress;
		this.obMes = obMes;
		this.obWay = obWay;
		this.obCardN = obCardN;
		this.deliveryCost = deliveryCost;
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

	public String getObMes() {
		return obMes;
	}

	public void setObMes(String obMes) {
		this.obMes = obMes;
	}

	public String getObWay() {
		return obWay;
	}

	public void setObWay(String obWay) {
		this.obWay = obWay;
	}

	public String getObCardN() {
		return obCardN;
	}

	public void setObCardN(String obCardN) {
		this.obCardN = obCardN;
	}

	public String getObDate() {
		return obDate;
	}

	public void setObDate(String obDate) {
		this.obDate = obDate;
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

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	@Override
	public String toString() {
		return "OrderBuyDto [obNum=" + obNum + ", id=" + id + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + ", obName=" + obName + ", obPhone=" + obPhone + ", obAddress=" + obAddress + ", obMes="
				+ obMes + ", obWay=" + obWay + ", obCardN=" + obCardN + ", obDate=" + obDate + ", obTakeback="
				+ obTakeback + ", obExchange=" + obExchange + ", deliveryCost=" + deliveryCost + "]";
	}
	
	
}
