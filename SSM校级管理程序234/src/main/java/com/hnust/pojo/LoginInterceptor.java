package com.hnust.pojo;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 23222 on 2023/4/30.
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        //User user=(User)request.getSession().getAttribute("USER_SESSION");
        String uri=request.getRequestURI();
        if (uri.indexOf("login")>=0){
            return true;
        }
        if (uri.indexOf("register")>=0){
            return true;
        }
        if (uri.indexOf("toRegister")>=0){
            return true;
        }
        HttpSession session=request.getSession();
        if(session.getAttribute("USER_SESSION")!=null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}