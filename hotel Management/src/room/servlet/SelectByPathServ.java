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

public class SelectByPathServ extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String path=request.getParameter("path");
		
		RoomBiz room=new RoomBizImpl();
		Room r=room.selectByPath(path);

		request.setAttribute("r", r);
		
		request.getRequestDispatcher("userReserve.jsp").forward(request, response);
		
	}
}
