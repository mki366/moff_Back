package bit.com.a.dto;

public class BoardLikeDto {

	/*
	 	LIKENUM	NUMBER			NOT NULL,		-- 좋아요seq
		CMNUM	NUMBER			NOT NULL,		-- 커뮤eq
		ID		VARCHAR2(50)	NOT NULL,		-- 멤버ID
	 */
	
	
	private int likeNum;
	private int cmNum;
	private String id;
	

	public BoardLikeDto() {
		// TODO Auto-generated constructor stub
	}


	public BoardLikeDto(int likeNum, int cmNum, String id) {
		this.likeNum = likeNum;
		this.cmNum = cmNum;
		this.id = id;
	}


	public int getLikeNum() {
		return likeNum;
	}


	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
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


	@Override
	public String toString() {
		return "BoardLikeDto [likeNum=" + likeNum + ", cmNum=" + cmNum + ", id=" + id + "]";
	}
	
	
	
	
}
