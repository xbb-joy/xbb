package bill.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.biz.BillBiz;
import bill.biz.impl.BillBizImpl;
import bill.entity.Bill;

public class SelectBillServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		BillBiz bill = new BillBizImpl();
		List<Bill> list = bill.selectAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("adminBill.jsp").forward(request, response);
	}

}
