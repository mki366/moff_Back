package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminSalesDao;

import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;

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
	public int inDelivery(DeliveryCheckDto dto) {
		return dao.inDelivery(dto);
	}
	//배송 완료
	public int delivered(DeliveryCheckDto dto) {
		return dao.delivered(dto);
	}
	//배송 전
	public int beforeDelivery(DeliveryCheckDto dto) {
		return dao.beforeDelivery(dto);
	}
	//배송 수락
	public int acceptDelivery(DeliveryCheckDto dto) {
		return dao.acceptDelivery(dto);
	}
	//구매 건수
	public int orderBuyDate(OrderBuyDto dto) {
		return dao.orderBuyDate(dto);
	}
	//구매 총 가격
	public int orderBuyPriceDate(OrderBuyDto dto) {
		return dao.orderBuyPriceDate(dto);
	}
	
	//반품 갯수
	public int orderDetailTB(OrderBuyDto dto) {
		return dao.orderDetailTB(dto);
	}
	//교환 갯수
	public int orderDetailEX(OrderBuyDto dto) {
		return dao.orderDetailEX(dto);
	}
	
	//년도별 주문 건수 
	public int SearchAnnualSales(OrderBuyDto dto) {
		return dao.SearchAnnualSales(dto);
	}
	//지역별 주문 건수 
	public String[] SearchLocalSales() {
		System.out.println();
		return dao.SearchLocalSales();
	}
	//지역별 주문 건수 
	public String[] SearchLocalCountSales() {
		System.out.println();
		return dao.SearchLocalCountSales();
	}
}
