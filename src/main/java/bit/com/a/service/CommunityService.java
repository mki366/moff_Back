package bit.com.a.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.CommunityDao;
import bit.com.a.dto.CommunityDto;
import bit.com.a.dto.CommunityParam;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class CommunityService {

	@Autowired
	CommunityDao dao;
	
	// 리스트
	public List<CommunityDto> getAllCommunity(CommunityParam param) {
		return dao.getAllCommunity(param);
	}
	
	// 리스트 총 수
	public int getAllCommunityCount(CommunityParam param) {
		int count = dao.getAllCommunityCount(param);
		
		return count;
				
	}
	
	// 핉터검색 리스트
	public List<CommunityDto> getFilterCommunity(Map<String, Object> map) {
		return dao.getFilterCommunity(map);
	}
	
	// 필터검색 총 수
	public int getCommunityCount(Map<String, Object>map) {
		int count = dao.getCommunityCount(map);
		
		return count;
	}
	
	// 오늘의 인기사진
	public List<CommunityDto> todayList(CommunityDto dto) {
		return dao.todayList(dto);
	}
	
	// 리스트 카테고리 불러오기
	
	
	// 글쓰기
	public boolean writeCommunity(CommunityDto dto) {
		int count = dao.writeCommunity(dto);
		
		return count>0?true:false;
	}
	
	// 디테일
	public CommunityDto getCommunity(int cmNum) {
		return dao.getCommunity(cmNum);
	}
	
	// 조회수 증가
	public void readCountCommunity(int cmNum) {
		dao.readCountCommunity(cmNum);
	}
	
	
	// 글 수정
	public boolean updateCommunity(CommunityDto dto) {
		System.out.println(dto.getImage1());
		int count = dao.updateCommunity(dto);
		
		return count>0?true:false;
	}
	
	// 글 삭제
	public boolean deleteCommunity(int cmNum) {
		int count = dao.deleteCommunity(cmNum);
		
		return count>0?true:false;
	}
	
	public CommunityDto getCommunityDetail(int cmNum) {
		return dao.getCommunityDetail(cmNum);
	}
	
	// 포인트주기
	public void addPoint(MemberDto mem) {
		dao.addPoint(mem);
	}
	
	// 커뮤니티 인기순 (메인)
	public List<CommunityDto> commuList(CommunityDto dto) {
	     return dao.commuList(dto);
	}

	
	
	
}









