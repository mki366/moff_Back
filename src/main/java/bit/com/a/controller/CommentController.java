package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.CommentDto;
import bit.com.a.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService service;
	
	// 댓글 리스트
	@RequestMapping(value = "/getAllComment", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CommentDto> getAllComment(CommentDto dto) {
		System.out.println("getAllComment() Controller");
		
		List<CommentDto> list = service.getAllComment(dto);
		
		return list;
	}
	
	// 댓글 총 수
	@RequestMapping(value = "/getCommentCount", method = {RequestMethod.GET, RequestMethod.POST})
	private int getCommentCount(CommentDto dto) {
		System.out.println("getCommentCount() Controller");
		int count = service.getCommentCount(dto);
		
		return count;
	}
	
	
	// 댓글 등록
	@RequestMapping(value = "/writeComment", method = RequestMethod.POST)
	public String writeComment(CommentDto dto) {
		System.out.println("writeComment() Controller");
		
		if(service.writeComment(dto) == true) {
			return "YES";
		}else {
			return "NO";
		} 
		
	}
	
	
	// 댓글 수정
	@RequestMapping(value = "/updateComment", method = RequestMethod.POST)
	public String updateComment(CommentDto dto) {
		System.out.println("updateComment() Controller");
		
		if(service.updateComment(dto)==true) {
			return "YES";
		}else {
			return "NO";
					
		}
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/deleteComment", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteComment(int ctNum) {
		System.out.println("deleteComment() Controller");
		
		if(service.deleteComment(ctNum)==true) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
}













