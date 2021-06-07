package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BuyBackDao;
import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;
@Service
@Transactional
public class BuyBackService {
@Autowired
BuyBackDao dao;
	public List<ProductDto> getSubCateList(ProductDto dto){
		System.out.println("service-getSubCateList: "+dto.getSubCategory());
		List<ProductDto> list = dao.getSubcategoryList(dto);
		//System.out.println(list.size());
		return list;
	}
	
	
	public ProductDto getdetail(ProductDto dto){
		System.out.println("service-getdetail: "+dto.getProdNum());
		ProductDto rdao = dao.getdetail(dto);
		System.out.println(rdao.getFilename());
		return rdao;
	}
	
	public MemberDto getMemDetail(MemberDto dto){
		System.out.println("service-getMemDetail: "+dto.getId());
		MemberDto rdto = dao.getMemDetail(dto);
		System.out.println("service 결과 : " +rdto.getAddress());
		return rdto;
	}
	
	public int addBuyBack(BuybackDto dto){
		System.out.println("addBuyBack service: "+dto.getbDate());
		int bNum = dao.addBuyBack(dto);
		
		System.out.println(dto.getbNum()); // seq = 1

		return dto.getbNum();
	}
	
	public BuybackDto getMyBuyBack(BuybackDto dto){
		System.out.println("getMyBuyBack service :"+dto.getbNum());
		BuybackDto rdto= dao.getMyBuyBack(dto);
		//System.out.println("getMyBuyBack r :"+rdto.getFilename());
		return rdto;
	}
	
	
}
