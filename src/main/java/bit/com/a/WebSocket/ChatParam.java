package bit.com.a.WebSocket;

public class ChatParam {
	private int page;
	private int start;
	private int end;
	private int expertNum;
	
	public ChatParam() {
		// TODO Auto-generated constructor stub
	}

	public ChatParam(int page, int start, int end, int expertNum) {
		super();
		this.page = page;
		this.start = start;
		this.end = end;
		this.expertNum = expertNum;
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

	public int getExpertNum() {
		return expertNum;
	}

	public void setExpertNum(int expertNum) {
		this.expertNum = expertNum;
	}

	@Override
	public String toString() {
		return "ChatParam [page=" + page + ", start=" + start + ", end=" + end + ", expertNum=" + expertNum + "]";
	}
	

	
	
}
