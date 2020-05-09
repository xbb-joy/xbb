package bill.biz;

import java.util.List;

import bill.entity.Bill;

public interface BillBiz {
public List<Bill> selectAll();
	
	public Bill selectById(int billid);
	
	public void add(Bill b);
	
	public void delete(int billid);
	
	public void update(Bill b);
}
