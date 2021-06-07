package bit.com.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.CommunityDto;
import bit.com.a.dto.CommunityParam;
import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface CommunityDao {

	// 리스트
	public List<CommunityDto> getAllCommunity(CommunityParam param);
	
	// 리스트 총수
	int getAllCommunityCount(CommunityParam param);
	
	// 필터검색 리스트
	public List<CommunityDto> getFilterCommunity(Map<String, Object> map);
	
	// 필터검색 총 수
	int getCommunityCount(Map<String, Object>map);
		
	// 오늘의 인기사진
	public List<CommunityDto> todayList(CommunityDto dto);
	
	// 글쓰기
	int writeCommunity(CommunityDto dto);
	
	// 디테일
	public CommunityDto getCommunity(int cmNum);
	
	// 조회수
	void readCountCommunity(int cmNum);
	
	// 글 수정
	int updateCommunity(CommunityDto dto);
	
	// 글 삭제
	int deleteCommunity(int cmNum);
	
	public CommunityDto getCommunityDetail(int cmNum);
	
	// 포인트주기
	void addPoint(MemberDto mem);
	
	
	
}
