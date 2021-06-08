package bit.com.a.util;

import java.util.Date;

public class FileUtil {
	
	// 파일명 -> 변경(time)
	
	// myfile.txt -> f.indexOf('.') -> 6
	// 파일명, 확장자명
	// f.substring(6) -> .txt
	// f.substring(0, 6) -> myfile
	
	// myfile.txt -> 342344323.txt
	public static String getNewFilename(String f, int num) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음
			fpost = f.substring(f.indexOf('.'));	// .txt
			filename = new Date().getTime() + fpost + num;
		}else {
			filename = new Date().getTime() + ".back";
		}
		
		return filename;
	}
	
	public static String newFilenames(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.')>=0) {
			fpost = f.substring(f.indexOf('.'));	
			filename = new Date().getTime() + fpost;
		}
		
		return filename;
	}
}
