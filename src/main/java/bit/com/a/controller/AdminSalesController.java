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
	

	
}
