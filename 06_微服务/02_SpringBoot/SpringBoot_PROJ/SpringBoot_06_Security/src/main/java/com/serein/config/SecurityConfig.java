package com.serein.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//开启WebSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //AOP：拦截器
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        //首页所有人可访问，功能页对应权限访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //无权限默认跳转到登录页
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/toLogin")
                .loginProcessingUrl("/login");//登录表单提交请求
        //关闭csrf
        http.csrf().disable();
        //开启记住我功能：cookie，默认保存两周。
        http.rememberMe().rememberMeParameter("remember");
        //开启注销，注销成功跳转到登录页
        http.logout().logoutSuccessUrl("/");
    }

    //认证
    //密码编码：PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //开发时数据从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("serein").password(new BCryptPasswordEncoder().encode(("123456"))).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode(("123456"))).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode(("123456"))).roles("vip1");
    }
}
