package reserve.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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

public class AddReserveServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf=8");
		
		int userid=0;
		String idStr2=request.getParameter("userid");
		if(idStr2!=null && idStr2.length()>0){
			userid=Integer.parseInt(idStr2);
		}
		
		int roomid=0;
		String idStr3=request.getParameter("roomid");
		if(idStr3!=null&&idStr3.length()>0){
			roomid = Integer.parseInt(idStr3);
		}

		String time1=request.getParameter("arrive");
		Date arrive=Date.valueOf(time1);
		
		String time2=request.getParameter("leave");
		Date leave=Date.valueOf(time2);
		
		String status=request.getParameter("status");
	
		User u=new User();
		u.setUserid(userid);
		
		Room r=new Room();
		r.setRoomid(roomid);
		
		ReserveBiz reserve=new ReserveBizImpl();
		reserve.add(new Reserve(u,r,arrive,leave,status));
		
		if(status.equals("已预定")){
			RoomBiz room = new RoomBizImpl();
			Room r1 = room.selectByRoomid(roomid);
			String str = "已预定";
			room.update(new Room(r1.getRoomid(),r1.getRoomtype(),str,r1.getPrice(),r1.getPath()));
		}
		if(status.equals("已取消")){
			RoomBiz room =new RoomBizImpl();
			Room r1 = room.selectByRoomid(roomid);
			String str="空房";
			room.update(new Room(r1.getRoomid(),r1.getRoomtype(),str,r1.getPrice(),r1.getPath()));
		}
		if(status.equals("已入住")){
			RoomBiz room =new RoomBizImpl();
			Room r1 = room.selectByRoomid(roomid);
			String str="已入住";
			room.update(new Room(r1.getRoomid(),r1.getRoomtype(),str,r1.getPrice(),r1.getPath()));
		}
		
		request.getRequestDispatcher("selectReserve.do").forward(request, response);
		
	}
}
