package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BoardLikeDao;
import bit.com.a.dto.BoardLikeDto;

@Service
@Transactional
public class BoardLikeService {

	@Autowired
	BoardLikeDao dao;
	
	// 좋아요 insert
	public boolean addLikeList(BoardLikeDto dto) {
		int count = dao.addLikeList(dto);
		
		return count>0?true:false;
	}
	
	// 좋아요 총 수
	public int likeCount(BoardLikeDto dto) {
		int count = dao.likeCount(dto);
		
		return count;
	}
	
	// 업데이트
	public boolean updateLike(BoardLikeDto dto) {
		int count = dao.updateLike(dto);
		
		return count>0?true:false;
	}
	
	// 좋아요 삭제
	public boolean delLike(BoardLikeDto dto) {
		int count = dao.delLike(dto);
		
		return count>0?true:false;
	}
	
	// 디테일 좋아요 insert
	public boolean addLikeDetail(BoardLikeDto dto) {
		int count = dao.addLikeDetail(dto);
		
		return count>0?true:false;
	}
	
	
	
	
}





