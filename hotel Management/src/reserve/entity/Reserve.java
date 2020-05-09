package reserve.entity;

import java.sql.Date;

import room.entity.Room;
import user.entity.User;

public class Reserve {
	private int dingdanid;
	private User u = new User();
	private Room r = new Room();
	private Date arrive;
	private Date leave;
	private String status;

	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reserve(int dingdanid, Date arrive, Date leave, String status) {
		super();
		this.dingdanid = dingdanid;
		this.arrive = arrive;
		this.leave = leave;
		this.status = status;
	}
	
	public Reserve(int dingdanid, Date arrive, Date leave) {
		super();
		this.dingdanid = dingdanid;
		this.arrive = arrive;
		this.leave = leave;
	}

	public Reserve(User u, Room r, Date arrive, Date leave, String status) {
		super();
		this.u = u;
		this.r = r;
		this.arrive = arrive;
		this.leave = leave;
		this.status = status;
	}

	public Reserve(int dingdanid, User u, Room r, Date arrive, Date leave,
			String status) {
		super();
		this.dingdanid = dingdanid;
		this.u = u;
		this.r = r;
		this.arrive = arrive;
		this.leave = leave;
		this.status = status;
	}

	public int getDingdanid() {
		return dingdanid;
	}

	public void setDingdanid(int dingdanid) {
		this.dingdanid = dingdanid;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}

	public Date getArrive() {
		return arrive;
	}

	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}

	public Date getLeave() {
		return leave;
	}

	public void setLeave(Date leave) {
		this.leave = leave;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reserve [dingdanid=" + dingdanid + ", u=" + u + ", r=" + r
				+ ", arrive=" + arrive + ", leave=" + leave + ", status="
				+ status + "]";
	}

}