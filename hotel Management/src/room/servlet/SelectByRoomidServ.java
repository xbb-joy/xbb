package room.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import room.biz.RoomBiz;
import room.biz.impl.RoomBizImpl;
import room.entity.Room;

public class SelectByRoomidServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int roomid = 0;
		String roomidStr = request.getParameter("roomid");
		if(roomidStr!=null && roomidStr.length()>0){
			roomid = Integer.parseInt(roomidStr);
		}
		
		RoomBiz room = new RoomBizImpl();
		Room r = room.selectByRoomid(roomid);
		
		JSONObject obj = JSONObject.fromObject(r);
		PrintWriter out = response.getWriter();
		out.print(obj);
	
	}

}
