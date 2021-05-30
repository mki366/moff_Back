package bit.com.a.dto;

public class BoyBuyBackParam {

	// 페이징 처리시 필요한 파라미터
	
	private String choice;
	private String search;
	private String visitdate;// 방문 날짜 검색
	private String searchDate;
	
	private String id;
	
	private int page;
	private int start;
	private int end;
	
	public BoyBuyBackParam() {
		// TODO Auto-generated constructor stub
	}
	
	
	



	public BoyBuyBackParam(String choice, String search, String visitdate, String searchDate, String id, int page,
			int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.visitdate = visitdate;
		this.searchDate = searchDate;
		this.id = id;
		this.page = page;
		this.start = start;
		this.end = end;
	}






	public BoyBuyBackParam(String choice, String search, String visitdate, String searchDate, int page, int start,
			int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.visitdate = visitdate;
		this.searchDate = searchDate;
		this.page = page;
		this.start = start;
		this.end = end;
	}

	

	


	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getVisitdate() {
		return visitdate;
	}






	public void setVisitdate(String visitdate) {
		this.visitdate = visitdate;
	}











	public String getSearchDate() {
		return searchDate;
	}






	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
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






	@Override
	public String toString() {
		return "BoyBuyBackParam [choice=" + choice + ", search=" + search + ", visitdate=" + visitdate + ", searchDate="
				+ searchDate + ", id=" + id + ", page=" + page + ", start=" + start + ", end=" + end + "]";
	}








	



	
	
	
	
}
