package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController
public class MemberConroller {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberConroller idcheck()");
		
		boolean b = service.idCheck(id);
		if(b == true) {
			return "NO";
		}else {		
			return "YES";
		}
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberDto dto) {
		System.out.println("MemberController signup()");
		System.out.println("메머추가ㅏㅏㅏㅏㅏㅏㅏㅏ"+dto.toString());
		
		boolean b = service.addmember(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
	@RequestMapping(value = "/snsCheck", method = RequestMethod.POST)
	public String snsCheck(String email) {
		System.out.println("MemberConroller snsCheck()");

		boolean b = service.snsCheck(email);
		if(b == true) {
			return "NO";
		}else {		
			return "YES";
		}
	}
 

	@RequestMapping(value = "/snsSignup", method = RequestMethod.POST)
	public MemberDto snsSignup(MemberDto dto) {
		System.out.println("MemberController snsSignup()");
		service.addmember(dto);

		return service.login(new MemberDto( dto.getId(), dto.getPwd(), null, null, null, null, null, null));
	}
	
	
	@RequestMapping(value = "/googleLogin", method = RequestMethod.POST)
	public String googleLogin(MemberDto dto) {
		System.out.println("MemberController signup()");
		System.out.println("메머추가ㅏㅏㅏㅏㅏㅏㅏㅏ"+dto.toString());
		
		boolean b = service.addmember(dto);
		if(b) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(String id, String pwd) {
		System.err.println(id+ "d" + pwd);
		System.out.println("MemberController login()");		
		MemberDto dto = service.login(new MemberDto(id, pwd, null, null, null, null, null, null));
		return dto;
	}
	
	@RequestMapping(value = "/personalUpdate", method = RequestMethod.POST)
	public MemberDto personalUpdate(MemberDto dto) {
		System.out.println("MemberController personalUpdate()");		
		
		MemberDto mem = null;
		boolean b = service.personalUpdate(dto);
		if(b) {
			mem = service.getMem(dto);
		}
		return mem;
	}
	
	@RequestMapping(value = "/contactUpdate", method = RequestMethod.POST)
	public MemberDto contactUpdate(MemberDto dto) {
		System.out.println("MemberController contactUpdate()");		
		
		MemberDto mem = null;
		boolean b = service.contactUpdate(dto);
		if(b) {
			mem = service.getMem(dto);
		}
		return mem;
	}
	
	@RequestMapping(value = "/pwdUpdate", method = RequestMethod.POST)
	public MemberDto pwdUpdate(MemberDto dto) {
		System.out.println("MemberController pwdUpdate()");		
		
		MemberDto mem = null;
		boolean b = service.pwdUpdate(dto);
		if(b) {
			mem = service.getMem(dto);
		}
		return mem;
	}
	
	@RequestMapping(value = "/addressUpdate", method = RequestMethod.POST)
	public MemberDto addressUpdate(MemberDto dto) {
		System.out.println("MemberController addressUpdate()");		
		
		MemberDto mem = null;
		boolean b = service.addressUpdate(dto);
		if(b) {
			mem = service.getMem(dto);
		}
		return mem;
	}
	
	
}





