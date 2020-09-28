package com.shinrin.java;

/*
----------------------------------------
注解：

一、说明
    1.JDK 5.0引入。
    2.注解是一种能被添加到java源代码中的元数据，方法、类、参数和包都可以用注解来修饰。
    3.注解可以看作是一种特殊的标记，可以用在方法、类、参数和包上，程序在编译或者运行时可以检测到这些标记而进行一些特殊的处理。

二、使用：
    一、文档相关注解
    二、编译时格式检查
        1.@Override：重写父类方法。
        2.@Deprecated：修饰元素已过时。
        3.@SuppressWarnings：抑制编译器警告。
    三、跟踪代码依赖性，实现替代配置文件功能。

三、注解的基本元素
    1.修饰符
        访问修饰符必须为public,不写默认为pubic；
    2.关键字
        关键字为@interface；
    3.注解名称
        注解名称为自定义注解的名称，使用时还会用到；
    4.注解类型元素
        注解类型元素是注解中内容，可以理解成自定义接口的实现部分。

四、元注解
    用于修饰注解。
    @Target：表明该注解可以应用的java元素类型。
    @Retention：注解的生命周期。
    @Document：表明该注解标记的元素可以被Javadoc 或类似的工具文档化
    @Inherited：所标记类的子类也拥有此注解。
----------------------------------------
*/

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
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

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(int i = 0;i < annotations.length;i++){
            System.out.println(annotations[i]);
        }
    }
}

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
//注解Override
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
