package com.shinrin.java;

/*
--------------------
售票：
    实现：
        实现Runnable接口。
    问题：
        线程不安全。
--------------------
*/
public class TicketSalesRunnable {
    public static void main(String[] args) {
        Windows2 win = new Windows2();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("Windows_A");
        t2.setName("Windows_B");
        t3.setName("Windows_C");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows2 implements Runnable{
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