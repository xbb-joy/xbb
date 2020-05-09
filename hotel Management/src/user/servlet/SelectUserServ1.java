package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;
import user.entity.User;

public class SelectUserServ1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		UserBiz user = new UserBizImpl();
		List<User> list = user.selectAll();

		request.setAttribute("list", list);
		request.getRequestDispatcher("userInfo.jsp").forward(request,response);
	}

}
