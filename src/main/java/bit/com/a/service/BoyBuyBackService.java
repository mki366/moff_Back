package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BoyBuyBackDao;
import bit.com.a.dto.BoyBuyBackParam;
import bit.com.a.dto.BuyBackAcceptDto;
import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.MyDeliPagingParam;

@Service
@Transactional
public class BoyBuyBackService {

	 @Autowired
	 private BoyBuyBackDao dao;
	 
	//전체 마이백 신청 리스트
		public List<BuybackDto> TotalBuyBack(BoyBuyBackParam param){
		
			return dao.TotalBuyBack(param);
		}

	//전체 마이백 신청 리스트 갯수
		public int TotalBuyBackCount(BoyBuyBackParam param) {
			
			return dao.TotalBuyBackCount(param);
		}
		//바이백 수락
		public boolean acceptBuyBack(BuyBackAcceptDto dto) {
			
			return dao.acceptBuyBack(dto)>0?true:false;
		}
		
		//나의 바이백 신청 리스트
		public List<BuybackDto> MyBuyBack(BoyBuyBackParam param){
			return dao.MyBuyBack(param);
		}

		//나의 바이백 신청 리스트 갯수
		public int MyBuyBackCount(BoyBuyBackParam param) {
			return dao.MyBuyBackCount(param);
		}
		
	
	
}
