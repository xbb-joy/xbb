package room.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.biz.RoomBiz;
import room.biz.impl.RoomBizImpl;
import room.entity.Room;

public class AddRoomServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		String roomtype = request.getParameter("roomtype");
		int price = Integer.parseInt(request.getParameter("price"));
		String roomstatus = request.getParameter("roomstatus");
		String path = request.getParameter("path");
		
		Room r = new Room(roomid,roomtype,roomstatus,price,path);
		RoomBiz room = new RoomBizImpl();
		room.add(r);
		
		request.getRequestDispatcher("selectRoom.do").forward(request, response);
	}

}
