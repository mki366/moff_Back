package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {

	public int idCheck(String id);
	public int addmember(MemberDto dto);	
	
	public int snsCheck(String email);
	
	public MemberDto login(MemberDto dto);
	public MemberDto getMem(MemberDto dto);
	
	public int personalUpdate(MemberDto dto);
	public int contactUpdate(MemberDto dto);
	public int pwdUpdate(MemberDto dto);
	public int addressUpdate(MemberDto dto);
}