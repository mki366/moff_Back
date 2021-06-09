package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminMemberDao;
import bit.com.a.dto.MonthlyMember;

@Service
@Transactional
public class AdminMemberService {
	
	@Autowired
	AdminMemberDao dao;
	
	//월별 회원가입 
	public List<MonthlyMember> MonthlyMember(){
		return dao.MonthlyMember();
	}
}
