package bill.entity;

import reserve.entity.Reserve;
import user.entity.User;

public class Bill {
	private int billid;
	private Reserve res;
	private int day;
	private int money;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int day, int money) {
		super();
		this.day = day;
		this.money = money;
	}

	public Bill(Reserve res, int day, int money) {
		super();
		this.res = res;
		this.day = day;
		this.money = money;
	}

	public Bill(int billid, Reserve res, int day, int money) {
		super();
		this.billid = billid;
		this.res = res;
		this.day = day;
		this.money = money;
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public Reserve getRes() {
		return res;
	}

	public void setRes(Reserve res) {
		this.res = res;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
}
