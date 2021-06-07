package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.CommentDto;

@Mapper
@Repository
public interface CommentDao {
	
	// 댓글 리스트
	public List<CommentDto> getAllComment(CommentDto dto);
	
	// 댓글 총 수
	int getCommentCount(CommentDto dto);
	
	// 댓글 등록
	int writeComment(CommentDto dto);

	// 댓글 수정
	int updateComment(CommentDto dto);
	
	// 댓글 삭제
	int deleteComment(int ctNum);
}
