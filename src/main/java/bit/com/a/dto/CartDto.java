package bit.com.a.dto;

public class CartDto {
	/*
	cNum   NUMBER         	NOT NULL,    --장바구니&위시리스트번호
    ID   	 VARCHAR2(50)   NOT NULL,    --회원아이디 
    PRODNUM   NUMBER        NOT NULL,    --상품번호
    PRODNAME  VARCHAR2(20)  NOT   NULL ,   --상품이름 
    QUANTITY NUMBER   		DEFAULT 1 NOT NULL,    --상품개수
    CARTORWISH NUMBER 		NOT  NULL --장바구니&위시리스트구분
    */
	
	
	private int cNum;
	private String id;
	private int prodNum;
	private String prodName;
	private int quantity;
	private int cartOrWish;
	private String color;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(int cNum, String id, int prodNum, String prodName, int quantity, int cartOrWish, String color) {
		super();
		this.cNum = cNum;
		this.id = id;
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.quantity = quantity;
		this.cartOrWish = cartOrWish;
		this.color = color;
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

	public int getCartOrWish() {
		return cartOrWish;
	}

	public void setCartOrWish(int cartOrWish) {
		this.cartOrWish = cartOrWish;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CartDto [cNum=" + cNum + ", id=" + id + ", prodNum=" + prodNum + ", prodName=" + prodName
				+ ", quantity=" + quantity + ", cartOrWish=" + cartOrWish + ", color=" + color + "]";
	}

	
	
	
}
