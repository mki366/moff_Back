package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.AdPagingParam;
import bit.com.a.dto.DeliAcceptDto;
import bit.com.a.dto.DeliToTalDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MyDeliPagingParam;
import bit.com.a.dto.TotalOrderDetailDto;

@Mapper
@Repository

public interface DeliDao {
	
	//배달원 지원
	public int addDelivery(MemberDto dto);
	
	//관리자페이지-전체회원리스트
	public List<MemberDto> allmemberList(AdPagingParam param);
	
	//회원의 총수
	public int getmemberList(AdPagingParam param);
	
	//관리자페이지-배달원 승인을위한 배달원 신청 리스트
	public List<MemberDto> deliverymanList(AdPagingParam param);
	
	//배달원신청자의 총 인원
	public int deliveryman(AdPagingParam param);
	
	//배달원 신청 폼 데이터를 받기위함
	//배달기사 신청자 별 정보
	public MemberDto getdeliveryman(int memNum);
	
	//배달기사 신청자 승인
	public int deliveryAdmi(int memNum);
	
	
	//전체 주문내역- 배달 상태확인
	public List<DeliToTalDto> TotalOrder(AdPagingParam param);
	
	//전체 주문내역- 배달 상태확인 갯수
	public int TotalOrderCount(AdPagingParam param);

	//주문상세
	public List<TotalOrderDetailDto> orderdetail(int obNum);
	
	//배달원 배달 수락
	public int deliAccept(DeliAcceptDto dto);
	
	//배달원 배송중
	public int godelivery(DeliAcceptDto dto);
	
	//배달원 배송완료
	public int deliveryend(DeliAcceptDto dto);
	
	//배달원 나의 배송목록
	public List<DeliToTalDto> Mydelivery(MyDeliPagingParam param);
	
	//배달원 나의 배송목록 전체 갯수
	public int MydeliveryCount(MyDeliPagingParam param);
	
	
}
