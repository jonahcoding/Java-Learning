package com.shinrin.java;

/*
--------------------
注解：
    1.JDK 5.0引入。
    2.代码中的特殊标记，编译、加载、运行时的补充信息。
    3.配置应用程序的切面。

示例：
    一、文档相关注解
    二、编译时格式检查
        1.@Override：重写父类方法。
        2.@Deprecated：修饰元素已过时。
        3.@SuppressWarnings：抑制编译器警告。
    三、跟踪代码依赖性，实现替代配置文件功能。

--------------------
*/

import java.util.Date;

public class AnnotationTest {
    public static void main(String[] args) {
        Student stu = new Student("Tom", 10);
        stu.Work();

        //@Deprecated：修饰元素已过时。
        Date date = new Date(2020, 9, 23);

        //@SuppressWarnings：抑制编译器警告。(此处为未使用变量)
        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println("num = " + num);
    }
}

//@Override：重写父类方法。
class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void Work(){
        System.out.println("Man Work!");
    }

    public void Eat(){
        System.out.println("Man Eat!");
    }
}

interface Inf{
    void show();
}

class Student extends Person implements Inf{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void Work() {
        System.out.println("Student Study！");
    }

    @Override
    public void Eat() {
        System.out.println("Student Eat!");
    }

    @Override
    public void show() {
        System.out.println("Look Look!");
    }
}