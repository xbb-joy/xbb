package bill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.entity.Reserve;
import bill.biz.BillBiz;
import bill.biz.impl.BillBizImpl;
import bill.entity.Bill;

public class UpdateBillServ extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int billid = 0;
		String idStr = request.getParameter("billid");
		if(idStr!=null && idStr.length()>0){
			billid = Integer.parseInt(idStr);
		}
	
		
		int dingdanid = 0;
		String idStr1 = request.getParameter("dingdanid");
		if (idStr1 != null && idStr1.length() > 0) {
			dingdanid = Integer.parseInt(idStr1);
		}

		int day = 0;
		String idStr2 = request.getParameter("day");
		if (idStr2 != null && idStr2.length() > 0) {
			day = Integer.parseInt(idStr2);
		}

		int money = 0;
		String idStr3 = request.getParameter("money");
		if (idStr3 != null && idStr3.length() > 0) {
			money = Integer.parseInt(idStr3);
		}
		
		BillBiz bill = new BillBizImpl();
		Reserve res = new Reserve();
		res.setDingdanid(dingdanid);
		
		bill.update(new Bill(billid,res,day,money));
		
		request.getRequestDispatcher("selectBill.do").forward(request, response);
	}
}
