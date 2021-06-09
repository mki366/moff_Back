package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MonthlyMember;
import bit.com.a.service.AdminMemberService;

@RestController
public class AdminMemberController {

	@Autowired
	AdminMemberService service;
	
	@RequestMapping(value="/MonthlyMember", method = RequestMethod.POST )
	public List<MonthlyMember> MonthlyMember(){
		List<MonthlyMember> MonthlyMember = service.MonthlyMember();
		for (MonthlyMember monthlyMember2 : MonthlyMember) {
			System.out.println("월별가입자 확인:" + monthlyMember2.toString());
		}
		
		return MonthlyMember;
	}
}
