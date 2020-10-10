package com.shinrin.java;

/*
--------------------
线程安全（同步）的解决方法（共三种）
实现方式三：Lock锁

面试题：synchronized 与 Lock的异同？
    相同：
        二者都可以解决线程安全问题。
    不同：
        synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器。
        Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）。

优先使用顺序：
  Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）

--------------------
*/


import java.util.concurrent.locks.ReentrantLock;

//同步代码块 + Runnable
public class TicketSalesSyncRunnableLock {
    public static void main(String[] args) {
//        同步代码块 Runnable
        Windows5 win = new Windows5();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("售票口E1");
        t2.setName("售票口E2");
        t3.setName("售票口E3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows5 implements Runnable{
    private static int tickets = 10;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
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
            }finally {
                lock.unlock();
            }
        }
    }
}
