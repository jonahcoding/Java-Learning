package com.shinrin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/model")
@Controller
public class ModelTest {

    //ModelAndView
    @RequestMapping("/1")
    public ModelAndView ModelAndViewTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "ModelAndView Test");
        mv.setViewName("test");
        return mv;
    }

    //ModelMap
    @RequestMapping("/2")
    public String ModelMapTest(ModelMap model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg", "ModelMap Test");
        return "test";
    }

    //Model
    @RequestMapping("/3")
    public String hello(Model model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg", "Model Test");
        return "test";
    }

}
