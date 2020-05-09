package bill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import reserve.biz.ReserveBiz;
import reserve.biz.impl.ReserveBizImpl;
import bill.entity.Bill;

public class CountServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		int dingdanid = Integer.parseInt(request.getParameter("dingdanid"));

		ReserveBiz reserve = new ReserveBizImpl();
		int day = reserve.day(dingdanid);
		int price = reserve.price(dingdanid);
		int money = (day * price);

		Bill b = new Bill(day, money);
		
		JSONObject obj = JSONObject.fromObject(b);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}
}
