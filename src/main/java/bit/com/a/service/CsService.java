package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.CsDao;
import bit.com.a.dto.CsDto;
import bit.com.a.dto.CsParam;

@Service
@Transactional
public class CsService {

	@Autowired
	CsDao dao;
	
	
	public List<CsDto> csList(CsParam csp){
		return dao.csList(csp);
	}
	
	public int csCount(CsParam cpm) {
		return dao.csCount(cpm);
	}
	
	public boolean csWrite(CsDto dto){
		return dao.csWrite(dto);
	}
	
	public CsDto getCs(int csnum) {
		return dao.getCs(csnum);
	}
	
	public void readCount(int csnum) {
		dao.readCount(csnum);
	}
	
	public void csDelete(int csnum) {
		dao.csDelete(csnum);
	}
	
	public void csUpdate(CsDto dto) {
		dao.csUpdate(dto);
	}
	
	public boolean replyCsInsert(CsDto dto) {
		
		System.out.println("dd"+ dto.toString());
		boolean v = dao.replyCsInsert(dto);
		System.out.println("service :"+dto.toString());
		return v;
		
	}
	
}
