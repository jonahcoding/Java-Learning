package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    //原始方法：http://localhost:8080/add?a=1&b=2
    public String test1(int a, String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "[原始方法]结果为：" + res);
        return "test";
    }

    //RestFul：http://localhost:8080/add/a/b
    //@RequestMapping("/add")
    //①通过method属性约束请求类型（value与path互为别名）
    //@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    //②通过Mapping的变体约束请求类型
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "[GET]结果为：" + res);
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "[POST]结果为：" + res);
        return "test";
    }
}
