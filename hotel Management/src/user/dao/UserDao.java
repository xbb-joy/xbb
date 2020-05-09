package user.dao;

import java.util.List;

import user.entity.User;

public interface UserDao {
	//��¼
	public User login(String username,String upwd);
	
	//�����û���Ϣ
	public void add(User u);

	//ɾ���û���Ϣ
	public void delete(int userid);

	//�޸��û���Ϣ
	public void update(User u);

	//��ѯ�����û�
	public List<User> selectAll();

	public User selectById(int userid);
	
	public User selectByName(String username);
}
