package com.shinrin.java;
//同步方法 + Runnable
public class TicketSalesSyncRunnableMethod {
    public static void main(String[] args) {
//        同步代码块 Runnable
        Windows3 win = new Windows3();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("售票口C1");
        t2.setName("售票口C2");
        t3.setName("售票口C3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows3 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show(){//同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

            ticket--;
        }
    }
}
