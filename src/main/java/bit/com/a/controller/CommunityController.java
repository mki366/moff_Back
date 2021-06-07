package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
import bit.com.a.util.CommunityUtil;

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
		
		String image1 = fileload.getOriginalFilename();
		String filepath = uploadPath + File.separator + image1;
		
		String image2 = fileload2.getOriginalFilename();
		String filepath2 = uploadPath + File.separator + image2;
		
		System.out.println("------파일업로드 경로------");
		System.out.println("filepath1" + filepath);
		System.out.println("filepath2" + filepath2);
		
		// xml에 넣기 위한 데이터 처리
		String id = dto.getId();
		String title = dto.getTitle();
		String content = dto.getContent();
		
		boolean a = service.writeCommunity(new CommunityDto(id, image1, image2, title, content));
		System.out.println("write Id: " + id);
		
		if(a == true) {
			service.addPoint(mem);
			
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
	
	// 파일 삭제
	@RequestMapping(value = "/deletFile", method = RequestMethod.POST)
	public String deletFile(		@ModelAttribute CommunityDto dto, 
									@RequestParam("oldFile")
									MultipartFile oldFile,
									@RequestParam("oldFile2")
									MultipartFile oldFile2,
									HttpServletRequest req) {
		
		String uploadPath = req.getServletContext().getRealPath("/community");
		
		dto.setImage1(oldFile.getOriginalFilename());
		dto.setImage2(oldFile2.getOriginalFilename());
		
		String image1 = oldFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + image1;
		
		String image2 = oldFile2.getOriginalFilename();
		String filepath2 = uploadPath + File.separator + image2;
		System.out.println("삭제파일 경로: " + filepath);
		System.out.println("삭제파일 경로: " + filepath2);
		
		int cmNum = dto.getCmNum();
		String id = dto.getId();
		String title = dto.getTitle();
		String content = dto.getContent();
		
		
		boolean a = service.updateCommunity(new CommunityDto(cmNum, id, image1, image2, title, content)); 
		
		if(a==true) {
			File file = new File(filepath, filepath2);
			
			file.delete();
			service.updateCommunity(dto);
			System.out.println("파일삭제 성공");
					
			return "YES";	
			
		}else {
			return "NO";
		}
		
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
		
		// 파일 경로
		String uploadPath = req.getServletContext().getRealPath("/community");
		
		// 수정할 파일이 있음
		if(dto.getImage1() != null && dto.getImage2().equals("")) {
			String f = dto.getImage1();
			String f1 = dto.getImage2();
			
			String newfilename = CommunityUtil.getNewFilename(f);
			String newfilename2 = CommunityUtil.getNewFilename(f1);
			
			
			dto.setImage1(f);
			dto.setNewFilename(newfilename);
			
			dto.setImage2(f1);
			dto.setNewFilename(newfilename2);
			
			File file = new File(uploadPath + "/" + newfilename);
			File file2 = new File(uploadPath + "/" + newfilename2);
			
			try {
				FileUtils.writeByteArrayToFile(file, fileload.getBytes());
				FileUtils.writeByteArrayToFile(file2, fileload2.getBytes());
				
				service.updateCommunity(dto);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return "YES";

		}else {
			dto.setImage1(namefile);
			dto.setImage2(namefile2);
			
			service.updateCommunity(dto);
		}
		
		return "NO";

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
	
	
	
}





/*		String image1 = fileload.getOriginalFilename();
String filepath = uploadPath + File.separator + image1;

String image2 = fileload2.getOriginalFilename();
String filepath2 = uploadPath + File.separator + image2;

System.out.println("------파일업로드 경로------");
System.out.println("filepath1" + filepath);
System.out.println("filepath2" + filepath2);

// xml에 넣기 위한 데이터 처리
String id = dto.getId();
String title = dto.getTitle();
String content = dto.getContent();

boolean a = service.writeCommunity(new CommunityDto(id, image1, image2, title, content));
System.out.println("write Id: " + id);
if(a == true) {

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
return "YES";
	
}else {
return "NO";
}

*/





