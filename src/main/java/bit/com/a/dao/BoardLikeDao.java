package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BoardLikeDto;

@Mapper
@Repository
public interface BoardLikeDao {
	
	// 좋아요 insert
	int addLikeList(BoardLikeDto dto);
	
	// 좋아요 총 수
	int likeCount(BoardLikeDto dto);
	
	// 업데이트
	int updateLike(BoardLikeDto dto);
	
	// 좋아요 삭제
	int delLike(BoardLikeDto dto);
	
	// 디테일 좋아요 insert
	int addLikeDetail(BoardLikeDto dto);
	
	
	
}










