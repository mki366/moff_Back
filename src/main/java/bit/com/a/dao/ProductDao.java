package bit.com.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.CartDto;
import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;
import bit.com.a.dto.ReviewDto;

@Mapper
@Repository
public interface ProductDao {

	// 리스트
	public List<ProductDto> getAllProductList(ProductDto prdDto);
	
	// 총수
	int getProductCount(ProductDto prdDto);
	
	// 디테일
	public ProductDto getProduct(int prodNum);
	
	// 디테일 이미지
	public List<ProductImgDto> getProductImg(int prodNum);
	
	// 조회수
	void readCountProduct(int prodNum);
	
	// 필터검색
	public List<ProductDto> productFilter(Map<String, Object> prdMap);
	
	//필터검색 총수
	int filterCount(Map<String, Object> prdMap);
	
	// 상품리스트에서 카트 
	int setCart(CartDto cartDto);
	
	// 상품리스트에서 하트(위시리스트)
	int setWishList(CartDto cartDto);
	
	// 위시 총 수 불러오기 (상품리스트에서 하트 중복x)
	int wishCount(CartDto cartDto);
	
	// 카트 총 수 불러오기
	int cartCount(CartDto cartDto);
	
	//  상품디테일에서 카트
	int detailCart(CartDto cartDto);
	
	// 상품디테일에서 하트(위시리스트)
	int detailWishList(CartDto cartDto);
	
	// 상품디테일에서 컬러불러오기
	public List<ColorDto> detailColor(ColorDto colorDto);
	
	// 디테일에서 관련상품 불러오기
	public List<ProductDto> relatedProduct(String subCategory);
	
	// 컬러 클릭 시 이미지 변경
	public ColorDto getColorFilename(ColorDto colorDto);
	
	// 리스트에서 위시리스트 두번 클릭 시 데이터 삭제
	public int deleteWish(CartDto cartDto);
	
	////////////// 다솜 쇼룸 ///////////////////
	
	// 쇼룸 말풍선 
   public ProductDto srList(int prodNum);
   
   // 메인 상품 리스트 (새로운순)
   public List<ProductDto> mainProductList(ProductDto prdDto);
   
   // 메인 상품 리스트(조회수순)
   public List<ProductDto> mainReadcountList(ProductDto prdDto);
   
   // 메인 상품 리스트(베스트순)
   public List<ProductDto> mainBestList(ProductDto prdDto);
	
}





