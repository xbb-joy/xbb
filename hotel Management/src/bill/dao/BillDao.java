package bill.dao;

import java.util.List;

import bill.entity.Bill;

public interface BillDao {
	public List<Bill> selectAll();
	
	public Bill selectById(int billid);
	
	public void add(Bill b);
	
	public void delete(int billid);
	
	public void update(Bill b);
	
}
