package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResultGo {

    @RequestMapping("/result/t1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello, Spring By Servlet API");
    }

    //重定向
    @RequestMapping("/result/t2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }

    //转发
    @RequestMapping("/result/t3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.setAttribute("msg", "/result/t3");
       request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }
}
