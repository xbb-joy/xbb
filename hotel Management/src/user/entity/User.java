package user.entity;

public class User {
	private int userid;
	private String username;
	private String upwd;
	private String identity;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username) {
		super();
		this.username = username;
	}
	
	public User(int userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}

	public User(int userid) {
		super();
		this.userid = userid;
	}

	public User(int userid, String username, String upwd, String identity) {
		super();
		this.userid = userid;
		this.username = username;
		this.upwd = upwd;
		this.identity = identity;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}
