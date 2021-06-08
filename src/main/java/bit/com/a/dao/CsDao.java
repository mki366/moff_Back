package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.CsDto;
import bit.com.a.dto.CsParam;


@Mapper
@Repository
public interface CsDao {

	public List<CsDto> csList(CsParam csp);
	int csCount(CsParam cpm); 		//  글 총수 
	
	boolean csWrite(CsDto dto);		// 글쓰기 	
			
	CsDto getCs(int csnum);			// 디테일 
	void readCount(int csnum);		// 조회수 
	
	void csDelete(int csnum);			// 삭제 
	void csUpdate(CsDto dto);			// 수정  
	
	boolean replyCsInsert(CsDto dto);	// 	답글 
	
	
	
}





