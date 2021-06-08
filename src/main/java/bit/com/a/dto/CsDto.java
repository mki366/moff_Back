package bit.com.a.dto;

import java.io.Serializable;

public class CsDto implements Serializable{

	private int csnum;		// 고객문의번호 
	private String id;
	
	private  int  ref;  	// 글 그룹번호 
	private  int  step;    // 글 행번호
	private  int  depth;   // 글 깊이
	
	private String title;   
	private String content;
	private String wdate;	// 작성날짜
	
	private String csdel;	// 삭제여부 
	private int readcount;	// 조회
	private String category;	// 카테고리 
	
	public CsDto() {
		
	}

	public CsDto(int csnum, String id, int ref, int step, int depth, String title, String content, String wdate,
			String csdel, int readcount, String category) {
		super();
		this.csnum = csnum;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.csdel = csdel;
		this.readcount = readcount;
		this.category = category;
	}

	public CsDto(String id, String title, String content, String category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
	}

	public int getCsnum() {
		return csnum;
	}

	public void setCsnum(int csnum) {
		this.csnum = csnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getCsdel() {
		return csdel;
	}

	public void setCsdel(String csdel) {
		this.csdel = csdel;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CsDto [csnum=" + csnum + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth
				+ ", title=" + title + ", content=" + content + ", wdate=" + wdate + ", csdel=" + csdel + ", readcount="
				+ readcount + ", category=" + category + "]";
	}



	
	
	
	
	
}
