package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.ExpertPagingParam;
import bit.com.a.dto.ExpertUsersDto;
import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface ExpertUsersDao {
	
	//인테리어 업자 추가
	public int addExperUsers(ExpertUsersDto dto);
	
	//인테리어업자 멤버 테이블에 추가
	public int addExperUsersMember(MemberDto dto);
	
	
	//업체 리스트
	public List<ExpertUsersDto> allExperList(ExpertPagingParam param);
	
	//업체 갯수
	public int allExperListCOUNT(ExpertPagingParam param);
	
	//업체 디테일
	public ExpertUsersDto ExpertDetail(int eNUM);
	
}
