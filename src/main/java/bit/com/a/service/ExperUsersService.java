package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.ExpertUsersDao;
import bit.com.a.dto.ExpertPagingParam;
import bit.com.a.dto.ExpertUsersDto;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class ExperUsersService {

	 @Autowired
	 private ExpertUsersDao dao;
	//인테리어 업자 추가
	public boolean addExperUsers(ExpertUsersDto dto) {
		
		return dao.addExperUsers(dto)>0?true:false;
	}
	
	//인테리어업자 멤버 테이블에 추가
		public boolean addExperUsersMember(MemberDto dto) {
			return dao.addExperUsersMember(dto)>0?true:false;
		}
		
		
	
	//업체 리스트
	public List<ExpertUsersDto> allExperList(ExpertPagingParam param){
		return dao.allExperList(param);
	}
	
	//업체 갯수
	public int allExperListCOUNT(ExpertPagingParam param) {
		return dao.allExperListCOUNT(param);
	}
	

	//업체 디테일
	public ExpertUsersDto ExpertDetail(int eNUM) {
		return dao.ExpertDetail(eNUM);
	}

	
		//업체 디테일 나의 업체
		public ExpertUsersDto ExpertMyDetail(String id) {
			return dao.ExpertMyDetail(id);
		}
		
}
