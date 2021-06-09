package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	
}
