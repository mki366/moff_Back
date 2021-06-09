package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminSalesDao;

@Service
@Transactional
public class AdminSalesService {

	@Autowired
	private AdminSalesDao dao;
	
}
