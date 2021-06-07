package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
