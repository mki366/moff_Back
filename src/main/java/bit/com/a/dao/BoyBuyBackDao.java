package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BoyBuyBackParam;
import bit.com.a.dto.BuyBackAcceptDto;
import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.MyDeliPagingParam;

@Mapper
@Repository
public interface BoyBuyBackDao {
	//전체 바이백 신청 리스트
	public List<BuybackDto> TotalBuyBack(BoyBuyBackParam param);

	//전체 바이백 신청 리스트 갯수
	public int TotalBuyBackCount(BoyBuyBackParam param);
	
	//바이백 서비스 수락
	public int acceptBuyBack(BuyBackAcceptDto dto);
	
	
	//나의 바이백 신청 리스트
	public List<BuybackDto> MyBuyBack(BoyBuyBackParam param);

	//나의 바이백 신청 리스트 갯수
	public int MyBuyBackCount(BoyBuyBackParam param);
	
}
