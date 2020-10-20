package com.shinrin.java;

/*
--------------------
线程池：
    提前创建多个线程放入线程池中，使用时获取，使用完放回。
    避免频繁创建销毁，实现重复利用。
优点：
    1.提高响应速度（减少创建新线程的时间）。
    2.降低资源消耗（重复利用）。
    3.便于线程管理。
        corePoolSize：核心池的大小。
        maximumPoolSize：最大线程数。
        keepAliveTime：无任务时最多保持时间。

步骤：
    1.提供指定线程数量的线程池。
    2.执行指定的线程操作。
    3.关闭连接池。

--------------------
*/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池。
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor services = (ThreadPoolExecutor) service;//类型转换
//        services.setCorePoolSize(15);
//        services.setKeepAliveTime();
//        System.out.println(service.getClass());
        //2.执行指定的线程操作。
//        service.execute(new NumberThread1());//适用于Runnable
//        service.execute(new NumberThread2());//适用于Runnable
//        service.submit(Callable callable);//适用于Callable
        //3.关闭连接池
        service.shutdown();
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class NumberThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
