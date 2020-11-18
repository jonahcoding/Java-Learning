package com.shinrin.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        //获取请求中的语言参数
        String language = request.getParameter("l");

        //如果请求链接中未携带国际化参数，使用默认
        Locale locale = Locale.getDefault();

        //如果请求链接中携带了国际化参数
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //语言，国家
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
