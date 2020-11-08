package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表该类被Spring接管，其中所有的方法如返回值是String，则跳转到指定视图
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model){
        model.addAttribute("msg", "ControllerTest 2");
        return "test";  //WEB-INF/jsp/test.jsp
    }

    //视图复用
    @RequestMapping("/t3")
    public String test3(Model model){
        model.addAttribute("msg", "ControllerTest 3");
        return "test";  //WEB-INF/jsp/test.jsp
    }
}
