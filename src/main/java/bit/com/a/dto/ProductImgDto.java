package bit.com.a.dto;

import java.io.Serializable;

public class ProductImgDto implements Serializable{

	private int piNum;
	private int prodNum;
	private String info;
	private String imgFilename;
	
	public ProductImgDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductImgDto(int piNum, int prodNum, String info, String imgFilename) {
		super();
		this.piNum = piNum;
		this.prodNum = prodNum;
		this.info = info;
		this.imgFilename = imgFilename;
	}

	public ProductImgDto(int prodNum, String info, String imgFilename) {
		super();
		this.prodNum = prodNum;
		this.info = info;
		this.imgFilename = imgFilename;
	}
	
	public int getPiNum() {
		return piNum;
	}

	public void setPiNum(int piNum) {
		this.piNum = piNum;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImgFilename() {
		return imgFilename;
	}

	public void setImgFilename(String imgFilename) {
		this.imgFilename = imgFilename;
	}

	@Override
	public String toString() {
		return "ProductImgDto [piNum=" + piNum + ", prodNum=" + prodNum + ", info=" + info + ", imgFilename="
				+ imgFilename + "]";
	}

	
	
	
}
