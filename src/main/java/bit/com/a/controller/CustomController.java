package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.ProductDto;
import bit.com.a.dto.WishCartDto;
import bit.com.a.service.CustomService;

@RestController
public class CustomController {

	@Autowired
	CustomService service;
	
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public ProductDto getProduct(int prodNum){
		System.out.println("CustomController getProduct()");
		ProductDto dto = service.getProduct(prodNum);
		return dto;
	}
	
	
	
	/* Chair */
	
	@RequestMapping(value = "/getPrice", method = RequestMethod.POST)
	public int getPrice(int upperProd, int lowerProd) {
		
		System.out.println("CustomController getPrice()");
		int price = service.getPrice(upperProd) + service.getPrice(lowerProd);
		
		return price;
	}
	
	@RequestMapping(value = "/onePrice", method = RequestMethod.POST)
	public int onePrice(int prodNum) {
		
		System.out.println("CustomController onePrice()");
		int price = service.getPrice(prodNum);
		
		return price;
	}
	
	@RequestMapping(value = "/addChairCart", method = RequestMethod.POST)
	public void addChairCart(String id, int upperProd, int lowerProd) {
		System.out.println("CustomController addChairCart()");
		service.addChairCart(new WishCartDto(id, lowerProd));
		service.addChairCart(new WishCartDto(id, upperProd));
	}	
	
	@RequestMapping(value = "/addChairWish", method = RequestMethod.POST)
	public void addChairWish(String id, int upperProd, int lowerProd) {
		System.out.println("CustomController addChairWish()");
		service.addChairWish(new WishCartDto(id, lowerProd));
		service.addChairWish(new WishCartDto(id, upperProd));
	}	
	
	
	
	/* Bed */
	
	@RequestMapping(value = "/getBedList", method = RequestMethod.POST)
	public List<ProductDto> getBedList(String type){
		System.out.println("CustomController getBedList()");

		List<ProductDto> list = service.getBedList(type);
		return list;
	}
	
	@RequestMapping(value = "/getBedPrice", method = RequestMethod.POST)
	public int getBedPrice(int frame, int mat, int topper, int pillow, int quilt) {
		
		System.out.println("CustomController getBedPrice()");
		int price = service.getPrice(frame);
		
		if(mat!=0) {
			price += service.getPrice(mat);
		}
		
		if(topper!=0) {
			price += service.getPrice(topper);
		}
		
		if(pillow!=0) {
			price += service.getPrice(pillow);
		}
		
		if(quilt!=0) {
			price += service.getPrice(quilt);
		}
		
		return price;
	}
	
	@RequestMapping(value = "/addBedCart", method = RequestMethod.POST)
	public void addBedCart(String id, int fnum, int mnum, int tnum, int pnum, int qnum){
		System.out.println("CustomController addBedCart()");
		if(fnum!=0) {
			service.addChairCart(new WishCartDto(id, fnum));
		}
		if(mnum!=0) {
			service.addChairCart(new WishCartDto(id, mnum));
		}
		if(tnum!=0) {
			service.addChairCart(new WishCartDto(id, tnum));
		}
		if(pnum!=0) {
			service.addChairCart(new WishCartDto(id, pnum));
		}
		if(qnum!=0) {
			service.addChairCart(new WishCartDto(id, qnum));
		}
	}
	
	@RequestMapping(value = "/addBedWish", method = RequestMethod.POST)
	public void addBedWish(String id, int fnum, int mnum, int tnum, int pnum, int qnum){
		System.out.println("CustomController addBedWish()");
		if(fnum!=0) {
			service.addChairWish(new WishCartDto(id, fnum));
		}
		if(mnum!=0) {
			service.addChairWish(new WishCartDto(id, mnum));
		}
		if(tnum!=0) {
			service.addChairWish(new WishCartDto(id, tnum));
		}
		if(pnum!=0) {
			service.addChairWish(new WishCartDto(id, pnum));
		}
		if(qnum!=0) {
			service.addChairWish(new WishCartDto(id, qnum));
		}
	}
	
}