package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;

@Mapper
@Repository
public interface AdminProductDao {
	
	// 상품등록
	boolean productRegi(ProductDto product);
	
	// 색상등록
	boolean colorRegi(ColorDto colorDto);
	
	// 이미지등록
	boolean imgRegi(ProductImgDto img);
	
	// 상품리스트
	public List<ProductDto> adminProductList(ProductDto product);
	
	// 총수 adminProductCount
	int adminProductCount(ProductDto product);
	
	// 디테일 "adminProductDetail"
	public ProductDto adminProductDetail(int prodNum);
	
	// 디테일 이미지 adminImgDetail
	public List<ProductImgDto> adminImgDetail(int prodNum);
	
	// 디테일 컬러 adminColorDetail
	public List<ColorDto> adminColorDetail(int prodNum);
	
	// 상품수정 adminProductUpdate
	int adminProductUpdate(ProductDto product);
	
	// 컬러 수정 adminColorUpdate
	int adminColorUpdate(ColorDto colorDto);
	
	// 이미지수정 adminImgUpdate
	int adminImgUpdate(ProductImgDto img);
	
	// 색상추가 addColor
	boolean addColor(ColorDto colorDto);

	// 이미지추가 addImage
	boolean addImage(ProductImgDto img);
	
	// 수정에서 디테일불러오기 getAdminProduct
	public ProductDto getAdminProduct(int prodNum);
	
 	// 수정에서 이미지 불러오기 getAdminImgae
	public List<ProductImgDto> getAdminImgae(int prodNum);
	
 	// 수정에서 컬러 getAdminColor
	public List<ColorDto> getAdminColor(ColorDto colorDto);
	
	// 상품삭제
	int delProduct(int prodNum);
	
	// 재고 리스트
	public List<ProductDto> stockList(ProductDto product);
	
	// 재고리스트 총 수
	int stockListCount(ProductDto product);
	
	// 재고 수량 추가
	int stockUpdate(ProductDto product);
	
	
	
	////////// 다솜 ////////////////
	// 조회수순 상품리스트
		 public List<ProductDto> mainRcList(ProductDto product);
		  
		 // 총 조회수
		 int rCount();
		 
		 
		 //카테고리별 주문건수 
		 public List<ProductDto> catelist(ProductDto product);

		 
		 //상품별 주문건수 
		 public List<ProductDto> prodlist(ProductDto product);
}








