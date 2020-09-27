package com.shinrin.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

方式三：实现Callable接口。 --- JDK 5.0新增
    步骤：
        1.创建一个实现Callable的实现类。
        2.实现call方法，将此线程需要执行的操作声明在call()中。
        3.创建Callable接口实现类的对象。
        4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象。
        5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()。
        6.获取Callable中call方法的返回值。

    如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
        1. call()可以有返回值的。
        2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
        3. Callable是支持泛型的
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

        //方式三：
        MyThread3 numThread = new MyThread3();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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

class MyThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
