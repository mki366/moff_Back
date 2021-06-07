package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.WishCartDto;
import bit.com.a.service.WishCartService;

@RestController
public class WishCartController {

	@Autowired
	WishCartService service;
	
	@RequestMapping(value = "/getWish", method = RequestMethod.POST)
	public List<WishCartDto> getWish(String id) {
		System.out.println("WishCartController getWish()");
		
		List<WishCartDto> wishlist = service.getWish(id);
		
		// 확인용
		for (WishCartDto wishCartDto : wishlist) {
			System.out.println(wishCartDto.toString());
		}
		
		return wishlist;
	}
	
	@RequestMapping(value = "/getCart", method = RequestMethod.POST)
	public List<WishCartDto> getCart(String id) {
		System.out.println("WishCartController getCart()");
		
		List<WishCartDto> cartlist = service.getCart(id);
		
		// 확인용
		for (WishCartDto wishCartDto : cartlist) {
			System.out.println(wishCartDto.toString());
		}
		
		return cartlist;
	}
	

	@RequestMapping(value = "/wishToCart", method = RequestMethod.POST)
	public void wishToCart(int cNum) {
		System.out.println("WishCartController wishToCart()");
		
		service.wishToCart(cNum);
	}
	

	@RequestMapping(value = "/delWishCart", method = RequestMethod.POST)
	public void delWish(int cNum) {
		System.out.println("WishCartController delWishCart()");
		
		service.delWishCart(cNum);
	}
}
