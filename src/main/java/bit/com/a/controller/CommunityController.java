package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.CommunityDto;
import bit.com.a.dto.CommunityParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.CommunityService;
import bit.com.a.util.FileUtil;

@RestController
public class CommunityController {

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	CommunityService service;
	
	//리스트
	@RequestMapping(value = "/getAllCommunity", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CommunityDto> getAllCommunity(CommunityParam param){
		System.out.println("getAllCommunity Controller() Controller");
		
		int sn = param.getPage();
		System.out.println("getAllCommunity 페이지확인: " + sn);
		
		int start = sn * 9 + 1;
		int end = (sn + 1) * 9;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<CommunityDto> list = service.getAllCommunity(param);
		
		
		return list;
		
		
	/*	
		Date nowDate = new Date(); System.out.println("포맷 지정 전 : " + nowDate); 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); 
		//원하는 데이터 포맷 지정 
		String strNowDate = simpleDateFormat.format(nowDate); 
		//지정한 포맷으로 변환 
		System.out.println("포맷 지정 후 : " + strNowDate);
		
	*/
		
		
	}
	
	// 리스트 총 수
	@RequestMapping(value = "/getAllCommunityCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int getAllCommunityCount(CommunityParam param) {
		System.out.println("getAllCommunityCount() Controller");
		int count = service.getAllCommunityCount(param);
		
		int pagenum = count/9;
		if((count % 9 )>0) {
			pagenum = pagenum + 1;
		}
		System.out.println("리스트 페이지 확인 : " + pagenum);
		return pagenum;
	}
	
	// 필터검색 리스트
	@RequestMapping(value = "/getFilterCommunity", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CommunityDto> getFilterCommunity(int page, String _cmLike, String _readCount){
		System.out.println("getFilterCommunity() Controller");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int sn = page;
		System.out.println("getFilterCommunity 페이지확인: " + sn);
		
		int start = sn * 9 + 1;
		int end = (sn + 1) * 9;
		
		map.put("cmLike", _cmLike);
		map.put("readCount", _readCount);
		map.put("start", start);
		map.put("end", end);
		
		List<CommunityDto> list = service.getFilterCommunity(map);
		
		return list;
				
	}
	
	// 필터검색 총 수
	@RequestMapping(value = "/getCommunityCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int getCommunityCount(String _cmLike, String _readCount) {
		System.out.println("getCommunityCount() Controller");
		
		Map<String, Object>map = new HashMap<String, Object>();
		
		map.put("cmLike", _cmLike);
		map.put("readCount", _readCount);
		
		
		int count = service.getCommunityCount(map);
		
		int pagenum = count/9;
		if((count % 9)>0) {
			pagenum = pagenum + 1;
		}
		System.out.println("필터검색 페이지 확인 : " + pagenum);
		
		return pagenum;
	}
	
	// 오늘의 인기사진
	@RequestMapping(value = "/todayList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CommunityDto> todayList(CommunityDto dto) {
		System.out.println("todayList() Controller");
		
		List<CommunityDto> list = service.todayList(dto);
		
		return list;
	}
	
	// 글쓰기
	@RequestMapping(value = "/writeCommunity", method = RequestMethod.POST)
	public String writeCommunity(@ModelAttribute CommunityDto dto,
								MemberDto mem,
								@RequestParam("fileload")
								MultipartFile fileload,
								@RequestParam("fileload2")
								MultipartFile fileload2,
								HttpServletRequest req) {
		
		System.out.println("writeCommunity() Controller");
		
		String uploadPath = req.getServletContext().getRealPath("/community");
		
		String image1 = "";
		image1 = fileload.getOriginalFilename();
		
		
		String image2 = "";
		image2 = fileload2.getOriginalFilename();
		
		
		String newFilename1 = FileUtil.getNewFilename(image1,1); 
	    String newFilename2 = FileUtil.getNewFilename(image2,2); 
	    
	    String filepath = uploadPath + File.separator + newFilename1;
	    String filepath2 = uploadPath + File.separator + newFilename2;
		
		System.out.println("------파일업로드 경로------");
		System.out.println("filepath1" + filepath);
		System.out.println("filepath2" + filepath2);
		
		// xml에 넣기 위한 데이터 처리
/*		String id = dto.getId();
		String title = dto.getTitle();
		String content = dto.getContent();*/
		
		String myPath = "http://localhost:3000//community//";
		
		dto.setImage1(myPath+newFilename1);
	    dto.setImage2(myPath+newFilename2); 
	    
	    
	    
	//	boolean a = service.writeCommunity(new CommunityDto(id, image1, image2, title, content));
	    String id = dto.getId();
		System.out.println("write Id: " + id);

		try {
			BufferedOutputStream bStream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			BufferedOutputStream bStream2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
			
			bStream.write(fileload.getBytes());
			bStream2.write(fileload2.getBytes());
			
			bStream.close();
			bStream2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(service.writeCommunity(dto) == true) {
			service.addPoint(mem);
			
			return "YES";
						
		}else {
			return "NO";
		}
			
		
	}
	
	
	// 디테일
	@RequestMapping(value = "/getCommunity", method = {RequestMethod.GET, RequestMethod.POST})
	public CommunityDto getCommunity(int cmNum) {
		System.out.println("getCommunity() Controller");
		
		CommunityDto dto = service.getCommunity(cmNum);
		service.readCountCommunity(cmNum);
		
		return dto;
	}
	
	
	// 글 수정
	@RequestMapping(value = "/updateCommunity", method = RequestMethod.POST)
	public String updateCommunity(	@ModelAttribute CommunityDto dto,
									String namefile, String namefile2,
									@RequestParam("fileload")
									MultipartFile fileload,
									@RequestParam("fileload2")
									MultipartFile fileload2,
									HttpServletRequest req) {

		System.out.println("updateCommunity() Controller");
		
		dto.setImage1(fileload.getOriginalFilename());
		dto.setImage2(fileload2.getOriginalFilename());
		
		String image1 = "";
	//	image1 = fileload.getOriginalFilename();
		
		String image2 = "";
	//	image2 = fileload2.getOriginalFilename();
		
		System.out.println("-------image1" + image1);
		System.out.println("-------image2" + image2);
		
		// 파일 경로
		String uploadPath = req.getServletContext().getRealPath("/community");
		
		if(image1 != fileload.getOriginalFilename() ||
			image2 != fileload2.getOriginalFilename()) {
			
			image1 = fileload.getOriginalFilename();
			image2 = fileload2.getOriginalFilename();
			
			System.out.println("------if문 들어옴");
			String newFilename1 = FileUtil.getNewFilename(image1,1); 
		    String newFilename2 = FileUtil.getNewFilename(image2,2); 
		    
		    String filepath = uploadPath + File.separator + newFilename1;
		    String filepath2 = uploadPath + File.separator + newFilename2;
			
			System.out.println("------파일업로드 경로------");
			System.out.println("filepath1" + filepath);
			System.out.println("filepath2" + filepath2);
			
			String myPath = "http://localhost:3000//community//";
			    
			dto.setImage1(myPath+newFilename1);
			dto.setImage2(myPath+newFilename2); 
			
			boolean check = false;
			try {
				BufferedOutputStream bStream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				BufferedOutputStream bStream2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
				
				bStream.write(fileload.getBytes());
				bStream2.write(fileload2.getBytes());
				
				bStream.close();
				bStream2.close();
				
				check = service.updateCommunity(dto);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			if(check) {
				return "YES";
			}else {
				return "NO";
			}
			
		}else {
			dto.setImage1(namefile);
			dto.setImage2(namefile2);
			
			service.updateCommunity(dto);
			
			return "YES";
			
		}
		

	}
	
             
	// 글삭제
	@RequestMapping(value = "/deleteCommunity", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteCommunity(int cmNum) {
		System.out.println("deleteCommunity() Controller");
		
		if(service.deleteCommunity(cmNum)==true) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
	@RequestMapping(value = "/getCommunityDetail", method = RequestMethod.POST)
	public CommunityDto getCommunityDetail(int cmNum) {
		System.out.println("getCommunityDetail() Controller");
		
		CommunityDto dto = service.getCommunityDetail(cmNum);
		
		return dto;
		
	}
	
	 // 커뮤니티 인기순 (메인)
	   @RequestMapping(value = "/commuList", method = {RequestMethod.GET, RequestMethod.POST})
	  public List<CommunityDto> commuList(CommunityDto dto) {
	      System.out.println("commuList() Controller");
	      
	      List<CommunityDto> list = service.commuList(dto);
	      
	      return list;
	   }


}











