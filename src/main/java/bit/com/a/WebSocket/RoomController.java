package bit.com.a.WebSocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RoomController {
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
	@RequestMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			System.out.println(roomNumber);
			
			room.setRoomName(roomName);
			roomList.add(room);
		}
		
		
		return roomList;
		
	}
	
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
	
	@RequestMapping("/moveChating")
	public ModelAndView chating(int roomNumber, String roomName) {
		ModelAndView mv = new ModelAndView();
		
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", roomName);
			mv.addObject("roomNumber", roomNumber);
			mv.setViewName("chat");
		}else {
			mv.setViewName("room");
		}
		System.out.println(mv);
		return mv;
	}
	
	
	//채팅시작시 들어가는 방
	@RequestMapping(value = "/gochatting", method = RequestMethod.POST)
	public int gochatting() {
		return ++roomNumberC;
	}
}
