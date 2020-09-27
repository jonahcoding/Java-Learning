package com.shinrin.java;

/*
--------------------
死锁：
    每个线程分别占用对方所需的资源，导致所有进程阻塞无法执行。

产生原因：
    1.竞争资源。
    2.进程间推进顺序非法。

产生死锁的必要条件：
    1.互斥条件：进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用。
    2.请求和保持条件：当进程因请求资源而阻塞时，对已获得的资源保持不放。
    3.不剥夺条件：进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放。
    4.环路等待条件：在发生死锁时，必然存在一个进程--资源的环形链。

预防死锁：
    1.以约定的顺序获得锁。
    2.超时放弃。

接解除死锁：
    1.剥夺资源。
    2.撤销进程。

以下示例说明：
    1.o1、o2静态对象（资源）仅一份。
    2.线程1先锁o1，再尝试锁o2。
    3.线程2先锁o2，再尝试锁o2。
    4.线程1、2分别占用了对方所需资源，从而阻塞，造成死锁。
--------------------
*/

public class DeadLock implements Runnable {
    public int flag = 1;
    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {

        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();
    }
}

