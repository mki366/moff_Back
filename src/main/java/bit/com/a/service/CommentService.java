package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.CommentDao;
import bit.com.a.dto.CommentDto;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	CommentDao dao;
	

	// 리스트
	public List<CommentDto> getAllComment(CommentDto dto) {
		return dao.getAllComment(dto);
	}
	
	// 댓글 총 수
	public int getCommentCount(CommentDto dto) {
		int count = dao.getCommentCount(dto);
		
		return count;
	}
	
	// 댓글 등록
	public boolean writeComment(CommentDto dto) {
		int count = dao.writeComment(dto);
		
		return count>0?true:false;
	}
	
	// 댓글 수정
	public boolean updateComment(CommentDto dto) {
		int count = dao.updateComment(dto);
		
		return count>0?true:false;
	}
	
	// 댓글 삭제
	public boolean deleteComment(int ctNum) {
		int count = dao.deleteComment(ctNum);
		
		return count>0?true:false;
	}
	
	
	
	
}











