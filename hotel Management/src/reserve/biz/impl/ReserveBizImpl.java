package reserve.biz.impl;

import java.util.List;

import reserve.biz.ReserveBiz;
import reserve.dao.ReserveDao;
import reserve.dao.impl.ReserveDaoImpl;
import reserve.entity.Reserve;

public class ReserveBizImpl implements ReserveBiz {
	private ReserveDao res = new ReserveDaoImpl();

	public void add(Reserve a) {
		res.add(a);
	}

	public void delete(int dingdanid) {
		res.delete(dingdanid);

	}

	public void update(Reserve a) {
		res.update(a);
	}

	public List<Reserve> selectAll() {
		List<Reserve> list = res.selectAll();
		return list;
	}

	public Reserve selectId(int dingdanid) {
		Reserve a = res.selectId(dingdanid);
		return a;
	}

	public List<Reserve> selectstatus(String status) {
		List<Reserve> list = res.selectstatus(status);
		return list;
	}

	public int day(int dingdanid) {
		int count = res.day(dingdanid);
		return count;
	}

	public int price(int dingdanid) {
		int count = res.price(dingdanid);
		return count;
	}

	public Reserve selectByName(String username) {
		Reserve a = res.selectByName(username);
		return a;
	}
}
