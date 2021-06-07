package bit.com.a.util;

import java.util.Date;

public class CommunityUtil {
	
	// 파일명 -> 변경(time)
	
	// myfile.txt -> f.indexOf('.') -> 6
	// 파일명, 확장자명
	// f.substring(6) -> .txt
	// f.substring(0, 6) -> myfile
	
	// myfile.txt -> 342344323.txt
	public static String getNewFilename(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음
			fpost = f.substring(f.indexOf('.'));	// .txt
			filename = new Date().getTime() + fpost;
		}else {
			filename = new Date().getTime() + ".back";
		}
		
		return filename;
	}
	

}
