package bit.com.a.dto;

public class AdminDto {

	// 매출
	private String presM;
	private String presSales;
	private String prevSales;
	private String variation;
	private String obMonth;
	private String totSales;
	private String accum;
	private int num;
	

	public AdminDto(String presM, String presSales, String prevSales, String variation, String obMonth, String totSales,
			String accum) {
		super();
		this.presM = presM;
		this.presSales = presSales;
		this.prevSales = prevSales;
		this.variation = variation;
		this.obMonth = obMonth;
		this.totSales = totSales;
		this.accum = accum;
	}

	public AdminDto(String obMonth, String totSales, String accum) {
		super();
		this.obMonth = obMonth;
		this.totSales = totSales;
		this.accum = accum;
	}


	public AdminDto(String presM, String prevSales, String variation, String totSales, int num) {
		super();
		this.presM = presM;
		this.prevSales = prevSales;
		this.variation = variation;
		this.totSales = totSales;
		this.num = num;
	}

	
	public AdminDto(String presM, String presSales, String prevSales, String variation) {
		super();
		this.presM = presM;
		this.presSales = presSales;
		this.prevSales = prevSales;
		this.variation = variation;
	}


	
	public String getPresM() {
		return presM;
	}

	public void setPresM(String presM) {
		this.presM = presM;
	}

	public String getPresSales() {
		return presSales;
	}

	public void setPresSales(String presSales) {
		this.presSales = presSales;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public String getObMonth() {
		return obMonth;
	}

	public void setObMonth(String obMonth) {
		this.obMonth = obMonth;
	}

	public String getTotSales() {
		return totSales;
	}

	public void setTotSales(String totSales) {
		this.totSales = totSales;
	}

	public String getAccum() {
		return accum;
	}

	public void setAccum(String accum) {
		this.accum = accum;
	}

	public String getPrevSales() {
		return prevSales;
	}

	public void setPrevSales(String prevSales) {
		this.prevSales = prevSales;
	}




	@Override
	public String toString() {
		return "AdminDto [presM=" + presM + ", presSales=" + presSales + ", variation=" + variation + ", obMonth="
				+ obMonth + ", totSales=" + totSales + ", accum=" + accum + "]";
	}

	
}
