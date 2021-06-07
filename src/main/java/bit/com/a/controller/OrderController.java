package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
