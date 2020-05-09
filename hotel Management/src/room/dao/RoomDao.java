package room.dao;

import java.util.List;

import room.entity.Room;

public interface RoomDao {
	public List<Room> selectAll(int index,int size);
	
	public Room selectByRoomid(int roomid);
	
	public void update(Room r);
	
	public void delete(int roomid);
	
	public void add(Room r);
	
	public int count();
	
	public List<Room> selectByStatus(String roomstatus);
	
	public Room selectByPath(String path);
	
	public List<Room> selectByType(String roomtype, String roomstatus);
}
