package com.shinrin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        //服务器从客户端获取Cookie
        Cookie[] cookies = req.getCookies();//Cookie为数组，存在多个
        //判断Cookie是否存在
        if (cookies != null){
            out.write("上次访问本站的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取Cookie的名字
                if (cookie.getName().equals("LastLoginTime")){
                    //获取Cookie的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("第一次访问本站");
        }
        //服务器给客户端响应一个Cookie
        Cookie cookie = new Cookie("LastLoginTime",System.currentTimeMillis()+"");
        //设置Cookie有效期
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
