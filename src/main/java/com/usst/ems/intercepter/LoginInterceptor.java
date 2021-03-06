package com.usst.ems.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }else{
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }

    }
}
