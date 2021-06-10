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
import bit.com.a.util.FileUtil;

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
		System.out.println("------rDto" + rDto);
		System.out.println("-------파일로드" + fileload.getOriginalFilename());
		String uploadPath = req.getServletContext().getRealPath("/review");
		
		String image = "";
		
		boolean check = false;
		
			if(fileload.isEmpty()) {
				rDto.setImage("");
				
				check= service.writeReview(rDto);
				service.reviewPoint(mem);
				
				
			}else {
			
				
				image = fileload.getOriginalFilename();
				String newFilename = FileUtil.newFilenames(image);
				
				String filepath = uploadPath + File.separator + newFilename;
				
				System.out.println("------파일업로드 경로--------");
				System.out.println("Review image: " + filepath);
				
				String myPath = "http://localhost:3000//review//";
				
				rDto.setImage(myPath+newFilename);
				
				
					
					try {
						BufferedOutputStream bStream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
						
						bStream.write(fileload.getBytes());
						bStream.close();
						
						check = service.writeReview(rDto);
						service.photoPoint(mem);
						return "YES";
						
					} catch (Exception e) {
						e.printStackTrace();
						
					}
					
				
				
				}if(check) {
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
	
	
	// 평균평점
	@RequestMapping(value = "/avgReview", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ReviewDto> avgReview(int prodNum) {
		System.out.println("avgReview() Controller");
		
		List<ReviewDto> list = service.avgReview(prodNum);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}










