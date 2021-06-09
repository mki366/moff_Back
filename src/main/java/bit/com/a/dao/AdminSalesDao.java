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
	
}
