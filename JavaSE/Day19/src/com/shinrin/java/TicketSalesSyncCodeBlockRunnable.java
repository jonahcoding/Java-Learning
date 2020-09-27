package com.shinrin.java;

/*
--------------------
售票（同步问题）：
    多个线程同时对一个数据修改，如何保证线程安全？
    通过同步机制，使同一时间仅有一个线程可对数据操作。

线程同步
实现方式一：同步代码块
     synchronized(同步监视器){
        //需要被同步的代码
    }
    说明：
        1.操作共享数据的代码，即为需要被同步的代码。
        2.共享数据：多个线程共同操作的变量。如ticket。
        3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
    要求：多个线程必须要共用同一把锁。
    补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。

实现方式二：同步方法
    操作共享数据的代码声明在一个方法体中，则将次方法声明为同步方法。

线程同步局限性：
    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。

--------------------
*/

//同步代码块 + Runnable
public class TicketSalesSyncCodeBlockRunnable {
    public static void main(String[] args) {
//        同步代码块 Runnable
        Windows1 win = new Windows1();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("售票口A1");
        t2.setName("售票口A2");
        t3.setName("售票口A3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows1 implements Runnable{
    private static int tickets = 10;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (tickets > 0) {
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 售票中..剩余" + tickets + "张票");
                    tickets--;
                }else {
                    break;
                }
            }
        }
    }
}
