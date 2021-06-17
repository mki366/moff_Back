package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public boolean idCheck(String id) {
		int n = dao.idCheck(id);
		return n>0?true:false;
	}
	
	public boolean addmember(MemberDto dto) {
		int len = dao.addmember(dto);
		return len>0?true:false;
	}
	
	public boolean snsCheck(String email) {
		int n = dao.snsCheck(email);
		return n>0?true:false;
	}
 
	public MemberDto login(MemberDto dto) {
		MemberDto mem = dao.login(dto);
		return mem;
	}
	
	public MemberDto getMem(MemberDto dto) {
		MemberDto mem = dao.getMem(dto);
		return mem;
	}
	
	public boolean personalUpdate(MemberDto dto) {
		int n = dao.personalUpdate(dto);
		return n>0?true:false;
	}
	
	public boolean contactUpdate(MemberDto dto) {
		int n = dao.contactUpdate(dto);
		return n>0?true:false;
	}
	
	public boolean pwdUpdate(MemberDto dto) {
		int n = dao.pwdUpdate(dto);
		return n>0?true:false;
	}
	
	public boolean addressUpdate(MemberDto dto) {
		int n = dao.addressUpdate(dto);
		return n>0?true:false;
	}
	
	public boolean byebye(MemberDto dto) {
		int len = dao.byebye(dto);
		return len>0?true:false;
	}
}





