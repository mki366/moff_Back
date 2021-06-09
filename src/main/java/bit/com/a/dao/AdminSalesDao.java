package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminSalesDao {


	public int dailySales();
	public int monthlySales();
	public int annualSales();
	public int totalSales();
	

	//주문 건 수 - 오늘 
	public int CountDailySales();
	//주문 건 수 - 이번 달
	public int CountMonthlySales();
	//주문 건 수 - 올해
	public int CountAnnualSales();
	//주문 건 수 -총
	public int CountTotalSales();

}
