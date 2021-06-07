package bit.com.achat;

public class ChatMessage {
	private MessageType type;
	private String content;
	private String sender;
	private int roomNum;
	private String wDate;
	private int sendType;
	
	public ChatMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ChatMessage(MessageType type, String content, String sender) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
	}
	

	public ChatMessage(MessageType type, String content, String sender, int roomNum, String wDate, int sendType) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
		this.roomNum = roomNum;
		this.wDate = wDate;
		this.sendType = sendType;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	
	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public int getSendType() {
		return sendType;
	}

	public void setSendType(int sendType) {
		this.sendType = sendType;
	}

	@Override
	public String toString() {
		return "ChatMessage [type=" + type + ", content=" + content + ", sender=" + sender + ", roomNum=" + roomNum
				+ ", wDate=" + wDate + ", sendType=" + sendType + "]";
	}

	
	
	
	
}
