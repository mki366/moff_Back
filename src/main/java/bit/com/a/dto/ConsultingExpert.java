package bit.com.a.dto;

public class ConsultingExpert {
	private int connum;
	private String id;
	private String phone;
	private String mess;
	private String condate;
	public int getConnum() {
		return connum;
	}
	public void setConnum(int connum) {
		this.connum = connum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getCondate() {
		return condate;
	}
	public void setCondate(String condate) {
		this.condate = condate;
	}
	@Override
	public String toString() {
		return "ConsultingExpert [connum=" + connum + ", id=" + id + ", phone=" + phone + ", mess=" + mess
				+ ", condate=" + condate + "]";
	}
	
	
}
