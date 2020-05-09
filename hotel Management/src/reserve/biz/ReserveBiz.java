package reserve.biz;

import java.util.List;

import reserve.entity.Reserve;

public interface ReserveBiz {
	public void add(Reserve a);

	public void delete(int dingdanid);

	public void update(Reserve a);

	public List<Reserve> selectAll();

	public Reserve selectId(int dingdanid);

	public List<Reserve> selectstatus(String status);
	
	public int day(int dingdanid);
	
	public int price(int dingdanid);
	
	public Reserve selectByName(String username);
}
