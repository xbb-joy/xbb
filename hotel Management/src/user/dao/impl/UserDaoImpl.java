package user.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dao.UserDao;
import user.entity.User;
import util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	public User login(String username, String upwd) {
		User u = null;
		String sql = "select * from user2 where username=? and upwd=?";
		super.query(sql, username,upwd);
		try {
			if(rs.next()){
				u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public void add(User u) {
		String sql = "insert into user2 values(?,?,?,?)";
		super.update(sql, u.getUserid(), u.getUsername(), u.getUpwd(),u.getIdentity());
	}

	public void delete(int userid) {
		String sql = "delete from user2 where userid=?";
		super.update(sql, userid);
	}

	public void update(User u) {
		String sql = "update user2 set username=?,upwd=?,identity=? where userid=?";
		super.update(sql, u.getUsername(), u.getUpwd(), u.getIdentity(),u.getUserid());
	}

	public List<User> selectAll() {
		List<User>list=new ArrayList<User>();
		String sql="select * from user2";
		super.query(sql);
		try {
			while(rs.next()){
				User u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public User selectById(int userid) {
		User u=null;
		String sql="select * from user2 where userid=?";
		super.query(sql, userid);
		try {
			if(rs.next()){
			u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public User selectByName(String username) {
		User u=null;
		String sql="select * from user2 where username=?";
		super.query(sql, username);
		try {
			if(rs.next()){
			u=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
