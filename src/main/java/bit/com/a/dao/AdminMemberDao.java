package bit.com.a.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.AgeBuyRank;
import bit.com.a.dto.MemberAge;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MonthlyMember;

@Mapper
@Repository
public interface AdminMemberDao {
	//월별가입자
	public List<MonthlyMember> MonthlyMemberList();
	//회원탈퇴
	public int MemDel(MemberDto dto);
	//연령별 가입자 수
	public List<MemberAge> TotalAge();
	//연령별 상품 구매수
	public List<AgeBuyRank> AgeBuyRank();
}
