package bill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.biz.ReserveBiz;
import reserve.biz.impl.ReserveBizImpl;
import reserve.entity.Reserve;

public class SelectByDingdanidServ1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int dingdanid = 0;
		String idStr=request.getParameter("dingdanid");
		if(idStr!=null && idStr.length()>0){
			dingdanid = Integer.parseInt(idStr);
		}
		
		ReserveBiz reserve = new ReserveBizImpl();
		Reserve res = reserve.selectId(dingdanid);
		
		request.setAttribute("res" , res);
	    request.setAttribute("dingdanid", dingdanid);
	    request.getRequestDispatcher("addBill.jsp").forward(request, response);
		
	}

}
