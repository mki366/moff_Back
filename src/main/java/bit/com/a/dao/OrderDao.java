package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.ColorDto;
import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;
import bit.com.a.dto.PurchasesDto;

@Mapper
@Repository
public interface OrderDao {

	public List<PurchasesDto> getPurchases(String id);
	public PurchasesDto getCheckout(int obNum);
	public List<PurchasesDto> purchasesDetail(int obNum);
	public PurchasesDto trackDelivery(int obNum);
	public List<PurchasesDto> purchasesCNT(String id);
	public List<PurchasesDto> getStatusList(PurchasesDto dto);
	public List<PurchasesDto> obExchange(String id);
	public List<PurchasesDto> obRefund(String id);
	public int exCNT(String id);
	public int refundCNT(String id);
	
	public int updatePoint(MemberDto dto);
	public int setOrder(OrderBuyDto dto);
	public void OrderDelCart(String id);
	public OrderDetailDto getProdInfo(OrderDetailDto dto);
	/* public OrderDetailDto getProdOriPrice(OrderDetailDto dto); */
	
	public int setOrderDetail(OrderDetailDto dto);
	public int setDeliveryCheck(DeliveryCheckDto dto);
	public List<OrderBuyDto> getOrderBuyInfo(OrderBuyDto dto);
	public List<OrderDetailDto> getOrderDetailInfo(OrderDetailDto dto);
	public List<OrderDetailDto> getOrderDetailOdNum(OrderDetailDto dto);
	
	
	public List<ColorDto> getColorList(ColorDto dto); 
	public int setExColor(OrderDetailDto dto);
	public int setTakeback(OrderDetailDto dto);
	public int updateOrderPoint(MemberDto dto);
	
	public int updateQuantity(OrderDetailDto dto);
}
