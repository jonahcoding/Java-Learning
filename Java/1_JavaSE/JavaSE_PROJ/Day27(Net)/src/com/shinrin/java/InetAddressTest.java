package com.shinrin.java;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
----------------------------------------
一、网络编程中有两个主要的问题：
    1.定位主机（主机上的应用）
    2.高效数据传输

二、网络编程中的两个要素：
    1.IP和端口号
    2.网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）

三、通信要素一：
    IP和端口号
    1. IP:唯一的标识 Internet 上的计算机（通信实体）
    2. 在Java中使用InetAddress类代表IP
    3. IP分类：IPv4 和 IPv6 ; 万维网 和 局域网
    4. 域名: www.baidu.com
    5. 本地回路地址：127.0.0.1 对应着：localhost
    6. 实例化InetAddress:两个方法：getByName(String host) 、 getLocalHost()、两个常用方法：getHostName() / getHostAddress()
    7. 端口号：
        定义：正在计算机上运行的进程，用于区分不同的进程。
        要求：不同的进程有不同的端口号
        范围：被规定为一个 16 位的整数 0~65535。
    8. 端口号与IP地址的组合得到一个网络套接字：Socket
四、通信要素二：
    TCP/IP协议簇（传输控制协议 + 网络互联协议）
    TCP：传输控制协议
        1.建立连接（三次握手、点对点、可靠、低效），只由客户端发起
        2.应用进程：客户端、服务端
        3.释放连接（四次挥手），通常由客户端发起
    UDP：用户数据报协议
        1.不需要建立连接（不可靠）
        2.数据源封装为数据包，限制64K内
        3.可广播
        4.无需释放资源，高效

----------------------------------------
*/
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("221.236.11.166");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);
            System.out.println(inet1.getHostName());
            System.out.println(inet1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
