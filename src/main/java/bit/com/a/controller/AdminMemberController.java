package bit.com.a.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.AgeBuyRank;
import bit.com.a.dto.MemberAge;
import bit.com.a.dto.MemberDto;
import bit.com.a.dto.MonthlyMember;
import bit.com.a.service.AdminMemberService;
import bit.com.a.service.MemberService;

@RestController
public class AdminMemberController {

	@Autowired
	AdminMemberService service;
	
	@Autowired
	MemberService Mservice;
	
	@RequestMapping(value="/MonthlyMember", method = RequestMethod.POST )
	public List<MonthlyMember> MonthlyMember(){
		List<MonthlyMember> MonthlyMember = service.MonthlyMemberList();
		
	
		
		System.out.println("hashmap확인:" + MonthlyMember.toString());
		
		
		
		return MonthlyMember;
	}
	
	
	@RequestMapping(value="/getMember", method = RequestMethod.POST )
	public MemberDto getMember(MemberDto dto){
		MemberDto mem = Mservice.getMem(dto);
		System.out.println("관리자회원관리--멤버--회원정보확인--:" + mem.toString());

		return mem;
	}
	
	@RequestMapping(value="/MemDel", method = RequestMethod.POST )
	public boolean MemDel(MemberDto dto){
		boolean result = service.MemDel(dto);
		System.out.println("관리자회원관리--멤버--탈퇴--결과:" + result);

		return result;
	}
	
	@RequestMapping(value="/TotalAgeChart", method = RequestMethod.POST )
	public List<MemberAge> TotalAgeChart(){
		
		List<MemberAge> TotalAge = service.TotalAge();
		
		for (MemberAge memberAge : TotalAge) {
			System.out.println("연령별 수:"+ memberAge.toString());
		}
		
		return TotalAge;
	}
	
	@RequestMapping(value="/AgeBuyRank", method = RequestMethod.POST )
	public List<AgeBuyRank> AgeBuyRank(){
		List<AgeBuyRank> listA = service.AgeBuyRank();
		
		for (AgeBuyRank ageBuyRank : listA) {
			System.out.println("AgeBuyRank 데이터확인:" + ageBuyRank.toString() );
			System.out.println(" ");
		}
		return listA;
	}
}
