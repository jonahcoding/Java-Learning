package com.serein.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控：web.xml
    //http://localhost:8080/druid/login.html
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台登录，配置账号密码
        HashMap<String, String> initParameters = new HashMap<>();//登录key（固定）
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        //允许访问
        initParameters.put("allow","");//所有人可访问
        //initParameters.put("allow","localhost");//仅本地可访问
        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可过滤的请求
        HashMap<String, String> initParameters = new HashMap<>();
        //不参与统计的请求
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
