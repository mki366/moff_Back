package bit.com.a.dto;

public class ColorDto {

   private int colorSeq;
   private int prodNum;
   private String color;
   private String colorFilename;

   
   public ColorDto() {
      // TODO Auto-generated constructor stub
   }


   public ColorDto(int colorSeq, int prodNum, String color, String colorFilename) {
      super();
      this.colorSeq = colorSeq;
      this.prodNum = prodNum;
      this.color = color;
      this.colorFilename = colorFilename;
   }

   public ColorDto(int prodNum, String color, String colorFilename) {
		super();
		this.prodNum = prodNum;
		this.color = color;
		this.colorFilename = colorFilename;
	}
   

   public int getColorSeq() {
      return colorSeq;
   }


   public void setColorSeq(int colorSeq) {
      this.colorSeq = colorSeq;
   }


   public int getProdNum() {
      return prodNum;
   }


   public void setProdNum(int prodNum) {
      this.prodNum = prodNum;
   }


   public String getColor() {
      return color;
   }


   public void setColor(String color) {
      this.color = color;
   }


   public String getColorFilename() {
      return colorFilename;
   }


   public void setColorFilename(String colorFilename) {
      this.colorFilename = colorFilename;
   }


   @Override
   public String toString() {
      return "ColorDto [colorSeq=" + colorSeq + ", prodNum=" + prodNum + ", color=" + color + ", colorFilename="
            + colorFilename + "]";
   }

   
   
}