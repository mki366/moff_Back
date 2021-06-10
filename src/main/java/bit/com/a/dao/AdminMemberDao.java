package bit.com.a.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MonthlyMember;

@Mapper
@Repository
public interface AdminMemberDao {
	public List<MonthlyMember> MonthlyMemberList();
}
