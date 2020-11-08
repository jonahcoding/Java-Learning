package com.shinrin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shinrin.pojo.User;
import com.shinrin.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class UserController {

    //produces:指定响应体返回类型和编码
    //@RequestMapping(value = "/json1", produces = "application/json;character=utf-8")
    @RequestMapping("/json1")
    //@ResponseBody//不走视图解析器，直接返回一个字符串；已使用 @RestController 代替
    public String json1() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("樊川", 3, "男");
        String str = mapper.writeValueAsString(user);
        //使用注解以返回字符串
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("樊川", 17, "男");
        User user2 = new User("樊川", 17, "男");
        User user3 = new User("樊川", 17, "男");
        User user4 = new User("樊川", 17, "男");
        ArrayList<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        String str = mapper.writeValueAsString(list);
        return str;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json5")
    public String json5(){
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

}
