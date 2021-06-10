package bit.com.a.dto;

public class MonthlyMember {
	private String month;
	private int count;
	
	
	public MonthlyMember(String month, int count) {
		super();
		this.month = month;
		this.count = count;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MonthlyMember [month=" + month + ", count=" + count + "]";
	}
	
	
}
