package com.shinrin;

import com.shinrin.pojo.Dog;
import com.shinrin.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02Config1ApplicationTests {

    @Autowired
    Dog dog;
    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }
}
