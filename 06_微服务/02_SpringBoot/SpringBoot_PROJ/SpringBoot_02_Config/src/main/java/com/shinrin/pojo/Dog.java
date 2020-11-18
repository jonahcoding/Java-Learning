package com.shinrin.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(value = "dog")
public class Dog {
    //@Value("阿黄")
    private String firstName;
    //@Value("18")
    private Integer age;
}
