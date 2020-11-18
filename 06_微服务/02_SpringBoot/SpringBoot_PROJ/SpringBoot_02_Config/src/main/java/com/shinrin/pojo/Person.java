package com.shinrin.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@Validated  //声明使用JSR303检验
@ConfigurationProperties(prefix = "person")
//加载指定的配置文件
//@PropertySource(value = "classpath:shinrin.properties")
public class Person {
    //@Value("${name}")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> list;
    private Dog dog;

    //JSR303校验邮箱格式
    @Email(message = "电子邮件格式")
    private String email;
}
