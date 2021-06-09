package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminSalesDao;

@Service
@Transactional
public class AdminSalesService {

	@Autowired
	private AdminSalesDao dao;
	

	public int dailySales() {
		return dao.dailySales();
	}
	public int monthlySales() {
		return dao.monthlySales();
	}
	public int annualSales() {
		return dao.annualSales();
	}
	public int totalSales() {
		return dao.totalSales();
	}
	//주문 건 수 - 오늘 
	public int CountDailySales() {
		return dao.CountDailySales();
	}
	
	//주문 건 수 - 이번달 
	public int CountMonthlySales() {
		return dao.CountMonthlySales();
	}
	//주문 건 수 - 올해 
	public int CountAnnualSales() {
		return dao.CountAnnualSales();
	}
	//주문 건 수 - 총
	public int CountTotalSales() {
		return dao.CountTotalSales();

	}
}
