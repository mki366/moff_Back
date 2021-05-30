package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.DeliDto;
import bit.com.a.dto.DeliToTalDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MyDeliPagingParam;
import bit.com.a.dto.TotalOrderDetailDto;
import bit.com.a.service.DeliService;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import bit.com.a.Coolsms;

import bit.com.a.dto.AdPagingParam;
import bit.com.a.dto.DeliAcceptDto;
import bit.com.a.dto.DeliDataDto;

@RestController
public class DeliController {
 
	@Autowired
	ServletContext serveltContext;
	
	@Autowired
	DeliService service;
	
	@RequestMapping(value = "/Deliaccount", method = RequestMethod.POST)
	public String Deliaccount(	
						        @ModelAttribute DeliDataDto dto ,
								@RequestParam("license")
								MultipartFile license, 
								@RequestParam("bank")
								MultipartFile bank,
								@RequestParam("carNum")
								MultipartFile carNum,
								HttpServletRequest req) {
		
		System.out.println("FileController fileUpload()");
		
		System.out.println(dto.toString());
		
		
		
		//System.out.println(dto.toString());
		
		// 경로	src/main/webapp/upload 폴더를 생성할 것	
		String uploadPath = req.getServletContext().getRealPath("/delidata");
		
		// String uploadPath = "d:\\tmp";
		
		String filename = license.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;
		
		String filename2 = bank.getOriginalFilename();
		String filepath2 = uploadPath + File.separator + filename2;
		
		String filename3 = carNum.getOriginalFilename();
		String filepath3 = uploadPath + File.separator + filename3;
		
		//									'/'

		System.out.println("filepath:" + filepath);
		System.out.println("filepath:" + filepath2);
		System.out.println("filepath:" + filepath3);
		
		
		//DeliDataDto를 변환시켜 MemberDto에 입력하기위한 작업 
		 String id = dto.getId();
		 String pwd = dto.getPwd();	
		 String name = dto.getName();	
		 String nickname = dto.getNickname();	
		 String email =dto.getEmail1() + "@" + dto.getEmail2();
		 String address = dto.getAddress1() + " " + dto.getAddress2();	
		 String phone = dto.getPhone();	
		 
		 //생년월일이 한자리 일시 가독성을위해 앞에 0붙임
		 if(dto.getMonth().length() == 1) {
			dto.setMonth("0" + dto.getMonth());
		 }
		 
		 if(dto.getDay().length() == 1) {
			 dto.setDay("0" + dto.getDay());
		}
		 
		 
		 
		 String bdate = dto.getYear() + "/" + dto.getMonth() + "/" + dto.getDay();	
			
		
		
		
		//디비에 데이터 입력
		boolean a = service.addDelivery(new MemberDto(id, pwd, name, nickname, email, address, phone, bdate, filename, filename2, filename3));
		
		if(a == true) {
			System.out.println("data sucsess");
		}else {		
			System.out.println("data fail");
		}
		
		
		//파일입력
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
			BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3)));
			
			os.write(license.getBytes());
			os2.write(bank.getBytes());
			os3.write(carNum.getBytes());
			
			os.close();			
			os2.close();			
			os3.close();			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "file upload fail";			
		}
		
		return "file upload success";		
	}
	
	//전체회원 리스트
	@RequestMapping(value = "/allmemberList", method = RequestMethod.GET)
	public List<MemberDto> allmemberList(AdPagingParam param){
		System.out.println("allmemberList controller");
		
		//들어온 데이터 확인
		System.out.println(param.toString());
		
		int pagen = param.getPage();
		int start = pagen * 10 + 1;
		int end = (pagen + 1)*10;
		System.out.println("start:"+ start);
		System.out.println("end:"+ end);
		
		//시작, 종료 설정
		param.setStart(start);
		param.setEnd(end);
		
		//데이터 호출
		List<MemberDto> allmemberList = service.allmemberList(param);
		System.out.println("리스트 데이터 확인");
		for (MemberDto memberDto : allmemberList) {
			System.out.println(memberDto.toString());
		}
		
		
		return allmemberList;
		
	}
	
	//회원의 총수
	@RequestMapping(value = "/getallmemberList", method = RequestMethod.GET)

	public int bbslistCount(AdPagingParam param) {
		int count = service.getmemberList(param);
		return count;
	}
	
	//관리자페이지-배달원 승인을위한 배달원 신청 리스트
		@RequestMapping(value = "/deliverymanList", method = RequestMethod.GET)
		public List<MemberDto> deliverymanList(AdPagingParam param){
			System.out.println("deliverymanList controller");
			
			//들어온 데이터 확인
			System.out.println(param.toString());
			
			int pagen = param.getPage();
			int start = pagen * 10 + 1;
			int end = (pagen + 1)*10;
			System.out.println("start:"+ start);
			System.out.println("end:"+ end);
			
			//시작, 종료 설정
			param.setStart(start);
			param.setEnd(end);
			
			//데이터 호출
			List<MemberDto> deliverymanList = service.deliverymanList(param);
			System.out.println("리스트 데이터 확인");
			for (MemberDto memberDto : deliverymanList) {
				System.out.println(memberDto.toString());
			}
			
			
			return deliverymanList;
			
		}
		
		//배달원신청자의 총 인원
		@RequestMapping(value = "/deliveryman", method = RequestMethod.GET)

		public int deliveryman(AdPagingParam param) {
			int count = service.deliveryman(param);
			return count;
		}
		
		//배달원 신청 폼 데이터를 받기위함
		@RequestMapping(value = "/getdeliveryman", method = RequestMethod.POST)
		public MemberDto getdeliveryman(int memNum) {
			System.out.println("getdeliveryman form");
			MemberDto dto = service.getdeliveryman(memNum);
			
			return dto;
			
		}
		
		//배달 지원자 승인
		@RequestMapping(value = "/deliveryAdmi", method = RequestMethod.POST)
		public boolean deliveryAdmi(int memNum) {
			System.out.println("getdeliveryman form");
			boolean admi = service.deliveryAdmi(memNum);
			System.out.println("확인");
			System.out.println("admi: " + admi) ;
			return admi;
			
		}
		
		
	
		 
		 @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
		 public String sendSMS(String from, String text) throws Exception { // 휴대폰 문자보내기

				String api_key = "NCSMB43IVVGNNBJP";
				String api_secret = "JADFQOASE9YHKJO7ZLWGUELS8C8DDBAL";
				Coolsms coolsms = new Coolsms(api_key, api_secret); // 메시지보내기 객체 생성

			
				/*
				 * Parameters 관련정보 : http://www.coolsms.co.kr/SDK_Java_API_Reference_ko#toc-0
				 */
				HashMap<String, String> set = new HashMap<String, String>();
				set.put("to", from); // 수신번호
				set.put("from", "010-2888-3498"); // 발신번호
				set.put("text", "안녕하세요. MOFF입니다. 배달 라이더지원이 승인되었습니다."); // 문자내용
				set.put("type", "sms"); // 문자 타입

				 JSONObject obj = (JSONObject) coolsms.send(set);
				  System.out.println(obj.toString());
				 
				 return "success";
			}
		 
		 
		 
		 @RequestMapping(value = "/deliverysms", method = RequestMethod.POST)
		 public String deliverysms(String from, String text) throws Exception { // 휴대폰 문자보내기

				String api_key = "NCSMB43IVVGNNBJP";
				String api_secret = "JADFQOASE9YHKJO7ZLWGUELS8C8DDBAL";
				Coolsms coolsms = new Coolsms(api_key, api_secret); // 메시지보내기 객체 생성

			
				/*
				 * Parameters 관련정보 : http://www.coolsms.co.kr/SDK_Java_API_Reference_ko#toc-0
				 */
				HashMap<String, String> set = new HashMap<String, String>();
				set.put("to", from); // 수신번호
				set.put("from", "010-2888-3498"); // 발신번호
				set.put("text", text); // 문자내용
				set.put("type", "sms"); // 문자 타입

				 JSONObject obj = (JSONObject) coolsms.send(set);
				  System.out.println(obj.toString());
				 
				 return "success";
			}
		 
		 
		 @RequestMapping(value = "/TotalOrder", method = RequestMethod.GET)
		 public List<DeliToTalDto> TotalOrder(AdPagingParam param){
			 System.out.println("TotalOrder");
			 
			 
			 	//들어온 데이터 확인
				System.out.println(param.toString());
				
				int pagen = param.getPage();
				int start = pagen * 10 + 1;
				int end = (pagen + 1)*10;
				System.out.println("start:"+ start);
				System.out.println("end:"+ end);
				
			
				
				//시작, 종료 설정
				param.setStart(start);
				param.setEnd(end);
			 
				List<DeliToTalDto> TotalOrder = service.TotalOrder(param);
				for (DeliToTalDto deliToTalDto : TotalOrder) {
					System.out.println("데이터확인:" + deliToTalDto.toString());
				}
				return TotalOrder;
			 
			 
			 
		 }
		   @RequestMapping(value = "/TotalOrderCount", method = RequestMethod.GET)
		   public int TotalOrderCount(AdPagingParam param) {
			   int count = service.TotalOrderCount(param);
			   System.out.println("count 주문내역 수량" + count);
			   return count;
		   }
		   
		   @RequestMapping(value = "/Pagination", method = RequestMethod.GET)
		   public int Pagination(AdPagingParam param) {
			   int count = service.TotalOrderCount(param);
			   System.out.println("count 주문내역 수량" + count);
			   
			   int pagenum = count/10;
			   if((count %10)>0) {
				   pagenum = pagenum + 1;
				   
			   }
			   System.out.println("페이지 갯수 확인:" +  pagenum);
			   return pagenum;
		   }
		   
		    
		   
		   @RequestMapping(value = "/orderdetail", method = RequestMethod.GET)
		   public List<TotalOrderDetailDto> orderdetail(int obNum) {
			   System.out.println("확인" + obNum);
			   List<TotalOrderDetailDto>  orderdetail = service.orderdetail(obNum);
			   
			   for (TotalOrderDetailDto totalOrderDetailDto : orderdetail) {
				System.out.println("주문상세확인" + totalOrderDetailDto.toString());
			}
			
			   
			   return orderdetail;
		   }
			   
		   //배달원 배달 수락
		   
		   @RequestMapping(value = "/deliAccept", method = RequestMethod.POST)
		   public String deliAccept(DeliAcceptDto accept) {
			   System.out.println("넘어온 데이터 확인:" + accept.toString());
			   
			   boolean result = service.deliAccept(accept);
			   	
			   if(result) {
				   return "success";
			   }else {
				   return "fail";
			   }
			   
			   
		   }
		   	//배달원 배달중
		   
		   @RequestMapping(value = "/godelivery", method = RequestMethod.POST)
		   public String godelivery(DeliAcceptDto accept) {
			   System.out.println("넘어온 데이터 확인:" + accept.toString());
			   
			   boolean result = service.godelivery(accept);
			   	
			   if(result) {
				   return "success";
			   }else {
				   return "fail";
			   }
			   
			   
		   }
		   //배달원 배달완료
		   
		   @RequestMapping(value = "/deliveryend", method = RequestMethod.POST)
		   public String deliveryend(DeliAcceptDto accept) {
			   System.out.println("넘어온 데이터 확인:" + accept.toString());
			   
			   boolean result = service.deliveryend(accept);
			   	
			   if(result) {
				   return "success";
			   }else {
				   return "fail";
			   }
			   
			   
		   }
		   
		   
		   
			  
		   //배달원 나의 배송목록
		   @RequestMapping(value = "/Mydelivery", method = RequestMethod.GET)
			 public List<DeliToTalDto> Mydelivery(MyDeliPagingParam param){
				 System.out.println("Mydelivery");
				 
				 
				 	//들어온 데이터 확인
					System.out.println(param.toString());
					
					int pagen = param.getPage();
					int start = pagen * 10 + 1;
					int end = (pagen + 1)*10;
					System.out.println("start:"+ start);
					System.out.println("end:"+ end);
					
				
					
					//시작, 종료 설정
					param.setStart(start);
					param.setEnd(end);
				 
					List<DeliToTalDto> Mydelivery = service.Mydelivery(param);
					for (DeliToTalDto deliToTalDto : Mydelivery) {
						System.out.println("데이터확인:" + deliToTalDto.toString());
					}
					return Mydelivery;
				 
				 
				 
			 }
		   
		   //나의 배송목록 갯수
		   @RequestMapping(value = "/MydeliveryCount", method = RequestMethod.GET)
		   public int MydeliveryCount(MyDeliPagingParam param) {
			   int count = service.MydeliveryCount(param);
			   System.out.println("나의 배송목록 갯수" + count);
			   
			   int pagenum = count/10;
			   if((count %10)>0) {
				   pagenum = pagenum + 1;
				   
			   }
			   System.out.println("페이지 갯수 확인:" +  pagenum);
			   return pagenum;
		   }
		   
		   
}
