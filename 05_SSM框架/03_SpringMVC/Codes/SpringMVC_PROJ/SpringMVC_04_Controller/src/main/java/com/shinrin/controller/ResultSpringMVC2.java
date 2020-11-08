package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC2 {

    //转发
    @RequestMapping("/rsm2/t1")
    public String test1(){
        return "test";
    }

    //重定向
    @RequestMapping("/rsm2/t2")
    public String test2(){
        return "redirect:/index.jsp";
    }
}
