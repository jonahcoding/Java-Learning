package com.shinrin.servlet;

import com.shinrin.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取Session
        HttpSession session = req.getSession();
        //存入数据
        session.setAttribute("name", new Person("shinrin",17));
        //获取Session的ID
        String id = session.getId();
        //判断是否为新创建
        if (session.isNew()){
            resp.getWriter().write("Session创建成功，ID为"+id);
        }else {
            resp.getWriter().write("ID为" + id + "的Session已存在于服务器");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
