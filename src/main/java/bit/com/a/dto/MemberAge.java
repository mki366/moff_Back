package bit.com.a.dto;

public class MemberAge {
	private String ageDivision;
	private int count;
	public MemberAge(String ageDivision, int count) {
		super();
		this.ageDivision = ageDivision;
		this.count = count;
	}
	public String getAgeDivision() {
		return ageDivision;
	}
	public void setAgeDivision(String ageDivision) {
		this.ageDivision = ageDivision;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MemberAge [ageDivision=" + ageDivision + ", count=" + count + "]";
	}
	
	
	
}
