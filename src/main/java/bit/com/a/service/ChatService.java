package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.WebSocket.ChatParam;
import bit.com.a.WebSocket.Room;
import bit.com.a.dao.ChatDao;

@Service
@Transactional
public class ChatService {
	
	@Autowired
	ChatDao dao;
	
		//채팅방생성
		public boolean CreateRoom(Room room) {
			return dao.CreateRoom(room)>0?true:false; 
		}
		
		//업체 채팅방 리스트
		public List<Room> ExpertChatRoom(ChatParam param){
			return dao.ExpertChatRoom(param);
		}
		

		//업체 채팅방 갯수
		public int ExpertChatRoomCOUNT(ChatParam param) {
			return dao.ExpertChatRoomCOUNT(param);
		}
}
