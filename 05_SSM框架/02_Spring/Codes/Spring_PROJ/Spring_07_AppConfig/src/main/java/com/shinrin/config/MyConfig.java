package com.shinrin.config;

import com.shinrin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//本身是一个@Component，也会被Spring容器托管，注册到容器中。
//@Configuration代表Spring配置类，同beans.xml
@Configuration
@ComponentScan("com.shinrin.pojo")
@Import(Config2.class)
public class MyConfig {

    //注册一个bean：相当于bean标签。
    //方法名称：相当于bean标签的id属性。
    //方法返回值：相当于bean标签中的class属性。
    @Bean
    public User getUser(){
        return new User();//返回注入到bean中的对象。
    }
}
