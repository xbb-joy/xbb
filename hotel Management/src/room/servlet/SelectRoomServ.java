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

public class SelectRoomServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int index = 1;
		String indexStr = request.getParameter("index");
		if(indexStr!=null && indexStr.length()>0){
			index = Integer.parseInt(indexStr);
		}
		int size = 3;
		
		RoomBiz room = new RoomBizImpl();
		List<Room> list = room.selectAll(index,size);
		int count = room.count();
		int total = count%size==0 ? count/size : count/size+1;
		
		request.setAttribute("list", list);
		request.setAttribute("index", index);
		request.setAttribute("total", total);
		request.getRequestDispatcher("adminRoom.jsp").forward(request, response);
		
	}

}
