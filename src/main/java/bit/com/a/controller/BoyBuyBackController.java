package bit.com.a.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BoyBuyBackParam;
import bit.com.a.dto.BuyBackAcceptDto;
import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.DeliAcceptDto;
import bit.com.a.dto.MyDeliPagingParam;
import bit.com.a.service.BoyBuyBackService;

@RestController
public class BoyBuyBackController {
	@Autowired
	ServletContext serveltContext;
	
	@Autowired
	BoyBuyBackService service;
	
	@RequestMapping(value = "/TotalBuyBack", method = RequestMethod.POST)
	public List<BuybackDto> TotalBuyBack(BoyBuyBackParam param){
		
		System.out.println("TotalBuyBack 데이터 들어오는 값 확인:"+ param.toString());
		
		int pagen = param.getPage();
		int start = pagen * 5 + 1;
		int end = (pagen + 1)*5;
		System.out.println("start:"+ start);
		System.out.println("end:"+ end);
		
		//시작, 종료 설정
		param.setStart(start);
		param.setEnd(end);
		
		
		System.out.println("페이지 넣고 최종 마이바티스 입력:"+ param.toString());
		
		
		List<BuybackDto> TotalBuyBack = service.TotalBuyBack(param);
		
		for (BuybackDto buybackDto : TotalBuyBack) {
			System.out.println("TotalBuyBack 리스트 확인:" + buybackDto.toString());
		}
		
		
		return TotalBuyBack;
		
	}
	
	@RequestMapping(value = "/TotalBuyBackCount", method = RequestMethod.POST)
	public int TotalBuyBackCount(BoyBuyBackParam param) {
		int count = service.TotalBuyBackCount(param);
		
		System.out.println("TotalBuyBackCount 데이터 들어온값 확인:" + param.toString());
		
		  int pagenum = count/5;
		   if((count %5)>0) {
			   pagenum = pagenum + 1;
			   
		   }
		   
		   System.out.println("페이지 갯수 확인:" +  pagenum);
		   return pagenum;
	}
	
	   @RequestMapping(value = "/acceptBuyBack", method = RequestMethod.POST)
	   public String acceptBuyBack(BuyBackAcceptDto accept) {
		   System.out.println("넘어온 데이터 확인:" + accept.toString());
		   
		   boolean result = service.acceptBuyBack(accept);
		   	
		   if(result) {
			   return "success";
		   }else {
			   return "fail";
		   }
		   
		   
	   }
	
	   @RequestMapping(value = "/MyBuyBack", method = RequestMethod.POST)
		public List<BuybackDto> MyBuyBack(BoyBuyBackParam param){
			
			System.out.println("MyBuyBack 데이터 들어오는 값 확인:"+ param.toString());
			
			int pagen = param.getPage();
			int start = pagen * 5 + 1;
			int end = (pagen + 1)*5;
			System.out.println("start:"+ start);
			System.out.println("end:"+ end);
			
			//시작, 종료 설정
			param.setStart(start);
			param.setEnd(end);
			
			
			System.out.println("페이지 넣고 최종 마이바티스 입력:"+ param.toString());
			
			
			List<BuybackDto> MyBuyBack = service.MyBuyBack(param);
			
			for (BuybackDto buybackDto : MyBuyBack) {
				System.out.println("MyBuyBack 리스트 확인:" + buybackDto.toString());
			}
			
			
			return MyBuyBack;
			
		}
		
		@RequestMapping(value = "/MyBuyBackCount", method = RequestMethod.POST)
		public int MyBuyBackCount(BoyBuyBackParam param) {
			int count = service.MyBuyBackCount(param);
			
			System.out.println("MyBuyBackCount 데이터 들어온값 확인:" + param.toString());
			
			  int pagenum = count/5;
			   if((count %5)>0) {
				   pagenum = pagenum + 1;
				   
			   }
			   
			   System.out.println("페이지 갯수 확인:" +  pagenum);
			   return pagenum;
		}
}
