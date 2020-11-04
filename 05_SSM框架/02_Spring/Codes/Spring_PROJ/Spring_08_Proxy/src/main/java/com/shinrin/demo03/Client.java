package com.shinrin.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理实例的调用处理程序
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //放置真实角色
        proxyInvocationHandler.setRent(host);
        //动态生成对应的代理类
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();
    }
}