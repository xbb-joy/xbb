package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;
import user.entity.User;

public class SelectByNameServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		
		UserBiz user = new UserBizImpl();
		User u = user.selectByName(username);
		
		request.setAttribute("u", u);
	    request.getRequestDispatcher("userInfo.jsp").forward(request, response);
	}

}
