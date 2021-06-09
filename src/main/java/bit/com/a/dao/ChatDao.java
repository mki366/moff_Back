package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.WebSocket.ChatParam;
import bit.com.a.WebSocket.Room;

@Mapper
@Repository
public interface ChatDao {

	//채팅방생성
	public int CreateRoom(Room room);
	
	//업체 채팅방 리스트
	public List<Room> ExpertChatRoom(ChatParam param);
	
	//업체 채팅방 갯수
	public int ExpertChatRoomCOUNT(ChatParam param);
}
