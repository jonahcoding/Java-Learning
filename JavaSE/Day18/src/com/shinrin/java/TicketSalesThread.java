package com.shinrin.java;

/*
--------------------
售票：
    实现：
        继承Thread方式。
    问题：
        线程不安全
--------------------
*/
public class TicketSalesThread {
    public static void main(String[] args) {
        Windows1 t1 = new Windows1();
        Windows1 t2 = new Windows1();
        Windows1 t3 = new Windows1();

        t1.setName("Windows_A");
        t2.setName("Windows_B");
        t3.setName("Windows_C");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows1 extends Thread{
    private static int tickets = 10;

    @Override
    public void run() {
        while (true){
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " 售票中..剩余" + tickets + "张票");
                tickets--;
            }else {
                break;
            }
        }
    }
}