package bit.com.a.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;
import bit.com.a.dto.PurchasesDto;
import bit.com.a.service.AdminSalesService;

@RestController
public class AdminSalesController {

	@Autowired
	AdminSalesService service;
	
	
	@RequestMapping(value = "/salesByPeriod", method = RequestMethod.POST)
	public int[] salesByPeriod() {
		System.out.println("AdminSalesController salesByPeriod()");
		int Array[] = new int[4];
		Array[0] = service.dailySales();
		Array[1] = service.monthlySales();
		Array[2] = service.annualSales();
		Array[3] = service.totalSales();
		return Array;
	}
	
	@RequestMapping(value = "/selDailySales", method = RequestMethod.POST)
	public List<PurchasesDto> selDailySales(String yearmonth) {
		System.out.println("AdminSalesController selDailySales()"); 

		if(yearmonth==null) {
			Date date = new Date();
		
			SimpleDateFormat df = new SimpleDateFormat("yy/MM");
			yearmonth = df.format(date);
		}
		
		List<PurchasesDto> dlist = service.selDailySales(yearmonth);
		return dlist;
	}
	
	@RequestMapping(value = "/selMonthlySales", method = RequestMethod.POST)
	public List<PurchasesDto> selMonthlySales(String year) {
		System.out.println("AdminSalesController selMonthlySales()"); 

		if(year==null) {
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yy");
			year = df.format(date);
		}
		
		List<PurchasesDto> mlist = service.selMonthlySales(year);
		return mlist;
	}
	
	@RequestMapping(value = "/selAnnualSales", method = RequestMethod.POST)
	public List<PurchasesDto> selAnnualSales() {
		System.out.println("AdminSalesController selAnnualSales()"); 

		List<PurchasesDto> alist = service.selAnnualSales();
		return alist;
	}
	

	//주문 건 수 - 오늘 
	@RequestMapping(value = "/CountDailySales", method = RequestMethod.GET)
	public int CountDailySales() {
		System.out.println("AdminSalesController CountDailySales()");
		return service.CountDailySales();
	}
	
	//주문 건 수 - 오늘 
	@RequestMapping(value = "/CountMonthlySales", method = RequestMethod.GET)
	public int CountMonthlySales() {
		System.out.println("AdminSalesController CountMonthlySales()");
		return service.CountMonthlySales();
	}
	
	//주문 건 수 - 올해
	@RequestMapping(value = "/CountAnnualSales", method = RequestMethod.GET)
	public int CountAnnualSales() {
		System.out.println("AdminSalesController CountAnnualSales()");
		return service.CountAnnualSales();
	}
	
	//주문 건 수 - 총
	@RequestMapping(value = "/CountTotalSales", method = RequestMethod.GET)
	public int CountTotalSales() {
		System.out.println("AdminSalesController CountTotalSales()");
		return service.CountTotalSales();
	}

	//배송중
		@RequestMapping(value = "/inDelivery", method = RequestMethod.GET)
		public int inDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController inDelivery()"+dto.getCheckDate());
			return service.inDelivery(dto);
		}

		//배송 완료
		@RequestMapping(value = "/delivered", method = RequestMethod.GET)
		public int delivered(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController delivered()"+dto.getCheckDate());
			return service.delivered(dto);
		}
		
		//배송 전
		@RequestMapping(value = "/beforeDelivery", method = RequestMethod.GET)
		public int beforeDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController beforeDelivery()"+dto.getCheckDate());
			return service.beforeDelivery(dto);
		}
		
		//배송 수락
		@RequestMapping(value = "/acceptDelivery", method = RequestMethod.GET)
		public int acceptDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController acceptDelivery()"+dto.getCheckDate());
			return service.acceptDelivery(dto);
		}
		//구매 건수
		@RequestMapping(value = "/orderBuyDate", method = RequestMethod.GET)
		public int orderBuyDate(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderBuyDate()"+dto.getObDate());
			return service.orderBuyDate(dto);
		}
		//구매 건수
		@RequestMapping(value = "/orderBuyPriceDate", method = RequestMethod.GET)
		public int orderBuyPriceDate(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderBuyPriceDate()"+dto.getObDate());
			return service.orderBuyPriceDate(dto);
		}
		
		//반품 갯수
		@RequestMapping(value = "/orderDetailTB", method = RequestMethod.GET)
		public int orderDetailTB(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderDetailTB()");
			return service.orderDetailTB(dto);
		}
		//교환 갯수
		@RequestMapping(value = "/orderDetailEX", method = RequestMethod.GET)
		public int orderDetailEX(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderDetailEX()");
			return service.orderDetailEX(dto);
		}

	
}
