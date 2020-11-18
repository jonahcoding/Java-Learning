package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        //具体业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser", username);
            //此处通过重定向隐藏了账户密码信息。
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "index";
        }
    }
}
