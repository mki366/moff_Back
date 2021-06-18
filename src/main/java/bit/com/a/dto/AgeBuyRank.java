package bit.com.a.dto;

public class AgeBuyRank {
	private int countp;
	private String bdate;
	private int ranking;
	private String prodname;
	public AgeBuyRank(int countp, String bdate, int ranking, String prodname) {
		super();
		this.countp = countp;
		this.bdate = bdate;
		this.ranking = ranking;
		this.prodname = prodname;
	}
	public int getCountp() {
		return countp;
	}
	public void setCountp(int countp) {
		this.countp = countp;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	@Override
	public String toString() {
		return "AgeBuyRank [countp=" + countp + ", bdate=" + bdate + ", ranking=" + ranking + ", prodname=" + prodname
				+ "]";
	}
	
	
}
