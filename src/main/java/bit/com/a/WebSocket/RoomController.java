package bit.com.a.WebSocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bit.com.a.dto.BuybackDto;
import bit.com.a.dto.ExpertPagingParam;
import bit.com.a.service.ChatService;

@RestController
public class RoomController {
	
	@Autowired
	ServletContext serveltContext;
	
	@Autowired
	ChatService service;
	
	
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	static int roomNumberC = 0;
	
	@RequestMapping("/chatting")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		
		System.out.println("chat");
		return mv;
	}
	
	/**
	 * 방 페이지
	 * @return
	 */
	@RequestMapping("/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("room");
		System.out.println("room");
		return mv;
	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	
	
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@RequestMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	
	
	
	//채팅시작시 들어가는 방
	@RequestMapping(value = "/gochatting", method = RequestMethod.POST)
	public int gochatting(int eNUM) {
		
		++roomNumberC;
		//방생성
		
		System.out.println("업체번호:" + eNUM + " 룸번호:" + roomNumberC);
		
		boolean room = service.CreateRoom(new Room(eNUM, roomNumberC, null, null, null));
		if(room) {
			System.out.println("방이생성되었습니다");
			}else {
				System.out.println("방 생성 실패하였습니다");
					
			}
		
		return roomNumberC;
		//방을 저장
	}
	
	@RequestMapping(value = "/ExpertChatList", method = RequestMethod.POST)
	public List<Room> ExpertChatList(ChatParam param){
		
		
		System.out.println("ExpertChatList 데이터 들어오는 값 확인:"+ param.toString());
		
		int pagen = param.getPage();
		int start = pagen * 5 + 1;
		int end = (pagen + 1)*5;
		System.out.println("start:"+ start);
		System.out.println("end:"+ end);
		
		//시작, 종료 설정
		param.setStart(start);
		param.setEnd(end);
		
		
		System.out.println("페이지 넣고 최종 마이바티스 입력:"+ param.toString());
		
		
		List<Room> ExpertRoomList = service.ExpertChatRoom(param);
		
		for (Room room : ExpertRoomList) {
			System.out.println("업체 채팅방 리스트:" + room.toString());
		}
		
		
		return ExpertRoomList;
		
	}
	
	
	@RequestMapping(value = "/ExpertChatListCOUNT", method = RequestMethod.POST)
	public int allExperListCOUNT(ChatParam param) {
		int count = service.ExpertChatRoomCOUNT(param);
		
		System.out.println("ExpertChatListCOUNT 데이터 들어온값 확인:" + param.toString());
		
		  int pagenum = count/5;
		   if((count %5)>0) {
			   pagenum = pagenum + 1;
			   
		   }
		   
		   System.out.println("ExpertChatListCOUNT 페이지 갯수 확인:" +  pagenum);
		   return pagenum;
	}
}
