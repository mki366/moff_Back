package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.WishCartDto;

@Mapper
@Repository
public interface WishCartDao {

	public List<WishCartDto> getWish(String id);
	public List<WishCartDto> getCart(String id);
	
	public void wishToCart(int cNum);
	public void delWishCart(int cNum);
}
