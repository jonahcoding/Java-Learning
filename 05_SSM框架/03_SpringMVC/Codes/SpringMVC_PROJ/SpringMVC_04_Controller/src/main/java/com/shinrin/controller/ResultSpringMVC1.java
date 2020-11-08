package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC1 {

    //转发一
    @RequestMapping("/rsm1/t1")
    public String test1(){
        return "/index.jsp";
    }

    //转发二
    @RequestMapping("/rsm1/t2")
    public String test2(){
        return "forward:/index.jsp";
    }

    //重定向
    @RequestMapping("/rsm1/t3")
    public String test3(){
        return "redirect:/index.jsp";
    }
}
