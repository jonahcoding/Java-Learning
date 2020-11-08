package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //真实访问路径：localhost:8080/项目名/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg", "Hello SpringMVC Annotation");
        //由视图解析器处理（拼接为/WEB-INF/jsp/hello.jsp）
        return "hello";
    }
}
