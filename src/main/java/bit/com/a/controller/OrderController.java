package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.ColorDto;
import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;
import bit.com.a.dto.PurchasesDto;
import bit.com.a.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	public OrderService service;
	
	@RequestMapping(value = "/getPurchases", method = RequestMethod.POST)
	public List<PurchasesDto> getPurchases(String id) {
		System.out.println("OrderController getPurchases()");

		List<PurchasesDto> list = service.getPurchases(id);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
				
		return list;
	}
	
	@RequestMapping(value = "/purchasesCNT", method = RequestMethod.POST)
	public List<PurchasesDto> purchasesCNT(String id) {
		System.out.println("OrderController purchasesCNT()");

		List<PurchasesDto> list = service.purchasesCNT(id);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
				
		return list;
	}

	
	@RequestMapping(value = "/obExchange", method = RequestMethod.POST)
	public List<PurchasesDto> obExchange(String id) {
		System.out.println("OrderController obExchange()");

		List<PurchasesDto> list = service.obExchange(id);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
				
		return list;
	}
	
	@RequestMapping(value = "/obRefund", method = RequestMethod.POST)
	public List<PurchasesDto> obRefund(String id) {
		System.out.println("OrderController obRefund()");

		List<PurchasesDto> list = service.obRefund(id);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
				
		return list;
	}
	
	@RequestMapping(value = "/exCNT", method = RequestMethod.POST)
	public int exCNT(String id) {
		System.out.println("OrderController exCNT()");
		return service.exCNT(id) + service.refundCNT(id);
	}
	
	@RequestMapping(value = "/exCheck", method = RequestMethod.POST)
	public int exCheck(int odNum) {
		System.out.println("OrderController exCheck()");
		return service.exCheck(odNum);
	}
	
	@RequestMapping(value = "/refundCheck", method = RequestMethod.POST)
	public int refundCheck(int odNum) {
		System.out.println("OrderController refundCheck()");
		return service.refundCheck(odNum);
	}
	
	@RequestMapping(value = "/getStatusList", method = RequestMethod.POST)
	public List<PurchasesDto> getStatusList(PurchasesDto dto) {
		System.out.println("OrderController getStatusList()");

		List<PurchasesDto> list = service.getStatusList(dto);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
				
		return list;
	}
	
	@RequestMapping(value = "/getCheckout", method = RequestMethod.POST)
	public PurchasesDto getCheckout(int obNum) {
		System.out.println("OrderController getCheckout()");
		PurchasesDto dto = service.getCheckout(obNum);
		return dto;
	}

	
	@RequestMapping(value = "/purchasesDetail", method = RequestMethod.POST)
	public List<PurchasesDto> purchasesDetail(int obNum) {
		System.out.println("OrderController purchasesDetail()");
		
		List<PurchasesDto> list = service.purchasesDetail(obNum);
		
		// 확인용
		for (PurchasesDto purchasesDto : list) {
			System.out.println(purchasesDto.toString());
		}
		return list;
	}
	
	@RequestMapping(value = "/trackDelivery", method = RequestMethod.POST)
	public PurchasesDto trackDelivery(int obNum) {
		System.out.println("OrderController trackDelivery()");
		PurchasesDto dto = service.trackDelivery(obNum);
		System.out.println(dto.toString());
		return dto;
	}
	
	
	
	//
	@RequestMapping(value = "/updatePoint", method = RequestMethod.GET)
	public String updatePoint(MemberDto dto) {
		System.out.println("HelloController pointChange() " + new Date());
		boolean b = service.updatePoint(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}


	@RequestMapping(value = "/setOrder", method = RequestMethod.GET)
	public int setOrder(OrderBuyDto dto) {
		System.out.println("HelloController setOrder() " + new Date());
		System.out.println(dto.toString());
		int b = service.setOrder(dto);
		System.out.println(b);
		return b;
	}
				
	
	@RequestMapping(value = "/OrderDelCart", method = RequestMethod.GET)
	public void OrderDelCart(String id) {
		System.out.println("HelloController OrderDelCart() " + new Date());
		System.out.println(id);
		service.OrderDelCart(id);
		
	}
	
	@RequestMapping(value = "/setOrderDetail", method = RequestMethod.GET)
	public int setOrderDetail(OrderDetailDto dto) {
		System.out.println("HelloController setOrderDetail() " + new Date());
		//System.out.println(dto.toString());
		//prodNum을 가져옴
		OrderDetailDto rdto= service.getProdInfo(dto);
		/*
		 * if(rdto.getPrice()==0) { System.out.println("세일 안하는 상품"); OrderDetailDto
		 * Odto=service.getProdOriPrice(dto); rdto.setPrice(Odto.geto) }
		 */
		boolean c=service.updateQuantity(dto);
		if(c) {
			System.out.println("수량 줄이기 성공");
		}else {
			System.out.println("수량 줄이기 실패");
		}
		System.out.println("getProdInfo결과 : "+rdto.getProdOption());
		
		//가져온 정보를 다시 세팅
		dto.setProdOption(rdto.getProdOption());
		dto.setProdName(rdto.getProdName());
		System.out.println("dd"+rdto.getPrice());
		dto.setPrice(rdto.getPrice());
		dto.setColor(rdto.getColor());
		dto.setFilename(rdto.getFilename());
		dto.setWeight(rdto.getWeight());
		System.out.println(dto.toString());
		//orderdetail 넣어주기
		int b = service.setOrderDetail(dto);
		System.out.println(b);
		return b;
	}
	

	@RequestMapping(value = "/setDeliveryCheck", method = RequestMethod.GET)
	public int setDeliveryCheck(DeliveryCheckDto dto) {
		System.out.println("HelloController setDeliveryCheck() " + new Date());
		
		dto.setStatus("배송전");
		System.out.println(dto.toString());
		int b = service.setDeliveryCheck(dto);
		System.out.println(b);
		return b;
	}
	
	@RequestMapping(value = "/getOrderBuyInfo", method = RequestMethod.GET)
	public List<OrderBuyDto> getOrderBuyInfo(OrderBuyDto dto) {
		System.out.println("HelloController getOrderBuyInfo() " + new Date());
		System.out.println("controller = "+ dto.getObNum());
		List<OrderBuyDto> list = service.getOrderBuyInfo(dto);
		return list;
	}
	
	@RequestMapping(value = "/getOrderDetailInfo", method = RequestMethod.GET)
	public List<OrderDetailDto> getOrderDetailInfo(OrderDetailDto dto) {
		System.out.println("HelloController getOrderBuyInfo() " + new Date());
		System.out.println("controller = "+ dto.getObNum());
		List<OrderDetailDto> list = service.getOrderDetailInfo(dto);
		return list;
	}
	
	
	
	
	@RequestMapping(value = "/getOrderDetailOdNum", method = RequestMethod.POST)
	public List<OrderDetailDto> getOrderDetailOdNum(OrderDetailDto dto) {
		System.out.println("OrderController getOrderDetailOdNum()");
		List<OrderDetailDto> list = service.getOrderDetailOdNum(dto);
		System.out.println(list.size());
		return list;
	}
	
	
	@RequestMapping(value = "/getColorList", method = RequestMethod.POST)
	public List<ColorDto> getColorList(ColorDto dto) {
		System.out.println("OrderController getColorList()");
		List<ColorDto> list = service.getColorList(dto);
		System.out.println(list.size());
		return list;
	}
	
	@RequestMapping(value = "/setExColor", method = RequestMethod.POST)
	public String setExColor(OrderDetailDto dto) {
		System.out.println("HelloController setExColor() " + new Date());
		
		boolean b = service.setExColor(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	@RequestMapping(value = "/setTakeback", method = RequestMethod.POST)
	public String setTakeback(OrderDetailDto dto) {
		System.out.println("HelloController setTakeback() " + new Date());
		
		boolean b = service.setTakeback(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
	@RequestMapping(value = "/updateOrderPoint", method = RequestMethod.GET)
	public String updateOrderPoint(MemberDto dto) {
		System.out.println("HelloController updateOrderPoint() " + new Date());
		boolean b = service.updateOrderPoint(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}

	
	
	
}
