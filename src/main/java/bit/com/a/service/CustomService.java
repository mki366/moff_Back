package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.CustomDao;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.WishCartDto;

@Service
@Transactional
public class CustomService {

	@Autowired
	private CustomDao dao;
	
	public int getPrice(int prodNum) {
		return dao.getPrice(prodNum);
	}
	
	public void addChairCart(WishCartDto dto) {
		dao.addChairCart(dto);
	}
	
	public void addChairWish(WishCartDto dto) {
		dao.addChairWish(dto);
	}
	
	public ProductDto getCustomProduct(int prodNum){
		return dao.getCustomProduct(prodNum);
	}
	
	public List<ProductDto> getBedList(String bedtype){
		return dao.getBedList(bedtype);
	}
	
	public void addStrgCart(WishCartDto dto) {
		dao.addStrgCart(dto);
	}
	
	public void addStrgWish(WishCartDto dto) {
		dao.addStrgWish(dto);
	}
}
