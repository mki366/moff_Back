package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ReviewDto;

@Mapper
@Repository
public interface ReviewDao {

	// 리뷰 리스트
	public List<ReviewDto> getAllReviewList(ReviewDto rDto);
	
	// 글 총수
	int getReviewCount(ReviewDto rDto);
	
	// 리스트 평균별점
	Double detailStarAvg(ReviewDto rDto);
	
	// 글쓰기
	int writeReview(ReviewDto rDto);
	
	// 상품정보
	public ProductDto getProductInfo(int prodNum);
	
	// 리뷰포인트
	void reviewPoint(MemberDto mem);
	
	// 포토포인트
	void photoPoint(MemberDto mem);
	
	// 평균리뷰
	public List<ReviewDto> avgReview(int prodNum);
	
	// 리뷰 삭제
	int deleteReview(int rnum);
	
}
