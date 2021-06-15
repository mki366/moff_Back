package bit.com.a.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.ProductDao;
import bit.com.a.dto.CartDto;
import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductDao prdDao;
	
	public List<ProductDto> getAllProductList(ProductDto prdDto) {
		 
				List<ProductDto> l=	prdDao.getAllProductList(prdDto);
				System.out.println("service: " + l.toString());
	return l;
	}
	
	public int getProductCount(ProductDto prdDto) {
		
		return prdDao.getProductCount(prdDto);
	}
	
	// 디테일
	public ProductDto getProduct(int prodNum) {
		return prdDao.getProduct(prodNum);
	}
	
	// 디테일 이미지
	public List<ProductImgDto> getProductImg(int prodNum){
		return prdDao.getProductImg(prodNum);
	}
	
	// 조회수
	public void readCountProduct(int prodNum) {
		prdDao.readCountProduct(prodNum);
	}
	
	// 필터 검색
	public List<ProductDto> productFilter(Map<String, Object> prdMap) {

		List<ProductDto> f = prdDao.productFilter(prdMap);
		System.out.println("productFilter service: " + f.toString());
		
		return prdDao.productFilter(prdMap);
	}
	
	//필터검색 글 총수
	public int filterCount(Map<String, Object> prdMap) {
		
		return prdDao.filterCount(prdMap);
	}
	
	// 상품리스트에서 카트 
	public boolean setCart(CartDto cartDto) {
		System.out.println("cartDto 확인 : " + cartDto);
		int count = prdDao.setCart(cartDto);
		
		return count>0?true:false;
	}
	
	// 상품리스트에서 하트(위시리스트)
	public boolean setWishList(CartDto cartDto) {
		System.out.println("wish Service 확인 : " + cartDto);
		int count = prdDao.setWishList(cartDto);
		
		return count>0?true:false;
	}
	
	// 상품리스트에서 하트 중복x
	public int wishCount(CartDto cartDto) {
		int count = prdDao.wishCount(cartDto);
		
		return count;
	}
	
	// 상품디테일에서 카트 
	public boolean detailCart(CartDto cartDto) {
		int count = prdDao.detailCart(cartDto);
		
		return count>0?true:false;
	}
	
	// 상품디테일에서 하트(위시리스트)
	public boolean detailWishList(CartDto cartDto) {
		int count = prdDao.detailWishList(cartDto);
		
		return count>0?true:false;
	}
	
	// 디테일에서 컬러 불러오깅
	public List<ColorDto> detailColor(int prodNum) {
		
		return prdDao.detailColor(prodNum);
	}
	
	// 디테일에서 컬러 클릭 시 사진 띄우기
	public ColorDto getColorFilename(ColorDto colorDto) {
		return prdDao.getColorFilename(colorDto);
	}
	
	// 디테일 연관상품
	public List<ProductDto> relatedProduct(String subCategory) {
		return prdDao.relatedProduct(subCategory);
	}
	
	// 리스트에서 위시리스트 두번 클릭 시 데이터 삭제
	public boolean deleteWish(CartDto cartDto) {
		int count = prdDao.deleteWish(cartDto);
		return count>0?true:false;
	}
	
	public int cartCount(CartDto cartDto) {
		int count = prdDao.cartCount(cartDto);
		return count;
	}
	
	//////////// 다솜 쇼룸 /////////////////

   // 쇼룸 말풍선 
   public ProductDto srList(int prodNum) {
      return prdDao.srList(prodNum);
   }
   
   // 메인 상품 리스트 (새로운순)
   public List<ProductDto> mainProductList(ProductDto prdDto) {
      return  prdDao.mainProductList(prdDto);
      
   }
   
   // 메인 상품 리스트 (조회수순)
   public List<ProductDto> mainReadcountList(ProductDto prdDto){
      return prdDao.mainReadcountList(prdDto);
      
   }

   // 메인 상품 리스트 (베스트순)
   public List<ProductDto> mainBestList(ProductDto prdDto){
      return prdDao.mainBestList(prdDto);
      
   }
   
   
   
   
   
   
   
   
}




