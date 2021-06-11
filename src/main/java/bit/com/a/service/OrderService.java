package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.OrderDao;
import bit.com.a.dto.ColorDto;
import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;
import bit.com.a.dto.PurchasesDto;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	public List<PurchasesDto> getPurchases(String id){
		return dao.getPurchases(id);
	}
	
	public List<PurchasesDto> purchasesCNT(String id){
		return dao.purchasesCNT(id);
	}
	
	public PurchasesDto getCheckout(int obNum) {
		return dao.getCheckout(obNum);
	}
	
	public List<PurchasesDto> purchasesDetail(int obNum){
		return dao.purchasesDetail(obNum);
	}
	
	public PurchasesDto trackDelivery(int obNum) {
		return dao.trackDelivery(obNum);
	}
	
	public List<PurchasesDto> getStatusList(PurchasesDto dto) {
		return dao.getStatusList(dto);
	}
	public boolean updatePoint(MemberDto dto){
		System.out.println("service-updatePoint: "+dto.getId());

		int len = dao.updatePoint(dto);
		return len>0?true:false;
	}
	
	public int setOrder(OrderBuyDto dto){
		System.out.println("service-setOrder: "+dto.getPrice());

		int len = dao.setOrder(dto);
		System.out.println(dto.getObNum());
		return dto.getObNum();
	}
	
	public void OrderDelCart(String id) {
		System.out.println("service-OrderDelCart: "+id);
		dao.OrderDelCart(id);
	}
	
	public OrderDetailDto getProdInfo(OrderDetailDto dto) {
		System.out.println("service-OrderDelCart: "+dto.getProdNum());
		OrderDetailDto rdto = dao.getProdInfo(dto);
		return rdto;
	}
	
	public int setOrderDetail(OrderDetailDto dto){
		System.out.println("service-setOrderDetail: "+dto.getFilename());

		int len = dao.setOrderDetail(dto);
		System.out.println(dto.getOdNum());
		return dto.getOdNum();
	}
	
	public int setDeliveryCheck(DeliveryCheckDto dto){
		System.out.println("service-setDeliveryCheck: "+dto.getObNum());

		int len = dao.setDeliveryCheck(dto);
		System.out.println(dto.getDcNum());
		return dto.getDcNum();
	}
	
	public List<OrderBuyDto> getOrderBuyInfo(OrderBuyDto dto){
		System.out.println("service-getOrderBuyInfo: "+dto.getObNum());
		
		List<OrderBuyDto> list = dao.getOrderBuyInfo(dto);
		System.out.println(list.size());
		return list;
	}
	
	public List<OrderDetailDto> getOrderDetailInfo(OrderDetailDto dto){
		System.out.println("service-getOrderBuyInfo: "+dto.getObNum());
		
		List<OrderDetailDto> list = dao.getOrderDetailInfo(dto);
		System.out.println(list.size());
		return list;
	}
	
	//odNum으로 OrderDetail가져오기
	public List<OrderDetailDto> getOrderDetailOdNum(OrderDetailDto dto){
		System.out.println("service-getOrderDetailOdNum: "+dto.getOdNum());
		
		List<OrderDetailDto> list = dao.getOrderDetailOdNum(dto);
		System.out.println(list.size());
		return list;
	}
	public List<ColorDto> getColorList(ColorDto dto) {
		return dao.getColorList(dto);
	}
	
	public boolean setExColor(OrderDetailDto dto){
		System.out.println("service-setExColor: "+dto.getOdNum());

		int len = dao.setExColor(dto);
		return len>0?true:false;
	}
	
	public boolean setTakeback(OrderDetailDto dto){
	      System.out.println("service-setTakeback: "+dto.getOdNum());

	      int len = dao.setTakeback(dto);
	      return len>0?true:false;
	   }
	   
   public boolean updateOrderPoint(MemberDto dto){
      System.out.println("service-updateOrderPoint: "+dto.getId());

      int len = dao.updateOrderPoint(dto);
      return len>0?true:false;
   }
   
   public boolean updateQuantity(OrderDetailDto dto){
	      System.out.println("service-updateQuantity: "+dto.getQuantity());

	      int len = dao.updateQuantity(dto);
	      return len>0?true:false;
	   }
}
