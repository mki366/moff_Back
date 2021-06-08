package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.CsDto;
import bit.com.a.dto.CsParam;
import bit.com.a.service.CsService;

@RestController 
public class CsController {

	@Autowired
	CsService service;
	
	@RequestMapping(value = "/csList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CsDto> csList(CsParam csp){
		System.out.println("CsController csList() " + new Date());
		System.out.println(csp.toString());
		
		int cp = csp.getPage() ;
		int start = cp * 10 + 1;	
		int end = (cp + 1) * 10;	

		// System.out.println("페이지:"+ cp + "처음:" + start + "끝: " + end);
	
		
		csp.setStart(start);
		csp.setEnd(end);
		
		List<CsDto> list  = service.csList(csp);
	
	//	System.out.println("list:"+list);
		return list;
		
	}

	@RequestMapping(value = "/csCount", method = RequestMethod.GET)
	public int csCount(CsParam cpm) {
		System.out.println("검색데이터 확인:" + cpm.toString());
		
		int count = service.csCount(cpm);
		System.out.println("총글수: " + count);
		
		int pagenum  = count/10;
		if ((count %10)>0) {
			pagenum = pagenum +1;
		}
		System.out.println("페이지수 : " + pagenum);
		return pagenum;
	}
	
	@RequestMapping(value = "/csWrite", method = RequestMethod.POST)
	public String csWrite(CsDto dto) {
		System.out.println("CsController csWrite() " + new Date());
		System.out.println(dto);
		boolean b = service.csWrite(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	@RequestMapping(value = "/csdetail", method = {RequestMethod.GET, RequestMethod.POST})
	public CsDto csdetail(int csnum) {
		System.out.println("CsController csdetail() " + new Date());
		service.readCount(csnum);
		
		CsDto dto = service.getCs(csnum);
		System.out.println(dto.toString());
		
		return dto;
	}
	
	@RequestMapping(value = "/csdelete", method = {RequestMethod.GET, RequestMethod.POST})
    public void csdelete(int csnum) {
		System.out.println("CsController csdelete()" + new Date());
		service.csDelete(csnum);
	}
	
	@RequestMapping(value = "/csupdate", method =  RequestMethod.POST)
	public void csupdate(CsDto dto) {
		System.out.println("CsController csupdate()" + new Date());
		service.csUpdate(dto);
		System.out.println("(( 수정완료 )) TITLE :" + dto.getTitle() + " CONTENT: " + dto.getContent());
		
	}
	
	@RequestMapping(value = "/replyCsInsert", method =  RequestMethod.POST)
	public String replyCsInsert(CsDto dto) {
		System.out.println("CsController replyCsInsert()" + new Date());
		System.out.println(dto.toString());
		boolean b = service.replyCsInsert(dto);

		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	
	}

	
	
	
	
	
	
	
}
	
	
	
