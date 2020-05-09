package reserve.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import reserve.dao.ReserveDao;
import reserve.entity.Reserve;
import room.entity.Room;
import user.entity.User;
import util.BaseDao;

public class ReserveDaoImpl extends BaseDao implements ReserveDao {

	public void add(Reserve a) {
		String sql = "insert into reserve values(dingdanid.nextval,?,?,?,?,?)";
		super.update(sql, a.getU().getUserid(), a.getR().getRoomid(), a.getArrive(), a.getLeave(), a.getStatus());

	}

	public void delete(int dingdanid) {
		String sql = "delete from reserve where dingdanid=?";
		super.update(sql, dingdanid);

	}

	public void update(Reserve a) {
		String sql = "update reserve set userid=?,roomid=?,arrive=?,leave=?,status=? where dingdanid=?";
		super.update(sql, a.getU().getUserid(), a.getR().getRoomid(),a.getArrive(),a.getLeave(),a.getStatus(),a.getDingdanid());

	}

	public List<Reserve> selectAll() {
		List<Reserve>list=new ArrayList<Reserve>();
		String sql="select a.*,u.username from reserve a,user2 u,room r where a.userid=u.userid and a.roomid=r.roomid";
		super.query(sql);
		try {
			while(rs.next()){
				User u = new User(rs.getInt(2),rs.getString(7));
				Room r = new Room(rs.getInt(3));
				Reserve a = new Reserve(rs.getInt(1),u,r,rs.getDate(4),rs.getDate(5),rs.getString(6));
			    list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Reserve selectId(int dingdanid) {
		Reserve a = null;
		String sql = "select a.*,u.username from reserve a,user2 u,room r where a.userid=u.userid and a.roomid=r.roomid and dingdanid=?";
		super.query(sql, dingdanid);

		try {
			if (rs.next()) {
				User u = new User(rs.getInt(2),rs.getString(7));
				Room r = new Room(rs.getInt(3));
				a = new Reserve(rs.getInt(1),u,r, rs.getDate(4),rs.getDate(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public List<Reserve> selectstatus(String status) {
		List<Reserve> list = new ArrayList<Reserve>();
		String sql = "select a.*,u.username from reserve a,user2 u,room r where a.userid=u.userid and a.roomid=r.roomid and status=?";
		super.query(sql,status);
		try {
			while (rs.next()) {
				User u = new User(rs.getInt(2),rs.getString(7));
				Room r = new Room(rs.getInt(3));
				Reserve a = new Reserve(rs.getInt(1),u,r, rs.getDate(4),rs.getDate(5),rs.getString(6));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int day(int dingdanid) {
		int count = 0;
		String sql="select leave-arrive from reserve a,room r,user2 u where a.userid=u.userid and a.roomid=r.roomid and dingdanid=?";
		super.query(sql, dingdanid);
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
	
	public int price(int dingdanid) {
		int count = 0;
		String sql="select price from reserve a,room r,user2 u where a.userid=u.userid and a.roomid=r.roomid and dingdanid=?";
		super.query(sql, dingdanid);
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

	public Reserve selectByName(String username) {
		Reserve a = null;
		String sql = "SELECT a.*,username FROM reserve a,user2 u,room r WHERE r.roomid=a.roomid AND u.userid=a.userid AND username=?";
		super.query(sql, username);
		try {
			if (rs.next()) {
				User u = new User(rs.getInt(2),rs.getString(7));
				Room r = new Room(rs.getInt(3));
				a = new Reserve(rs.getInt(1),u,r, rs.getDate(4),rs.getDate(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
