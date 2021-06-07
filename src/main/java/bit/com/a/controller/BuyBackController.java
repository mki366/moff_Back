package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.service.MemberService;
import bit.com.a.service.BuyBackService;

@RestController		//  = @Controller + @Responsbody -> Restful
public class BuyBackController {
	
	@Autowired
	BuyBackService service;
	
	@RequestMapping(value = "//", method = RequestMethod.GET)
	public String base() {
		System.out.println("HelloController base() " + new Date());		
		
		return "base";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<ProductDto> test(String subcate) {
		System.out.println("HelloController test() " + new Date());
		ProductDto dto =new ProductDto(subcate);
		System.out.println(dto.toString());
		//subcate이름을 받아오고, subcate에 해당하는 데이터들을 몽땅 출력
		List<ProductDto> list =  service.getSubCateList(dto);
		
		System.out.println(list.get(0).getProdNum());
		return list;
	}
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public ProductDto getDetail(int prodNum) {
		System.out.println("HelloController getDetail() " +prodNum);
		ProductDto dto =new ProductDto(prodNum);
		
		ProductDto rdao = service.getdetail(dto);
		return rdao;
	}
	
	@RequestMapping(value = "/getMemDetail", method = RequestMethod.GET)
	public MemberDto getDetail(MemberDto dto) {
		System.out.println("HelloController getMemDetail() " + new Date());
		
		MemberDto rdao = service.getMemDetail(dto);
		return rdao;
	}
	
	   //정보 넣기 & 넣은 정보 반환
		@RequestMapping(value = "/addBuyBack", method = RequestMethod.GET)
		public int addBuyBack(BuybackDto dto) {
			System.out.println("HelloController addBuyBack() " + new Date());
			//가구 정보 가져오기
			ProductDto pdto = new ProductDto(dto.getProdNum());
			ProductDto pRdto = service.getdetail(pdto);
			dto.setCategory(pRdto.getCategory());
			dto.setSubCategory(pRdto.getSubCategory());
			
			double OriPirce = (double)pRdto.getPrice();
			
			dto.setPrice(OriPirce*(dto.getCondition()*0.01));
			System.out.println(dto.getPrice());
			//buy_back에 넣어주기
			int bNum =service.addBuyBack(dto);
			System.out.println(bNum);
			
			return bNum;
		}
		
		
		
		//넣은 정보 반환
		@RequestMapping(value = "/getMyBuyBack", method = RequestMethod.GET)
		public BuybackDto getMyBuyBack(BuybackDto dto) {
			System.out.println("HelloController getMyBuyBack() " + new Date());
			//정보 가져오기
			System.out.println("getMyBuyBack :"+dto.getbNum());
			BuybackDto rdto= service.getMyBuyBack(dto);
			//System.out.println(rdto.getCategory());
			return rdto;
		}
				
			
				
		
}













