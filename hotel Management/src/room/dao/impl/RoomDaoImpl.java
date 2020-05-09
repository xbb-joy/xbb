package room.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import room.dao.RoomDao;
import room.entity.Room;
import util.BaseDao;

public class RoomDaoImpl extends BaseDao implements RoomDao {

	public List<Room> selectAll(int index,int size) {
		List<Room> list = new ArrayList<Room>();
		String sql = "select t.* from (select r.*,rownum r1 from room r) t where r1>? and r1<=?";
		super.query(sql,(index-1)*size,index*size);
		try {
			while(rs.next()){
				Room r = new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Room selectByRoomid(int roomid) {
		Room r = null;
		String sql = "select * from room where roomid=?";
		super.query(sql, roomid);
		try {
			if(rs.next()){
				r = new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public void update(Room r) {
		String sql = "update room set roomtype=?,roomstatus=?,price=?,path=? where roomid=?";
		super.update(sql, r.getRoomtype(),r.getRoomstatus(),r.getPrice(),r.getPath(),r.getRoomid());
	}

	public void delete(int roomid) {
		String sql = "delete from room where roomid=?";
		super.update(sql, roomid);
	}

	public void add(Room r) {
		String sql = "insert into room values(?,?,?,?,?)";
		super.update(sql, r.getRoomid(),r.getRoomtype(),r.getRoomstatus(),r.getPrice(),r.getPath());		
	}

	public int count() {
		int count = 0;
		String sql = "select count(*) from room";
		super.query(sql);
		try {
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public List<Room> selectByStatus(String roomstatus) {
		List<Room> list=new ArrayList<Room>();
		String sql="select * from room where roomstatus=?";
		super.query(sql,roomstatus);
		try {
			while(rs.next()){
				Room r=new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Room selectByPath(String path) {
		Room r=null;
		String sql="select * from room where path=?";
		super.query(sql, path);
		try {
			if(rs.next()){
				r=new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public List<Room> selectByType(String roomtype, String roomstatus) {
		List<Room> list=new ArrayList<Room>();
		String sql="select * from room where roomtype=? and roomstatus=?";
		super.query(sql,roomtype,roomstatus);
		try {
			while(rs.next()){
				Room r=new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
