package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;
import user.entity.User;

public class AddUserServ extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		String upwd = request.getParameter("upwd");
		String identity = request.getParameter("identity");
		
		User u = new User(userid,username,upwd,identity);
		UserBiz user = new UserBizImpl();
		user.add(u);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("selectUser.do").forward(request, response);
	}
}
