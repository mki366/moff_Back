package bit.com.a.dto;

import java.util.Date;

public class ReviewDto {

//	rnum   	NUMBER   		NOT NULL,    --리뷰번호
//    ID    	VARCHAR2(50)   	NOT NULL,    --회원아이디 
//    PRODNUM NUMBER   		NOT NULL,    --상품번호 
//    STAR   	NUMBER  		NOT NULL ,   --별점 
//    TITLE 	VARCHAR2(400) 	NOT NULL,    --제목
//    CONTENT VARCHAR2(1000) 	NOT NULL 
	
	private int rnum;
	private String id;
	private int prodNum;
	private int star;
	private String content;
	private String image;
	private Date rdate;
	
	private int page;
	private int start;
	private int end;
	
	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDto(int rnum, String id, int prodNum, int star, String content, String image,
			String newfilename, Date rdate, int page, int start, int end) {
		super();
		this.rnum = rnum;
		this.id = id;
		this.prodNum = prodNum;
		this.star = star;
		this.content = content;
		this.image = image;
		this.rdate = rdate;
		this.page = page;
		this.start = start;
		this.end = end;
	}

	public ReviewDto(int prodNum, String id, int star, String content, String image) {
		this.prodNum = prodNum;
		this.id = id;
		this.star = star;
		this.content = content;
		this.image = image;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
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
		return "ReviewDto [rnum=" + rnum + ", id=" + id + ", prodNum=" + prodNum + ", star=" + star 
				+ ", content=" + content + ", image=" + image + ", newfilename="  + rdate
				+ ", page=" + page + ", start=" + start + ", end=" + end + "]";
	}

	

	
}
