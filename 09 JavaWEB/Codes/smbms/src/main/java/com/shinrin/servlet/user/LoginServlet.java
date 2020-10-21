package com.shinrin.servlet.user;

import com.shinrin.pojo.User;
import com.shinrin.service.user.UserService;
import com.shinrin.service.user.UserServiceImpl;
import com.shinrin.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet：控制层，调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start...");
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库中的密码比对，调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        if (user!=null){//用户存在，可登录
            //将用户的信息放入Session
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到管理页面
            resp.sendRedirect("jsp/frame.jsp");
        }else {//用户不存在
            req.setAttribute("error","用户名或者密码不正确！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
