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
	
	/*
	 @RequestMapping(value = "/salesByPeriod", method = RequestMethod.POST) public
	 Array[] salesByPeriod() {
	 System.out.println("AdminSalesController salesByPeriod()");
	 int Array[] = new int[4]; 
	 Array[1] = service.dailySales(); Array[2] = service.monthlySales();
	 Array[3] = service.annualSales(); Array[4] = service.totalSales();
	 
	 return Array; }
	 
*/
	
}
