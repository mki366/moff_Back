package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.DeliDao;
import bit.com.a.dto.AdPagingParam;
import bit.com.a.dto.DeliAcceptDto;
import bit.com.a.dto.DeliToTalDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MyDeliPagingParam;
import bit.com.a.dto.TotalOrderDetailDto;


@Service
@Transactional
public class DeliService {

	@Autowired
	private DeliDao dao;
	
	public boolean addDelivery(MemberDto dto) {
		int n = dao.addDelivery(dto);
		return n>0?true:false;
	}
	
	//관리자페이지-전체회원리스트
	public List<MemberDto> allmemberList(AdPagingParam param){
		return dao.allmemberList(param);
	}
	
	//회원 총수
	public int getmemberList(AdPagingParam param) {
		
		return dao.getmemberList(param);
	}
	
	//관리자페이지-배달원 승인을위한 배달원 신청 리스트

	public List<MemberDto> deliverymanList(AdPagingParam param){
		return dao.deliverymanList(param);
	}
	
	//배달원신청자의 총 인원
		public int deliveryman(AdPagingParam param) {
			return dao.deliveryman(param);
	}
		
		
	//배달원 신청 폼 데이터를 받기위함
	//배달기사 신청자 별 정보
	public MemberDto getdeliveryman(int memNum) {
		MemberDto dto = dao.getdeliveryman(memNum);
		
		return dto;
	}
	
	//배달기사 신청자 승인
	public boolean deliveryAdmi(int memNum) {
		int a = dao.deliveryAdmi(memNum);
		return a>0?true:false;
	
	}
	
	//전체 주문내역- 배달 상태확인
	public List<DeliToTalDto> TotalOrder(AdPagingParam param){
		return dao.TotalOrder(param);
	}
		
	//전체 주문내역- 배달 상태확인 갯수
	public int TotalOrderCount(AdPagingParam param) {
		return dao.TotalOrderCount(param);
	}
	//주문상세
	public List<TotalOrderDetailDto>  orderdetail(int obNum) {
		return dao.orderdetail(obNum);
	}
	//배달원 배달 수락
	public boolean deliAccept(DeliAcceptDto dto) {
		
		int a = dao.deliAccept(dto);
		
		return a>0?true:false;
	}
	
	
	//배달원 배달중
	public boolean godelivery(DeliAcceptDto dto) {
		
		int a = dao.godelivery(dto);
		
		return a>0?true:false;
	}
	
	//배달원 배달완료
	public boolean deliveryend(DeliAcceptDto dto) {
		
		int a = dao.deliveryend(dto);
		
		return a>0?true:false;
	}
	
	
	
	
	
	//배달원 나의 배송목록
	public List<DeliToTalDto> Mydelivery(MyDeliPagingParam param){
		return dao.Mydelivery(param);
	}		
		
	//배달원 나의 배송목록 전체 갯수
	public int MydeliveryCount(MyDeliPagingParam param) {
		return dao.MydeliveryCount(param);
	}
	
	
}
