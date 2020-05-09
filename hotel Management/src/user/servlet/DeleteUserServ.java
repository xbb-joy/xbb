package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;

public class DeleteUserServ extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int userid = 0;
		String idStr = request.getParameter("userid");
		if (idStr != null && idStr.length() > 0) {
			userid = Integer.parseInt(idStr);
		}
		
		UserBiz user = new UserBizImpl();
		user.delete(userid);
		
		request.getRequestDispatcher("selectUser.do").forward(request,response);
	}
}
