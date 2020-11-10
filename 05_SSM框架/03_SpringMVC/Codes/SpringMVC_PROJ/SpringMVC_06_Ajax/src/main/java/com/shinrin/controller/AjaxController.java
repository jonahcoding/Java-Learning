package com.shinrin.controller;

import com.shinrin.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        if ("shinrin".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> userList = new ArrayList<User>();

        userList.add(new User("shinrin", 1, "男"));
        userList.add(new User("Jonah", 2, "男"));
        userList.add(new User("雨", 3, "女"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if (name!=null){
            if ("admin".equals(name)){
                msg = "OK";
            }else {
                msg = "用户名错误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "密码错误";
            }
        }
        return msg;
    }

}
