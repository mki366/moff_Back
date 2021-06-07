package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.MemberDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ReviewDto;
import bit.com.a.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ServletContext servletContext;

	@Autowired
	ReviewService service;
	
	// 리뷰 리스트
	@RequestMapping(value = "/getAllReviewList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ReviewDto> getAllReviewList(ReviewDto rDto){
		System.out.println("getAllReviewList Controller: " + new Date());
		
		int sn = rDto.getPage();
		int start = sn * 5 + 1;
		int end = (sn + 1) * 5;
		
		rDto.setStart(start);
		rDto.setEnd(end);
		System.out.println("prodNum:" + rDto.getProdNum());
		
		List<ReviewDto> list = service.getAllReviewList(rDto);
		
		
		return list;
	}
	
	//리뷰 글 총수
		@RequestMapping(value = "/getReviewCount", method = {RequestMethod.GET, RequestMethod.POST})
		public int getReviewCount(ReviewDto rDto) {
			int count = service.getReviewCount(rDto);
			
			System.out.println("getReviewCount count: " + count);
			
			return count;
		}
		
	//리뷰 글 총수 + 페이징
	@RequestMapping(value = "/ReviewPaging", method = {RequestMethod.GET, RequestMethod.POST})
	public int ReviewPaging(ReviewDto rDto) {
		int count = service.getReviewCount(rDto);
		System.out.println("리뷰 count: " + count);
		
		int pagenum = count/5;
		if((count%5)>0) {
			pagenum = pagenum + 1;
		}
		
		System.out.println("getReviewCount 페이지수 확인: " + pagenum);
		System.out.println("리뷰페이지 prodNum: " + rDto.getProdNum());
		
		return pagenum;
	}
	
	// 평균별점
	@RequestMapping(value = "/detailStarAvg", method = {RequestMethod.GET, RequestMethod.POST})
	public Double detailStarAvg(ReviewDto rDto){
		System.out.println("detailColorDto Controller: " + new Date());
		
		Double avg = service.detailStarAvg(rDto);
		
		return avg;
	}
	
	// 글쓰기
	@RequestMapping(value = "/writeReview", method = RequestMethod.POST)
	public String writeReview(	@ModelAttribute ReviewDto rDto,
								MemberDto mem,
								@RequestParam("fileload")
								MultipartFile fileload,
								HttpServletRequest req) throws IOException {
		
		System.out.println("writeReview() Controller");
		
		String uploadPath = req.getServletContext().getRealPath("/review");
		
		String image = fileload.getOriginalFilename();
		String filepath = uploadPath + File.separator + image;
		
		System.out.println("review Img upload: " + filepath);
		
		int prodNum = rDto.getProdNum();
		String id = rDto.getId();
		int star = rDto.getStar();
		String content = rDto.getContent();
		
//		ReviewDto qqq = new ReviewDto(prodNum, id, star, content, image);
//		service.writeReview(qqq);
//		System.out.println("스타확인!!!!!!!!!!!!! " + qqq.getStar());
		
		boolean a = service.writeReview(new ReviewDto(prodNum, id, star, content, image));
		System.out.println("star: " + star);
		System.out.println("img: " + image);
		
		// 이미지 등록 시 포인트 600/ 미등록 300
		if(image != null && !image.equals("")) {
			service.photoPoint(mem);
		}else {
			service.reviewPoint(mem);
		}
		
		if(a == true) {
				
				try {
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					
					stream.write(fileload.getBytes());
					stream.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				return "YES";
			
		}else {
			
			return "NO";
			
		}
		
		
		
		
	}
	
	// 상품정보
	@RequestMapping(value = "/getProductInfo", method = {RequestMethod.GET, RequestMethod.POST})
	public ProductDto getProductInfo(int prodNum) {
		System.out.println("getProductInfo() Controller");
		
		ProductDto product = service.getProductInfo(prodNum);
		
		return product;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}










