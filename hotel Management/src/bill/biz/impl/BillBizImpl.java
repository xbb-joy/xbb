package bill.biz.impl;

import java.util.List;

import bill.biz.BillBiz;
import bill.dao.BillDao;
import bill.dao.impl.BillDaoImpl;
import bill.entity.Bill;

public class BillBizImpl implements BillBiz {

	private BillDao bill=new BillDaoImpl();
	
	public List<Bill> selectAll() {
		List<Bill> list = bill.selectAll();
		return list;
	}
	
	public Bill selectById(int billid) {
		Bill b = bill.selectById(billid);
		return b;
	}
	
	public void add(Bill b) {
		bill.add(b);
	}
	
	public void delete(int billid) {
		bill.delete(billid);
	}
	
	public void update(Bill b) {
		bill.update(b);
	}

}
