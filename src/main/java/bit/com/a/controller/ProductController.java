package bit.com.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.CartDto;
import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;
import bit.com.a.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 리스트
	@RequestMapping(value = "/getAllProductList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductDto> getAllProductList(ProductDto prdDto){
		System.out.println("ProductController getAllProductList() " + new Date());
		
		int sn = prdDto.getPage();
		System.out.println("페이지 확인"+sn);
		
		int start = sn * 9 + 1;
		int end = (sn + 1) * 9;
		
		
		prdDto.setStart(start);
		System.out.println("페이지 확인"+start);
		
		prdDto.setEnd(end);
		System.out.println("페이지 확인"+end);
	//	Map<String, Object> map = new HashMap<String, Object>();
		
	
		
		List<ProductDto> list = service.getAllProductList(prdDto);
	//	System.out.println("확인하려는 list" + list);
		
	//	map.put("star", star);
		
		return list;
	
	}
	

	// 글 총수
	@RequestMapping(value = "/getProductCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int productCount(ProductDto prdDto) {
		int count = service.getProductCount(prdDto);
		System.out.println("count :" + count);
		
		return count;
	}
	
	// 글 총수 + 페이지
	@RequestMapping(value = "/Pagination", method = {RequestMethod.GET, RequestMethod.POST})
	public int Pagination(ProductDto prdDto) {
		int count = service.getProductCount(prdDto);
		System.out.println("count 갯수: " + count);
		
		int pagenum = count/9;
		if((count %9)>0) {
			pagenum = pagenum + 1;
		}
		
		System.out.println(" 리스트 페이지 갯수 확인: " + pagenum);
		return pagenum;
	}
	
	
	// 디테일
	@RequestMapping(value = "/getProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public ProductDto productDetail(int prodNum, Model model) {
		System.out.println("ProductController productDetail() " + new Date());
		ProductDto dto = service.getProduct(prodNum);
		service.readCountProduct(prodNum);
		
		model.addAttribute("dto", dto);

		return dto;
		
	}
	
	
	// 디테일 이미지 가져오기
	@RequestMapping(value = "/getProductImg", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductImgDto> productDetailImg(int prodNum){
		System.out.println("productDetailImg productDetail() " + new Date());
		
		List<ProductImgDto> imgList = service.getProductImg(prodNum);
		System.out.println("imgList" + imgList.toString());
		System.out.println("imgProdNum: " + prodNum);
		
		return imgList;
	}

	// 필터 검색
	@RequestMapping(value = "/prdoductFilter", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductDto> prdoductFilter(int page, String _color, String _star, String _category, String _subCategory,
											String _min, String _max){
		
		System.out.println("prdoductFilter" + new Date());
		Map<String, Object> prdMap = new HashMap<String, Object>();
		
		int sn = page;
		int start = sn * 9 + 1;
		int end = (sn + 1) * 9;
		
		
		//prdDto.setStart(start);
		//prdDto.setEnd(end);
		
		prdMap.put("color", _color);
		prdMap.put("star", _star);
		prdMap.put("category", _category);
		prdMap.put("subCategory", _subCategory);

		prdMap.put("min", _min);
		prdMap.put("max", _max);
		
		
		prdMap.put("start", start);
		prdMap.put("end", end);
		
		List<ProductDto> list = service.productFilter(prdMap);
		System.out.println("category: " + _category);
		
		System.out.println("min: " + _min);
		System.out.println("max: " + _max);
				
		return list;
	}
	
	// 필터검색 글 총수 + 페이징
	@RequestMapping(value = "/filterCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int filterCount(String _color, String _star, String _category, String _subCategory,
							String _min, String _max) {
		
		System.out.println("filterCount" + new Date());
		
		Map<String, Object>prdMap = new HashMap<String, Object>();
		
		prdMap.put("color", _color);
		prdMap.put("star", _star);
		prdMap.put("category", _category);
		prdMap.put("subCategory", _subCategory);

		prdMap.put("min", _min);
		prdMap.put("max", _max);
		
		
		
		int count = service.filterCount(prdMap);
		System.out.println(" 필터 count: " + count);
		
		int pagenum = count/9;
		if((count %9)>0) {
			pagenum = pagenum + 1;
		}
		
		System.out.println(" 필터 페이지 갯수 확인: " + pagenum);
		System.out.println("_min: " + _min);
		System.out.println("_max: " + _max);
		return pagenum;
		
	}
	

	
	
	
	// 상품리스트에서 카트
	@RequestMapping(value = "/setCart", method = {RequestMethod.GET, RequestMethod.POST})
	public String setCart(CartDto cartDto) {
		System.out.println("setCart Controller" + new Date());
		System.out.println("리스트카트: " + cartDto.toString());
		
		int cartCount = service.cartCount(cartDto);
		
		if(cartCount < 1) {
			service.setCart(cartDto);
			return "setCart Success";
		} else {
			return "setCart error";
		}
		
	}
	
	// 상품리스트에서 하트(위시리스트)
	@RequestMapping(value = "/setWishList", method = {RequestMethod.GET, RequestMethod.POST})
	public String setWishList(CartDto cartDto) {
		System.out.println("setWishList COntroller: " + new Date());
		
		int wishCount = service.wishCount(cartDto);
		
		System.out.println("wishCount:" + wishCount);
		
		if(wishCount < 1) {
			service.setWishList(cartDto);
			return "success";
		} else {
			return "failed";
		}
	}
	
	// 리스트에서 퀵뷰
	@RequestMapping(value = "/getQuickView", method = {RequestMethod.GET, RequestMethod.POST})
	public ProductDto getQuickView(int prodNum) {
		System.out.println("getQuickView: " + new Date());
		ProductDto dto = service.getProduct(prodNum);
		
		return dto;
	}
	
	// 리스트 퀵뷰-> 카트
	@RequestMapping(value = "/setQuickCart", method = {RequestMethod.GET, RequestMethod.POST})
	public String setQuickCart(CartDto cartDto) {
		int cartCount = service.cartCount(cartDto);
		
		System.out.println("quickCount: " + cartCount);
		
		if(cartCount < 1) {
			service.setCart(cartDto);
			return "quickCart Success";
		}else {
			return "quickCart error";
		}
	}
	
	
	// 상품디테일에서 카트
	@RequestMapping(value = "/detailCart", method = {RequestMethod.GET, RequestMethod.POST})
	public String detailCart(CartDto cartDto) {
		System.out.println("상품디테일 카트 확인 : " + cartDto.toString());
		
		int cartCount = service.cartCount(cartDto);
		
		if(cartCount < 1) {
			service.detailCart(cartDto);
			return "detialCart Success";
			
		}else {
			return "detialCart error";
		}
	}
	
	// 상품디테일에서 하트(위시리스트)
	@RequestMapping(value = "/detailWishList", method = {RequestMethod.GET, RequestMethod.POST})
	public String detailWishList(CartDto cartDto) {
		
		int wishCount = service.wishCount(cartDto);
		if(wishCount > 1) {
			service.detailWishList(cartDto);
			return "detialWishList Success";
			
		}else {
			return "detialWishList error";
		}
	}
	
	// 디테일에서 컬러
	@RequestMapping(value = "/detailColor", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ColorDto> detailColor(ColorDto colorDto){
		System.out.println("detailColor Controller");
		
		List<ColorDto> colorList = service.detailColor(colorDto);
		
		System.out.println("colorList: " + colorList.toString());
		
		return colorList;
	}
	
	// 컬러 클릭 시 사진 띄우기
	@RequestMapping(value = "/getColorFilename", method = {RequestMethod.GET, RequestMethod.POST})
	public ColorDto getColorFilename(ColorDto colorDto) {
		System.out.println("getColorFilename Controller");
		
		ColorDto dto = service.getColorFilename(colorDto);
		
		return dto;
	}
	
	// 디테일에서 연관상품
	@RequestMapping(value = "/relatedProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductDto> relatedProduct(String subCategory){
		System.out.println("relatedProduct Controller");
		System.out.println("연관상품확인: "+subCategory.toString());
		
		
		List<ProductDto> list = service.relatedProduct(subCategory);
		System.out.println("relatedProduct"+list);
		System.out.println("sub"+subCategory);
		
		return list;
		
	}
	
	// 리스트에서 위시리스트 두번 클릭 시 데이터 삭제
	@RequestMapping(value = "/deleteWish", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteWish(CartDto cartDto) {
		if(service.deleteWish(cartDto)==true) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	
	///////// 다솜 //////////////////

   // 쇼룸 
   @RequestMapping(value = "/srList", method = {RequestMethod.GET, RequestMethod.POST})
   public ProductDto srList(int prodNum) {
      System.out.println("ProductController srList() " + new Date());
      ProductDto dto = service.srList(prodNum);
      
      return dto;
      
   }
   
   // 메인 상품 리스트 (새로운순 )
   @RequestMapping(value = "/mainProductList", method = {RequestMethod.GET, RequestMethod.POST})
   public List<ProductDto> mainProductList(ProductDto prdDto){
      System.out.println("mainProductList() " + new Date());
      System.out.println(prdDto.toString());
      
      List<ProductDto> list = service.mainProductList(prdDto);
      return list;
      
   }
   
   // 메인 상품 리스트 (조회수순 )
   @RequestMapping(value = "/mainReadcountList", method = {RequestMethod.GET, RequestMethod.POST})
   public List<ProductDto> mainReadcountList(ProductDto prdDto){
      System.out.println("mainReadcountList() " + new Date());
      System.out.println(prdDto.toString());
      
      List<ProductDto> list = service.mainReadcountList(prdDto);
      return list;
      
   }
   
   // 메인 상품 리스트 (베스트순 )
   @RequestMapping(value = "/mainBestList", method = {RequestMethod.GET, RequestMethod.POST})
   public List<ProductDto> mainBestList(ProductDto prdDto){
      System.out.println("mainBestList() " + new Date());
      System.out.println(prdDto.toString());
      
      List<ProductDto> list = service.mainBestList(prdDto);
      
      for (ProductDto productDto : list) {
         System.out.println("베스트순 리스트 확인:" +  productDto.toString());
      }
      
      return list;
      
   }
   
	   
	
	
	
}










