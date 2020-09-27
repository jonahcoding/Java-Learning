package com.shinrin.java;

/*
--------------------
线程创建：
方式一：继承Thread类
    步骤：
        1.创建继承于Thread类的子类。
        2.重写Thread成员方法run()，其中包含线程执行的操作。
        3.创建Thread类的子类的对象。
        4.调用子类对象的start()方法。
    说明：
        1.不能通过直接调用run()的方式启动线程，而是start()方法。
        2.重启新的线程，需要新建Thread类的子类的对象。否则异常：IllegalThreadStateException

方式二：实现Runnable接口
    步骤：
        1.创建类实现Runnable接口。
        2.实现Runnable的抽象方法run()。
        3.创建该类的对象。
        4.创建Thread类的对象，其中将实现Runnable接口的类的对象作为构造参数。
        5.调用Thread类的对象的start()方法。
    说明：
        优先选择实现Runnable接口的方法。
            1.避免单继承。
            2.适合多个线程共享数据。
--------------------
*/
public class ThreadTest {
    public static void main(String[] args) {
        //方式一：继承Thread类
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        //以下main线程中执行
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
//        myThread.start();

        //方式二：
        MyThread2 myThread2 = new MyThread2();

        Thread thread2 = new Thread(myThread2);
        thread2.start();

        Thread thread3 = new Thread(myThread2);
        thread3.start();
    }

}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}