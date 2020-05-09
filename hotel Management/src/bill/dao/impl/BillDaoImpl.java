package bill.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.entity.Reserve;

import util.BaseDao;
import bill.dao.BillDao;
import bill.entity.Bill;

public class BillDaoImpl extends BaseDao implements BillDao {

	public List<Bill> selectAll() {
		List<Bill> list = new ArrayList<Bill>();
		String sql = "select b.*,res.arrive,res.leave from bill b,reserve res where b.dingdanid=res.dingdanid";
		super.query(sql);
		try {
			while(rs.next()){
				Reserve res = new Reserve(rs.getInt(2),rs.getDate(5),rs.getDate(6));
				Bill b = new Bill(rs.getInt(1),res,rs.getInt(3),rs.getInt(4));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Bill selectById(int billid) {
		Bill b = null;
		String sql = "select b.*,res.arrive,res.leave from bill b,reserve res where b.dingdanid=res.dingdanid and billid=?";
		super.query(sql, billid);
		try {
			if(rs.next()){
				Reserve res = new Reserve(rs.getInt(2),rs.getDate(5),rs.getDate(6));
				b = new Bill(rs.getInt(1),res,rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public void add(Bill b) {
		String sql = "insert into bill values(billid.nextval,?,?,?)";
		super.update(sql, b.getRes().getDingdanid(),b.getDay(),b.getMoney());
	}

	public void delete(int billid) {
		String sql = "delete from bill where billid=?";
		super.update(sql, billid);
	}

	public void update(Bill b) {
		String sql = "update bill set dingdanid=?,day=?,money=? where billid=?";
		super.update(sql, b.getRes().getDingdanid(),b.getDay(),b.getMoney(),b.getBillid());
	}

}
