package com.shinrin.java;
//同步方法 + Thread
public class TicketSalesSyncThreadMethod {
    public static void main(String[] args) {
        //同步方法 Thread
        Windows4 win_1 = new Windows4();
        Windows4 win_2 = new Windows4();
        Windows4 win_3 = new Windows4();

        win_1.setName("售票口D1");
        win_2.setName("售票口D2");
        win_3.setName("售票口D3");

        win_1.start();
        win_2.start();
        win_3.start();
    }
}

class Windows4 extends Thread{
    private static int tickets = 10;
    private static Object obj = new Object();//Windows2.class 而非 win_1、win_2、win_3

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private static synchronized void show(){
        if (tickets > 0) {
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 售票中..剩余" + tickets + "张票");
            tickets--;
        }
    }
}