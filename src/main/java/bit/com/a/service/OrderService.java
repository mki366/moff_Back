package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.OrderDao;
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
}
