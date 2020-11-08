package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test3")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg", "ControllerTest 3  /test/t1");
        return "test";
    }

    @RequestMapping("/t1/t1")
    public String test2(Model model){
        model.addAttribute("msg", "ControllerTest 3  /test/t1/t1");
        return "test";
    }
}
