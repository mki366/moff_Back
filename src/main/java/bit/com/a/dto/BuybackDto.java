package bit.com.a.dto;



public class BuybackDto {
   private int bNum;
   private String id;
   private String category;
   private String subCategory;
   
   
   private int prodNum;
   private double price;   //환불될 가격
   private int condition;
   
   
   
   private String bDate;
   private String bAddress;
   private String bResult;
   private String bid;
   private String bName;
   private String bPhone;
   
   private String memPhone;//멤버
   
   //상품 정보
      private String prodName;      // 상품이름
      private String color;         // 상품색상
      private String prodOption;      // 상품옵션
      private String info;
      private String filename;
   
   public BuybackDto() {
      super();
   }


   

   public BuybackDto(int bNum, String id, String category, String subCategory, int prodNum, double price,
         int condition, String bDate, String bAddress, String bResult, String bid, String bName, String bPhone,
         String prodName, String color, String prodOption, String info, String filename) {
      super();
      this.bNum = bNum;
      this.id = id;
      this.category = category;
      this.subCategory = subCategory;
      this.prodNum = prodNum;
      this.price = price;
      this.condition = condition;
      this.bDate = bDate;
      this.bAddress = bAddress;
      this.bResult = bResult;
      this.bid = bid;
      this.bName = bName;
      this.bPhone = bPhone;
      this.prodName = prodName;
      this.color = color;
      this.prodOption = prodOption;
      this.info = info;
      this.filename = filename;
   }
   
   







//처음 신청했을 떄
   public BuybackDto(String id, int prodNum, int condition, String bDate, String bAddress) {
      super();
      this.id = id;
      this.prodNum = prodNum;
      this.condition = condition;
      this.bDate = bDate;
      this.bAddress = bAddress;
   }


 //뽀이가 바이백 신청명단확인
   
   public BuybackDto(int bNum, String id, String category, String subCategory, int prodNum, double price, int condition,
		String bDate, String bAddress, String bResult, String bid, String bName, String bPhone, String memPhone) {
	super();
	this.bNum = bNum;
	this.id = id;
	this.category = category;
	this.subCategory = subCategory;
	this.prodNum = prodNum;
	this.price = price;
	this.condition = condition;
	this.bDate = bDate;
	this.bAddress = bAddress;
	this.bResult = bResult;
	this.bid = bid;
	this.bName = bName;
	this.bPhone = bPhone;
	this.memPhone = memPhone;
}




public String getMemPhone() {
	return memPhone;
}




public void setMemPhone(String memPhone) {
	this.memPhone = memPhone;
}




public int getbNum() {
      return bNum;
   }


   public void setbNum(int bNum) {
      this.bNum = bNum;
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
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


   public int getProdNum() {
      return prodNum;
   }


   public void setProdNum(int prodNum) {
      this.prodNum = prodNum;
   }


   public double getPrice() {
      return price;
   }


   public void setPrice(double price) {
      this.price = price;
   }


   public int getCondition() {
      return condition;
   }


   public void setCondition(int condition) {
      this.condition = condition;
   }


   public String getbDate() {
      return bDate;
   }


   public void setbDate(String bDate) {
      this.bDate = bDate;
   }


   public String getbAddress() {
      return bAddress;
   }


   public void setbAddress(String bAddress) {
      this.bAddress = bAddress;
   }


   public String getbResult() {
      return bResult;
   }


   public void setbResult(String bResult) {
      this.bResult = bResult;
   }


   public String getBid() {
      return bid;
   }


   public void setBid(String bid) {
      this.bid = bid;
   }


   public String getbName() {
      return bName;
   }


   public void setbName(String bName) {
      this.bName = bName;
   }


   public String  getbPhone() {
      return bPhone;
   }


   public void setbPhone(String bPhone) {
      this.bPhone = bPhone;
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


   public String getFilename() {
      return filename;
   }


   public void setFilename(String filename) {
      this.filename = filename;
   }




@Override
public String toString() {
	return "BuybackDto [bNum=" + bNum + ", id=" + id + ", category=" + category + ", subCategory=" + subCategory
			+ ", prodNum=" + prodNum + ", price=" + price + ", condition=" + condition + ", bDate=" + bDate
			+ ", bAddress=" + bAddress + ", bResult=" + bResult + ", bid=" + bid + ", bName=" + bName + ", bPhone="
			+ bPhone + ", prodName=" + prodName + ", color=" + color + ", prodOption=" + prodOption + ", info=" + info
			+ ", filename=" + filename + "]";
}
   
   
}