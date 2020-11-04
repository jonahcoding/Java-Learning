package com.shinrin.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用此类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent){
        this.rent = rent;
    }

    //生成代理类
    //第二个参数：获取要代理的抽象角色（一类）。
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //proxy：代理类
    //method：代理类的调用处理程序的方法对象。
    //处理代理实例上的方法调用并返回结果。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //本质利用反射实现。
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    public void seeHouse(){
        System.out.println("see house");
    }

    public void fare(){
        System.out.println("fare");
    }
}