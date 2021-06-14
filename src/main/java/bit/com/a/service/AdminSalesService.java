package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminSalesDao;
import bit.com.a.dto.AdminDto;
import bit.com.a.dto.PurchasesDto;

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
	
	public List<PurchasesDto> selDailySales(String yearmonth) {
		return dao.selDailySales(yearmonth);
	}
	public List<PurchasesDto> selMonthlySales(String year) {
		return dao.selMonthlySales(year);
	}
	public List<PurchasesDto> selAnnualSales() {
		return dao.selAnnualSales();
	}
	
	public List<AdminDto> salesReport(String yearmonth) {
		return dao.salesReport(yearmonth);
	}
	
	public List<PurchasesDto> annualSalesChart(String year) {
		return dao.annualSalesChart(year);
	}

	public List<AdminDto> annualAccumChart(String year) {
		return dao.annualAccumChart(year);
	}

	public List<AdminDto> monthlyVarChart() {
		return dao.monthlyVarChart();
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
	//배송중
		public int inDelivery() {
			return dao.inDelivery();
		}
		//배송 완료
		public int delivered() {
			return dao.delivered();
		}
		//배송 전
		public int beforeDelivery() {
			return dao.beforeDelivery();
		}
		//배송 수락
		public int acceptDelivery() {
			return dao.acceptDelivery();

		}

}
