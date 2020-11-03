package com.shinrin.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {
    //默认byType实现，要求对象必须存在
    //指定参数required = false以允许对象为null
    @Autowired(required = false)
    //有多个对象时，按bean的id查找
    @Qualifier(value = "cat11")
    private Cat cat;

    //默认byName实现，查询未果时再按byType查找
    @Resource(name = "dog11")
    private Dog dog;

    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
