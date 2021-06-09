package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.service.AdminSalesService;

@RestController
public class AdminSalesController {

	@Autowired
	AdminSalesService service;
}
