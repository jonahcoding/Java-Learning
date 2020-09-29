package com.shinrin.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
----------------------------------------
自定义泛型类、泛型接口、泛型方法：
    1.泛型类型在实例化泛型类（或接口）时指定。
    2.泛型类的对象在调用方法时才确定具体的泛型类型。
    3.静态方法中不能使用类的泛型类型。
    4.静态方法可以使用自身的泛型类型（泛型方法），即泛型方法与所属类是否为泛型类无关。
    5.不能抛出或捕获泛型类的实例，并且泛型类扩展 Throwable 不合法。

注：
    public Order(){
        //编译不通过
        //T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }
----------------------------------------
*/
public class GenericsCustomTest {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");
        //实例化时尽可能指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");
        order1.setOrderT("AA:hello");
    }

    //泛型类的非泛型子类
    @Test
    public void test2(){
        SubOrder1 sub1 = new SubOrder1();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(1122);
//        SubOrder1<String> sub2 = new SubOrder1<>();
//        sub2.setOrderT("order2...");
    }

    @Test
    public void test3(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;
        Person p1 = null;
        Person p2 = null;
        p1 = p2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
