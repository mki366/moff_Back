package bit.com.a.dto;

public class ExpertPagingParam {
	
	private String choice;
	private String search;
	
	private String filter;
	
	private String location;
	private String locationI;
	
	private int part;
	
	private int page;
	private int start;
	private int end;
	
	public ExpertPagingParam() {
		// TODO Auto-generated constructor stub
	}

	
	

	

	


	public ExpertPagingParam(String choice, String search, String filter, String location, String locationI, int part,
			int page, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.filter = filter;
		this.location = location;
		this.locationI = locationI;
		this.part = part;
		this.page = page;
		this.start = start;
		this.end = end;
	}



	





	public String getLocationI() {
		return locationI;
	}









	public void setLocationI(String locationI) {
		this.locationI = locationI;
	}









	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getFilter() {
		return filter;
	}


	public void setFilter(String filter) {
		this.filter= filter;
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

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
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
		return "ExpertPagingParam [choice=" + choice + ", search=" + search + ", filter=" + filter + ", location="
				+ location + ", locationI=" + locationI + ", part=" + part + ", page=" + page + ", start=" + start
				+ ", end=" + end + "]";
	}




	
	
	
	
	
	
}
