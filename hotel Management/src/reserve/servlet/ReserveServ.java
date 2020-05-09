package reserve.servlet;

import java.io.IOException;
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
import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;
import user.entity.User;

public class ReserveServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		doPost(request,response);
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取前台参数
		String username=request.getParameter("username");
		
		int roomid=0;
		String idStr1=request.getParameter("roomid");
		if(idStr1!=null && idStr1.length()>0){
			roomid=Integer.parseInt(idStr1);
		}
		
		String time1=request.getParameter("arrive");
		Date arrive=Date.valueOf(time1);
		
		String time2=request.getParameter("leave");
		Date leave=Date.valueOf(time2);
		
		String status=request.getParameter("status");
		
		UserBiz user=new UserBizImpl();
		User u=user.selectByName(username);
		
		User u1=new User();
		u1.setUserid(u.getUserid());
		
		Room r=new Room();
		r.setRoomid(roomid);
		
		ReserveBiz res=new ReserveBizImpl();
		res.add(new Reserve(u,r,arrive,leave,status));		
    
		RoomBiz room =new RoomBizImpl();
		Room r1=room.selectByRoomid(roomid);
		String str="已预定";
		room.update(new Room(r1.getRoomid(),r1.getRoomtype(),str,r1.getPrice(),r1.getPath()));

   
		request.getRequestDispatcher("selectByStatus.do").forward(request, response);
		
	}


}
