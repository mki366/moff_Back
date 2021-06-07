package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.ProductDto;
import bit.com.a.dto.WishCartDto;

@Mapper
@Repository
public interface CustomDao {

	public int getPrice(int prodNum);
	public void addChairCart(WishCartDto dto);
	public void addChairWish(WishCartDto dto);
	public ProductDto getProduct(int prodNum);
	public List<ProductDto> getBedList(String bedtype);
}
