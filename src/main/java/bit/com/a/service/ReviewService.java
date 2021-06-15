package bit.com.a.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.ReviewDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ReviewDto;

@Service
@Transactional
public class ReviewService {

	@Autowired
	ReviewDao rDao;
	
	// 리뷰 리스트
	public List<ReviewDto> getAllReviewList(ReviewDto rDto) {
		return rDao.getAllReviewList(rDto);
	}
	
	// 리뷰 글  총 수
	public int getReviewCount(ReviewDto rDto) {
		return rDao.getReviewCount(rDto);
	}
	
	// 평균별점
	public Double detailStarAvg(ReviewDto rDto) {
		return rDao.detailStarAvg(rDto);
	}
	
	// 글쓰기
	public boolean writeReview(ReviewDto rDto) {
		int count = rDao.writeReview(rDto);
		
		return count>0?true:false;
	}
	
	// 상품정보
	public ProductDto getProductInfo(int prodNum) {
		return rDao.getProductInfo(prodNum);
	}
	
	// 리뷰포인트
	public void reviewPoint(MemberDto mem) {
		rDao.reviewPoint(mem);
	}
	
	// 포토포인트
	public void photoPoint(MemberDto mem) {
		rDao.photoPoint(mem);
	}
	
	// 평균평점
	public List<ReviewDto> avgReview(int prodNum) {
		return rDao.avgReview(prodNum);
	}
	
	// 리뷰삭제
	public boolean deleteReview(int rnum) {
		int count = rDao.deleteReview(rnum);
		
		return count>0?true:false;
	}
	
}



