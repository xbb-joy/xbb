package com.ep.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object user = session.getAttribute("user");
        if (user != null) {//已登录
            return true;
        } else {//未登录
            //直接重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }
}