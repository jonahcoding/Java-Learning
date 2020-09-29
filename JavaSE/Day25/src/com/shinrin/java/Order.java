package com.shinrin.java;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {

    String orderName;
    int orderId;
    //类的内部结构可使用类的泛型
    T orderT;

    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    //非泛型方法
    public T getOrderT(){
        return orderT;
    }
    //非泛型方法
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }
    //非泛型方法
    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
//    静态方法中不能使用类的泛型。
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show(){
//    编译不通过
//        try{
//
//        }catch(T t){
//
//        }
    }

//    泛型类的对象在调用方法时才确定具体的泛型类型，而非实例化。
//    静态方法中不能使用类的泛型类型。
//    静态方法可以使用自身的泛型类型（泛型方法），即泛型方法与所属类是否为泛型类无关。
    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}
