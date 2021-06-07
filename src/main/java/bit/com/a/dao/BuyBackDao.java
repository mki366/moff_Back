package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;

@Mapper
@Repository
public interface BuyBackDao {

	public List<ProductDto> getSubcategoryList(ProductDto dto);
	
	public ProductDto getdetail(ProductDto dto);
	
	public MemberDto getMemDetail(MemberDto dto);
	
	public int addBuyBack(BuybackDto dto);
	
	public BuybackDto getMyBuyBack(BuybackDto dto);
	
	
}




