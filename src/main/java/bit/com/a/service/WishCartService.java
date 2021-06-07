package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.WishCartDao;
import bit.com.a.dto.WishCartDto;

@Service
@Transactional
public class WishCartService {

	@Autowired
	private WishCartDao dao;
	
	public List<WishCartDto> getWish(String id) {
		return dao.getWish(id);
	}
	
	public List<WishCartDto> getCart(String id) {
		return dao.getCart(id);
	}
	
	public void wishToCart(int cNum) {
		dao.wishToCart(cNum);
	}
	
	public void delWishCart(int cNum) {
		dao.delWishCart(cNum);
	}

}
