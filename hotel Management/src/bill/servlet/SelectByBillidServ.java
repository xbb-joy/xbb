package bill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.biz.BillBiz;
import bill.biz.impl.BillBizImpl;
import bill.entity.Bill;

public class SelectByBillidServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
		
		BillBiz bill = new BillBizImpl();
		Bill b = bill.selectById(billid);
		
		request.setAttribute("b", b);
		request.getRequestDispatcher("updateBill.jsp").forward(request, response);
	}

}
