package bit.com.a.WebSocket;

public class Room {
	private int ExpertNum;
	private int RoomNum;
	private String id;
	private String mes;
	private String mesType;
	public Room(int expertNum, int roomNum, String id, String mes, String mesType) {
		super();
		ExpertNum = expertNum;
		RoomNum = roomNum;
		this.id = id;
		this.mes = mes;
		this.mesType = mesType;
	}
	public int getExpertNum() {
		return ExpertNum;
	}
	public void setExpertNum(int expertNum) {
		ExpertNum = expertNum;
	}
	public int getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getMesType() {
		return mesType;
	}
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	@Override
	public String toString() {
		return "Room [ExpertNum=" + ExpertNum + ", RoomNum=" + RoomNum + ", id=" + id + ", mes=" + mes + ", mesType="
				+ mesType + "]";
	}
	

}
