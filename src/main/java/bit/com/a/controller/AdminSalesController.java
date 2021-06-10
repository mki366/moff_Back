package bit.com.a.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		public int inDelivery() {
			System.out.println("AdminSalesController inDelivery()");
			return service.inDelivery();
		}

		//배송 완료
		@RequestMapping(value = "/delivered", method = RequestMethod.GET)
		public int delivered() {
			System.out.println("AdminSalesController delivered()");
			return service.delivered();
		}
		
		//배송 전
		@RequestMapping(value = "/beforeDelivery", method = RequestMethod.GET)
		public int beforeDelivery() {
			System.out.println("AdminSalesController beforeDelivery()");
			return service.beforeDelivery();
		}
		
		//배송 수락
		@RequestMapping(value = "/acceptDelivery", method = RequestMethod.GET)
		public int acceptDelivery() {
			System.out.println("AdminSalesController acceptDelivery()");
			return service.acceptDelivery();
		}

	
}
