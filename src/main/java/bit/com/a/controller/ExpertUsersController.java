package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.ConsultingExpert;
import bit.com.a.dto.ExpertPagingParam;
import bit.com.a.dto.ExpertUsersDto;
import bit.com.a.dto.ExpertUsersParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.ExperUsersService;
import bit.com.a.service.MemberService;

@RestController
public class ExpertUsersController {
	
	
	@Autowired
	ServletContext serveltContext;
	
	@Autowired
	private ExperUsersService ExperService;
	
	
	@RequestMapping(value = "/addExperUsers", method = RequestMethod.POST)
	public String addExperUsers( 
				@ModelAttribute ExpertUsersParam param,
				@RequestParam("idCard")
				MultipartFile idCard, 
				@RequestParam("registration")
				MultipartFile registration,
				@RequestParam("image")
				MultipartFile image,
				@RequestParam("imageDetail1")
				MultipartFile imageDetail1,
				@RequestParam("imageDetail2")
				MultipartFile imageDetail2,
				@RequestParam("imageDetail3")
				MultipartFile imageDetail3,
				HttpServletRequest req
				
			) {
		System.out.println("ExperUsersController addExperUsers()");
		
		System.err.println("데이터 값확인:" + param.toString());
		// 경로	src/main/webapp/exper 폴더를 생성할 것	
		String uploadPath = req.getServletContext().getRealPath("/exper");
		
		String filename = idCard.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;
		
		String filename2 = registration.getOriginalFilename();
		String filepath2 = uploadPath + File.separator + filename2;
		
		String filename3 = image.getOriginalFilename();
		String filepath3 = uploadPath + File.separator + filename3;
		
		String filename4 = imageDetail1.getOriginalFilename();
		String filepath4 = uploadPath + File.separator + filename4;
		
		String filename5 = imageDetail2.getOriginalFilename();
		String filepath5 = uploadPath + File.separator + filename5;
		
		String filename6 = imageDetail3.getOriginalFilename();
		String filepath6 = uploadPath + File.separator + filename6;
		
		System.out.println("---파일 업로드 경로-----");
		System.out.println("filepath1:" + filepath);
		System.out.println("filepath2:" + filepath2);
		System.out.println("filepath3:" + filepath3);
		System.out.println("filepath4:" + filepath4);
		System.out.println("filepath5:" + filepath5);
		System.out.println("filepath6:" + filepath6);
		
		//param값 xml에 넣기위해 데이터 처리
		
		 String id = param.getId();
		 String pwd = param.getPwd();	
		 String name = param.getName();	
		 String nickname = param.getName();
		 String email =param.getEmail1() + "@" + param.getEmail2();
		 String address = param.getAddress1() + " " + param.getAddress2();	
		 String phone = param.getPhone();	
		
		 //생년월일이 한자리 일시 가독성을위해 앞에 0붙임
		 if(param.getMonth().length() == 1) {
			 param.setMonth("0" + param.getMonth());
		 }
		 
		 if(param.getDay().length() == 1) {
			 param.setDay("0" + param.getDay());
		}
		 
		 String bDate = param.getYear() + "/" + param.getMonth() + "/" + param.getDay();	
		 
		 
		 //나머지 데이터 정리
		 
		 //프리랜서, 개인, 법인
		 int experType = param.getExperType();
		 //상호명
		 String regisName = param.getRegisName();
		 //사업자번호
		 String regiNumber = param.getRegiNumber1() + "-" + param.getRegiNumber2() + "-" + param.getRegiNumber3();
		 //대표자이름
		 String ceoName = param.getCeoName();
		 //사업장 주소
		 String regAddress = address;
		 // 시공분야(종합, 부분)
		 int part = param.getPart();
		 //업체 설명
		 String expertInfo = param.getExpertInfo();
		 
		 //멤버테이블에 입력
		 boolean a = ExperService.addExperUsersMember(new MemberDto(id, pwd, name, nickname, email, address, phone, bDate));
		 if(a == true) {
				System.out.println("addExperUsers_Member success");
			}else {		
				System.out.println("addExperUsers_Member fail");
			}
		 
		 //Exper 업체 테이블에 입력
		 boolean b = ExperService.addExperUsers(new ExpertUsersDto(id,
				 									pwd,
				 									name,
				 									nickname,
				 									email,
				 									address,
				 									bDate,
				 									phone,
				 									experType,
				 									filename,
				 									filename2,
				 									regisName,
				 									regiNumber,
				 									ceoName,
				 									regAddress,
				 									part,
				 									expertInfo,
				 									filename3,
				 									filename4,
				 									filename5,
				 									filename6));
		 
		 if(b) {
			 System.out.println("------ExperService. DB. 업체등록완료");
		 }else {
			 System.out.println("------ExperService. DB. 업체등록실패");
		 }
		 
		//파일입력
			
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
				BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3)));
				BufferedOutputStream os4 = new BufferedOutputStream(new FileOutputStream(new File(filepath4)));
				BufferedOutputStream os5 = new BufferedOutputStream(new FileOutputStream(new File(filepath5)));
				BufferedOutputStream os6 = new BufferedOutputStream(new FileOutputStream(new File(filepath6)));
				
				os.write(idCard.getBytes());
				os2.write(registration.getBytes());
				os3.write(image.getBytes());
				os4.write(imageDetail1.getBytes());
				os5.write(imageDetail2.getBytes());
				os6.write(imageDetail3.getBytes());
				
				os.close();			
				os2.close();			
				os3.close();			
				os4.close();			
				os5.close();			
				os6.close();			

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return "file upload fail";			
			}
			
			return "file upload success";		
		}
		 
		
	@RequestMapping(value = "/allExperList", method = RequestMethod.POST)
	public List<ExpertUsersDto> allExperList(ExpertPagingParam param){
		
		
		
		
		System.out.println("allExperList 데이터 들어오는 값 확인:"+ param.toString());
		
		int pagen = param.getPage();
		int start = pagen * 12 + 1;
		int end = (pagen + 1)*12;
		System.out.println("start:"+ start);
		System.out.println("end:"+ end);
		
		//시작, 종료 설정
		param.setStart(start);
		param.setEnd(end);
		
		
		System.out.println("페이지 넣고 최종 마이바티스 입력:"+ param.toString());
		
		
		List<ExpertUsersDto> allExperList = ExperService.allExperList(param);
		
		for (ExpertUsersDto ExperUsersDto : allExperList) {
			System.out.println("allExperList 리스트 확인:" + ExperUsersDto.toString());
		}
		
		
		return allExperList;
	}
	
	@RequestMapping(value = "/allExperListCOUNT", method = RequestMethod.POST)
	public int allExperListCOUNT(ExpertPagingParam param) {
		int count = ExperService.allExperListCOUNT(param);
		
		System.out.println("allExperListCOUNT 데이터 들어온값 확인:" + param.toString());
		
		  int pagenum = count/12;
		   if((count %12)>0) {
			   pagenum = pagenum + 1;
			   
		   }
		   
		   System.out.println("allExperListCOUNT 페이지 갯수 확인:" +  pagenum);
		   return pagenum;
	}
	
	
	@RequestMapping(value = "/ExpertDetail", method = RequestMethod.POST)
	public ExpertUsersDto ExpertDetail(int eNUM) {
		System.out.println("---start--ExpertDetail");
		
		ExpertUsersDto Detail = ExperService.ExpertDetail(eNUM);
		
		return Detail;
	}
	
	

	@RequestMapping(value = "/ExpertMyDetail", method = RequestMethod.POST)
	public ExpertUsersDto ExpertMyDetail(String id) {
		System.out.println("---start--ExpertMyDetail");
		
		System.out.println("들어온아이디:" + id);
		
		ExpertUsersDto Detail = ExperService.ExpertMyDetail(id);
		
		return Detail;
	}
	
	
	@RequestMapping(value = "/consultingExpert", method = RequestMethod.POST)
	public boolean consulting(ConsultingExpert dto) {
		System.out.println("consulting start");
		
		boolean result = ExperService.consulting(dto);
		
		return result;
	}
	
}
