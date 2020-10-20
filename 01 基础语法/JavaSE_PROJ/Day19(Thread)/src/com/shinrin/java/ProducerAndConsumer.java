package com.shinrin.java;
/*
--------------------
生产者与消费者：
    1.生产者线程、消费者线程
    2.线程共享数据（店员、产品）
    3.线程安全
    4.线程通信

--------------------
*/
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("生产者");
        Consumer consumer1 = new Consumer(clerk);
        consumer1.setName("消费者1");
        Consumer consumer2 = new Consumer(clerk);
        consumer2.setName("消费者2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

class Clerk {
    private int productCount = 20;
    //生产
    public synchronized void produceProduct(){
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品。");
            notify();
        }else {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //消费
    public synchronized void consumeProduct(){
        if (productCount > 0){
            productCount--;
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品。");
            notify();
        }else {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产...");
        while (true){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}


class Consumer extends Thread {
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费...");
        while (true){
            try {
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}