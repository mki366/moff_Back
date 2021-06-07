package bit.com.a.dto;



public class DeliveryCheckDto {
  private int dcNum;	//--배송번호
  private int obNum;	//--주문번호F
  private String memId;	//--회원아이디
  private String status;	//--배송상태  
 
  private String id;	//--배송라이더 아이디
  private String name;	//--배송라이더 이름
  private String phone;	//--배송원 전화번호
 
  private String checkDate;//--배송상태변경때마다 그정보에 대한 날짜 갱신

public DeliveryCheckDto() {
	super();
}

public DeliveryCheckDto(int dcNum, int obNum, String memId, String status, String id, String name, String phone,
		String checkDate) {
	super();
	this.dcNum = dcNum;
	this.obNum = obNum;
	this.memId = memId;
	this.status = status;
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.checkDate = checkDate;
}

public DeliveryCheckDto(int obNum, String memId) {
	super();
	this.obNum = obNum;
	this.memId = memId;
}

public int getDcNum() {
	return dcNum;
}

public void setDcNum(int dcNum) {
	this.dcNum = dcNum;
}

public int getObNum() {
	return obNum;
}

public void setObNum(int obNum) {
	this.obNum = obNum;
}

public String getMemId() {
	return memId;
}

public void setMemId(String memId) {
	this.memId = memId;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getCheckDate() {
	return checkDate;
}

public void setCheckDate(String checkDate) {
	this.checkDate = checkDate;
}

@Override
public String toString() {
	return "DeliveryCheckDto [dcNum=" + dcNum + ", obNum=" + obNum + ", memId=" + memId + ", status=" + status + ", id="
			+ id + ", name=" + name + ", phone=" + phone + ", checkDate=" + checkDate + "]";
}
  
  
}