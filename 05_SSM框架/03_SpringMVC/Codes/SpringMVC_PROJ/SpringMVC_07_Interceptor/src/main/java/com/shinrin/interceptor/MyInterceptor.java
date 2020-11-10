package com.shinrin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //    在请求处理的方法前执行
    //    如果返回true执行下一个拦截器
    //    如果返回false则不执行下一个拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("☆☆☆☆☆处理前☆☆☆☆☆");
        return true;
    }

    //在请求方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("☆☆☆☆☆处理后☆☆☆☆☆");
    }

    //在dispatchServlet处理后执行，做清理工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("☆☆☆☆☆清理☆☆☆☆☆");
    }
}
