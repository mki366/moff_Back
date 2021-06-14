package bit.com.a.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.AdminMemberDao;
import bit.com.a.dto.MemberAge;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MonthlyMember;

@Service
@Transactional
public class AdminMemberService {
	
	@Autowired
	AdminMemberDao dao;
	
	//월별 회원가입 
	public List<MonthlyMember> MonthlyMemberList(){
		return dao.MonthlyMemberList();
	}
	
	//회원탈퇴
	public boolean MemDel(MemberDto dto) {
		return dao.MemDel(dto)>0?true:false;
	}
	
	//연령별 가입자 수
		public List<MemberAge> TotalAge(){
			return dao.TotalAge();
		}
}
