package room.entity;

public class Room {
	private int roomid;
	private String roomtype;
	private String roomstatus;
	private int price;
	private String path;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Room(int roomid) {
		super();
		this.roomid = roomid;
	}

	public Room(int roomid, String roomtype, String roomstatus, int price,
			String path) {
		super();
		this.roomid = roomid;
		this.roomtype = roomtype;
		this.roomstatus = roomstatus;
		this.price = price;
		this.path = path;
	}



	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomtype=" + roomtype
				+ ", roomstatus=" + roomstatus + ", price=" + price + ", path="
				+ path + "]";
	}
	
	
}
