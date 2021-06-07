package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BoardLikeDto;
import bit.com.a.service.BoardLikeService;

@RestController
public class BoardLikeController {

	@Autowired
	BoardLikeService service;
	
	
	@RequestMapping(value = "/addLikeList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addLikeList(BoardLikeDto dto) {
		System.out.println("addLike() Controller");
		
		int count = service.likeCount(dto);
		
		if(count < 1) {
			service.addLikeList(dto);
			service.updateLike(dto);
			
			return "YES";
			
		}else {
			service.delLike(dto);
			service.updateLike(dto);

			return "NO";
		}
		
	}
	
	
	@RequestMapping(value = "/addLikeDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public String addLikeDetail(BoardLikeDto dto) {
		System.out.println("addLike() Controller");
		
		int count = service.likeCount(dto);
		
		if(count < 1) {
			service.addLikeDetail(dto);
			service.updateLike(dto);
			
			return "YES";
			
		}else {
			service.delLike(dto);
			service.updateLike(dto);

			return "NO";
		}
		
	}
	
	
	
	
	
	
	
	
}
