package com.shinrin.config;

import com.shinrin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.shinrin.pojo")
@Import(Config2.class)
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
