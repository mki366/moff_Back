package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminProductDao;
import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;

@Service
@Transactional
public class AdminProductService {

	@Autowired
	AdminProductDao dao;
	
	// 상품추가
	public boolean productRegi(ProductDto product) {
		return dao.productRegi(product);
	}
	
	// 컬러추가
	public boolean colorRegi(ColorDto colorDto) {
		return dao.colorRegi(colorDto);
	}
	
	// 이미지추가
	public boolean imgRegi(ProductImgDto img) {
		return dao.imgRegi(img);
	}
	
	// 상품리스트
	public List<ProductDto> adminProductList(ProductDto product){
		return dao.adminProductList(product);
	}
	
	// 총수 adminProductCount
	public int adminProductCount(ProductDto product) {
		return dao.adminProductCount(product);
	}
	
	// 디테일 "adminProductDetail"
	public ProductDto adminProductDetail(int prodNum) {
		return dao.adminProductDetail(prodNum);
	}
	
	// 디테일 이미지 adminImgDetail
	public List<ProductImgDto> adminImgDetail(int prodNum){
		return dao.adminImgDetail(prodNum);
	}
	
	// 디테일 컬러 adminColorDetail
	public List<ColorDto> adminColorDetail(int prodNum){
		return dao.adminColorDetail(prodNum);
	}
	
	// 상품수정 adminProductUpdate
	public boolean adminProductUpdate(ProductDto product) {
		int count = dao.adminProductUpdate(product);
		
		return count>0?true:false;
	}
	
	// 컬러 수정 adminColorUpdate
	public boolean adminColorUpdate(ColorDto colorDto) {
		int count = dao.adminColorUpdate(colorDto);
		
		return count>0?true:false;
	}
	
	// 이미지수정 adminImgUpdate
	public boolean adminImgUpdate(ProductImgDto img) {
		int count = dao.adminImgUpdate(img);
		
		return count>0?true:false;
	}
	
	// 색상추가 addColor
	public boolean addColor(ColorDto colorDto) {
		return dao.addColor(colorDto);
	}

	// 이미지추가 addImage
	public boolean addImage(ProductImgDto img) {
		return dao.addImage(img);
	}
	
	// 수정에서 디테일불러오기 getAdminProduct
	public ProductDto getAdminProduct(int prodNum) {
		return dao.getAdminProduct(prodNum);
	}
	
 	// 수정에서 이미지 불러오기 getAdminImgae
	public List<ProductImgDto> getAdminImgae(int prodNum){
		return dao.getAdminImgae(prodNum);
	}
	
 	// 수정에서 컬러 getAdminColor
	public List<ColorDto> getAdminColor(ColorDto colorDto){
		return dao.getAdminColor(colorDto);
	}

	// 상품삭제
	public boolean delProduct(int prodNum) {
		int count = dao.delProduct(prodNum);
		
		return count>0?true:false;
	}
	
	// 재고 리스트
	public List<ProductDto> stockList(ProductDto product){
		return dao.stockList(product);
	}
	
	// 재고리스트 총 수
	public int stockListCount(ProductDto product) {
		return dao.stockListCount(product);
	}
	
	// 재고 수량 변경
	public boolean stockUpdate(ProductDto product) {
		int count = dao.stockUpdate(product);
		
		return count>0?true:false;
	}
	
	// 다솜//////////////////////////////////
	
	// 조회수순 상품리스트
	   public List<ProductDto> mainRcList(ProductDto product){
	      return dao.mainRcList(product);
	      
	   }
	
	 // 총 조회수   
	public int rCount() {
		return dao.rCount();		
	}
	
	// 카테고리별 주문건수 
	public List<ProductDto> catelist(ProductDto product){
		return dao.catelist(product);
		
	}
	
	//상품별  주문건수 
	public List<ProductDto> prodlist(ProductDto product){
		return dao.prodlist(product);
		
	}
	
}






