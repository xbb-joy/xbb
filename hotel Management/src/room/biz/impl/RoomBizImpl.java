package room.biz.impl;

import java.util.List;

import room.biz.RoomBiz;
import room.dao.RoomDao;
import room.dao.impl.RoomDaoImpl;
import room.entity.Room;

public class RoomBizImpl implements RoomBiz {
	private RoomDao room = new RoomDaoImpl();
	
	public List<Room> selectAll(int index,int size) {
		List<Room> list = room.selectAll(index, size);
		return list;
	}

	public Room selectByRoomid(int roomid) {
		Room r = room.selectByRoomid(roomid);
		return r;
	}

	public void update(Room r) {
		room.update(r);
	}

	public void delete(int roomid) {
		room.delete(roomid);
	}

	public void add(Room r) {
		room.add(r);
	}

	public int count() {
		int count = room.count();
		return count;
	}

	public List<Room> selectByStatus(String roomstatus) {
		List<Room> list = room.selectByStatus(roomstatus);
		return list;
	}

	public Room selectByPath(String path) {
		Room r = room.selectByPath(path);
		return r;
	}

	public List<Room> selectByType(String roomtype, String roomstatus) {
		List<Room> list = room.selectByType(roomtype, roomstatus);
		return list;
	}



}
