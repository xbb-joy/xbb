package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import user.biz.UserBiz;
import user.biz.impl.UserBizImpl;
import user.entity.User;

public class LoginServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username"); 
		String upwd = request.getParameter("upwd");
		
		UserBiz user = new UserBizImpl();		
		User u = user.login(username, upwd);
		//创建session对象
		HttpSession session = request.getSession();
		session.setAttribute("user",u);
		session.setAttribute("username", username);
		
		//将user对象转换成json对象
		JSONObject obj = JSONObject.fromObject(u);
		PrintWriter out = response.getWriter();
		//将数据发送给前端
		out.print(obj);
				
	}

}
