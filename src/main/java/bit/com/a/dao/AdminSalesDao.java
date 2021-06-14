package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.OrderBuyDto;

import bit.com.a.dto.AdminDto;

import bit.com.a.dto.PurchasesDto;

@Mapper
@Repository
public interface AdminSalesDao {


	// 상단 매출 
	public int dailySales();
	public int monthlySales();
	public int annualSales();
	public int totalSales();
	
	// 세일즈 리포트 
	public List<PurchasesDto> selDailySales(String yearmonth);
	public List<PurchasesDto> selMonthlySales(String year);
	public List<PurchasesDto> selAnnualSales();
	public List<AdminDto> salesReport(String yearmonth);

	// 매출 그래프
	public List<PurchasesDto> annualSalesChart(String year);
	public List<AdminDto> annualAccumChart(String year);
	public List<AdminDto> monthlyVarChart();
	
	//주문 건 수 - 오늘 
	public int CountDailySales();
	//주문 건 수 - 이번 달
	public int CountMonthlySales();
	//주문 건 수 - 올해
	public int CountAnnualSales();
	//주문 건 수 -총
	public int CountTotalSales();
	

	//배송중
	public int inDelivery(DeliveryCheckDto dto);
	//배송 완료
	public int delivered(DeliveryCheckDto dto);
	//배송 전
	public int beforeDelivery(DeliveryCheckDto dto);
	//배송 수락

	public int acceptDelivery(DeliveryCheckDto dto);
	
	//구매 건수
	public int orderBuyDate(OrderBuyDto dto);
	//구매 총 가격
	public int orderBuyPriceDate(OrderBuyDto dto);
	
	//반품 갯수
	public int orderDetailTB(OrderBuyDto dto);
	//교환 갯수
	public int orderDetailEX(OrderBuyDto dto);

	public int acceptDelivery();


	//년도별 주문 건수 
	public int SearchAnnualSales(OrderBuyDto dto);
	
	//지역별 주문 건수 
	public String[] SearchLocalSales();
	//지역별 주문 건수 
	public String[] SearchLocalCountSales();
}

