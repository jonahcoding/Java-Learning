package com.shinrin.controller;

import com.shinrin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //localhost:8080/user/t1?name=shinrin
    @GetMapping("/t1")
    public String test1(String name, Model model){
        System.out.println("接受到前端的参数是：" + name);
        model.addAttribute("msg", name);
        return "test";
    }

    //localhost:8080/user/t2?username=shinrin
    //注解@RequestParam：约定前端传入的参数名
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model){
        System.out.println("接受到前端的参数是：" + name);
        model.addAttribute("msg", name);
        return "test";
    }

    //前端接受的是一个对象：id, name, age
    //1.接受前端用户传递的参数，判断参数的名字，假设名字在方法上，则直接使用
    //2.假设传递的是一个对象User，则匹配User对象的字段名。
    //http://localhost:8080/user/t2?id=1&name=shinrin&age=17
    @GetMapping("/t3")
    public String test3(User user){
        System.out.println(user);
        return "test";
    }

}
