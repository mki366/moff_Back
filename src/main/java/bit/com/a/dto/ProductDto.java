package bit.com.a.dto;

import java.util.Date;

public class ProductDto {

	 private int prodNum;      // 상품분류
	   
	   private String category;      // 상품분류
	   private String subCategory;      // 상품세분류
	   
	   private String prodName;      // 상품이름
	   private String color;         // 상품색상
	   private String prodOption;      // 상품옵션
	   private String info;
	   
	   private int weight;            // 상품무게
	   private int oriPrice;         // 상품정가
	   
	   private int price;            // 상품판매가격
	   private int quantity;         // 상품재고(수량)
	   private String rdate;            // 상품등록일
	   
	   private int deliveryCost;      // 배송비
	   private String filename;
	   private int readCount;      // 조회수 
	   
	   private String choice;
	   private String search;
	   
	   private int page;
	   private int start;
	   private int end;   
	  
	   private double star;
	   
	   private int odCount;	
	
	public ProductDto() {
	}
	
	//subcategory만    
	   public ProductDto(String subCategory) {
	      super();
	      this.subCategory = subCategory;
	   }

	   //prodNum만 
	   public ProductDto(int prodNum) {
	      super();
	      this.prodNum = prodNum;
	   }
	
	
	   public ProductDto(String category, String subCategory, String prodName, String color, String info, int weight,
				int oriPrice, int price, int quantity, int deliveryCost, String filename) {
			super();
			this.category = category;
			this.subCategory = subCategory;
			this.prodName = prodName;
			this.color = color;
			this.info = info;
			this.weight = weight;
			this.oriPrice = oriPrice;
			this.price = price;
			this.quantity = quantity;
			this.deliveryCost = deliveryCost;
			this.filename = filename;
		}
	
	

	public ProductDto(int prodNum, String category, String subCategory, String prodName, String color,
			String prodOption, String info, int weight, int oriPrice, int price, int quantity, String rdate,
			int deliveryCost, String filename, int readCount, String choice, String search, int page, int start,
			int end, double star) {
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
		this.readCount = readCount;
		this.choice = choice;
		this.search = search;
		this.page = page;
		this.start = start;
		this.end = end;
		this.star = star;
	}
	
	

	public ProductDto(int prodNum, String category, String subCategory, String prodName, String color,
			String prodOption, String info, int weight, int oriPrice, int price, int quantity, String rdate,
			int deliveryCost, String filename, int readCount, String choice, String search, int page, int start,
			int end, double star, int odCount) {
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
		this.readCount = readCount;
		this.choice = choice;
		this.search = search;
		this.page = page;
		this.start = start;
		this.end = end;
		this.star = star;
		this.odCount = odCount;
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

	
	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	
	
	public int getOdCount() {
		return odCount;
	}

	public void setOdCount(int odCount) {
		this.odCount = odCount;
	}

	@Override
	public String toString() {
		return "ProductDto [prodNum=" + prodNum + ", category=" + category + ", subCategory=" + subCategory
				+ ", prodName=" + prodName + ", color=" + color + ", prodOption=" + prodOption + ", info=" + info
				+ ", weight=" + weight + ", oriPrice=" + oriPrice + ", price=" + price + ", quantity=" + quantity
				+ ", rdate=" + rdate + ", deliveryCost=" + deliveryCost + ", filename=" + filename + ", readCount="
				+ readCount + ", choice=" + choice + ", search=" + search + ", page=" + page + ", start=" + start
				+ ", end=" + end + ", star=" + star + ", odCount=" + odCount + "]";
	}


	
}

