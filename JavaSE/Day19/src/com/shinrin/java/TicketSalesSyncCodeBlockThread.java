package com.shinrin.java;
//同步代码块 + Thread
public class TicketSalesSyncCodeBlockThread {
    public static void main(String[] args) {
        //同步代码块 Thread
        Windows2 win_1 = new Windows2();
        Windows2 win_2 = new Windows2();
        Windows2 win_3 = new Windows2();

        win_1.setName("售票口B1");
        win_2.setName("售票口B2");
        win_3.setName("售票口B3");

        win_1.start();
        win_2.start();
        win_3.start();
    }
}

class Windows2 extends Thread{
    private static int tickets = 10;
    private static Object obj = new Object();//Windows2.class 而非 win_1、win_2、win_3

    @Override
    public void run() {
        while (true){
            synchronized (obj) {
//            synchronized (Windows2.class) {
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