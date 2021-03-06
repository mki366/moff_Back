package bit.com.a.dto;


public class CommentDto {

	private int ctNum;
	private int cmNum;
	private String id;
	private String wdate;
	private String content;
	private int ref;
	private int step;
	private int depth;
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}

	public CommentDto(int ctNum, int cmNum, String id, String wdate, String content, int ref, int step, int depth) {
		super();
		this.ctNum = ctNum;
		this.cmNum = cmNum;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
	}

	
	public CommentDto(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public int getCtNum() {
		return ctNum;
	}

	public void setCtNum(int ctNum) {
		this.ctNum = ctNum;
	}

	public int getCmNum() {
		return cmNum;
	}

	public void setCmNum(int cmNum) {
		this.cmNum = cmNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "CommentDto [ctNum=" + ctNum + ", cmNum=" + cmNum + ", id=" + id + ", wdate=" + wdate + ", content="
				+ content + ", ref=" + ref + ", step=" + step + ", depth=" + depth + "]";
	}
	
	
	
	
	
}
