package com.shinrin.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        //业务代码
        String result = "Hello SpringMVC";
        mv.addObject("msg", result);

        //视图跳转
        mv.setViewName("test");

        return mv;
    }
}
