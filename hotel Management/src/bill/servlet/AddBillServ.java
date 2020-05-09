package bill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.biz.ReserveBiz;
import reserve.biz.impl.ReserveBizImpl;
import reserve.entity.Reserve;
import room.biz.RoomBiz;
import room.biz.impl.RoomBizImpl;
import room.entity.Room;
import user.entity.User;

import bill.biz.BillBiz;
import bill.biz.impl.BillBizImpl;
import bill.entity.Bill;

public class AddBillServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

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
		bill.add(new Bill(res,day,money));

		ReserveBiz reserve = new ReserveBizImpl();
		Reserve res1 = reserve.selectId(dingdanid);
		RoomBiz room = new RoomBizImpl();
		Room r1 = room.selectByRoomid(res1.getR().getRoomid());
		String str = "¿Õ·¿";
		room.update(new Room(r1.getRoomid(), r1.getRoomtype(), str, r1.getPrice(), r1.getPath()));
		String str1 = "ÒÑÍË·¿";
		
		User u = new User();
		u.setUserid(res1.getU().getUserid());
		
		Room r = new Room();
		r.setRoomid(res1.getR().getRoomid());
		reserve.update(new Reserve(res1.getDingdanid(), u, r, res1.getArrive(), res1.getLeave(),str1));
		request.getRequestDispatcher("selectBill.do").forward(request,response);
	}

}
