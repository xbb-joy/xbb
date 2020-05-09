package user.dao;

import java.util.List;

import user.entity.User;

public interface UserDao {
	//登录
	public User login(String username,String upwd);
	
	//增加用户信息
	public void add(User u);

	//删除用户信息
	public void delete(int userid);

	//修改用户信息
	public void update(User u);

	//查询所有用户
	public List<User> selectAll();

	public User selectById(int userid);
	
	public User selectByName(String username);
}
