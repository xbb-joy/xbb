package user.biz.impl;

import java.util.List;

import user.biz.UserBiz;
import user.dao.UserDao;
import user.dao.impl.UserDaoImpl;
import user.entity.User;

public class UserBizImpl implements UserBiz {
	
	private UserDao user = new UserDaoImpl();

	public User login(String username, String upwd) {
		User u = user.login(username, upwd);
		return u;
	}

	public void add(User u) {
		user.add(u);
		
	}

	public void delete(int userid) {
		user.delete(userid);
		
	}

	public void update(User u) {
		user.update(u);
		
	}

	public List<User> selectAll() {
		List<User>list=user.selectAll();
		return list;
	}

	public User selectById(int userid) {
		User u=user.selectById(userid);
		return u;
	}

	public User selectByName(String username) {
		User u = user.selectByName(username);
		return u;
	}

}
