package room.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.biz.RoomBiz;
import room.biz.impl.RoomBizImpl;
import room.entity.Room;

public class SelectByTypeServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String roomtype=request.getParameter("roomtype");
		String roomstatus="¿Õ·¿";
		
		
		RoomBiz room=new RoomBizImpl();
		List<Room>list=room.selectByType(roomtype, roomstatus);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("userIndex.jsp").forward(request, response);
	}

}
