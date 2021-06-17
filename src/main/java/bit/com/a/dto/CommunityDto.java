package bit.com.a.dto;

public class CommunityDto {
	
	private int cmNum;
	private String id;
	private String image1;
	private String image2;
	private String newfilename;
	private String title;
	private String content;
	private String wdate;
	private int readCount;
	private int cmLike;
	private int commuDel;
    

	public CommunityDto() {
		// TODO Auto-generated constructor stub
	}


	
	public CommunityDto(int cmNum, String id, String image1, String image2, String newfilename, String title,
			String content, String wdate, int readCount, int cmLike, int commuDel) {
		super();
		this.cmNum = cmNum;
		this.id = id;
		this.image1 = image1;
		this.image2 = image2;
		this.newfilename = newfilename;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.readCount = readCount;
		this.cmLike = cmLike;
		this.commuDel = commuDel;
	}


	public CommunityDto(String id, String image1, String image2, String title, String content) {
		super();
		this.id = id;
		this.image1 = image1;
		this.image2 = image2;
		this.title = title;
		this.content = content;
	}

	
	public CommunityDto(int cmNum, String id, String image1, String image2, String title, String content) {
		super();
		this.cmNum = cmNum;
		this.id = id;
		this.image1 = image1;
		this.image2 = image2;
		this.title = title;
		this.content = content;
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



	public String getImage1() {
		return image1;
	}



	public void setImage1(String image1) {
		this.image1 = image1;
	}



	public String getImage2() {
		return image2;
	}



	public void setImage2(String image2) {
		this.image2 = image2;
	}



	public String getNewFilename() {
		return newfilename;
	}



	public void setNewFilename(String newFilename) {
		this.newfilename = newFilename;
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



	public int getReadCount() {
		return readCount;
	}



	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}



	public int getCmLike() {
		return cmLike;
	}



	public void setCmLike(int cmLike) {
		this.cmLike = cmLike;
	}



	public int getCommuDel() {
		return commuDel;
	}



	public void setCommuDel(int commuDel) {
		this.commuDel = commuDel;
	}



	@Override
	public String toString() {
		return "CommunityDto [cmNum=" + cmNum + ", id=" + id + ", image1=" + image1 + ", image2=" + image2
				+ ", newFilename=" + newfilename + ", title=" + title + ", content=" + content + ", wdate=" + wdate
				+ ", readCount=" + readCount + ", cmLike=" + cmLike + ", commuDel=" + commuDel + "]";
	}


	
	
	
}
