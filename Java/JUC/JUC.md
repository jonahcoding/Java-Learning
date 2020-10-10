# 一、JUC

## 1.1 JUC定义

> **java.util工具包。**

实现线程的方式：

- 继承Thread类：复写run()方法（线程执行代码），调用**start()方法（由native修饰）**启动。
- 实现Rnunnable接口：实现类复写run()方法，实例化对象作为Thread类的构造参数，调用start()。
- Callable（有返回值）：
- ThreadPoolExecutor（线程池）：

## 1.2 进程与线程

进程：操作系统能够进行资源分配的最小单位（一个运行中的程序的集合/容器），包含一个或多个线程。

> java默认由两个线程：main线程、gc线程。

线程：操作系统能够进行运算调度的最小单位（由内核负责管理）。

> 线程的状态（6个）：

```java
// 新生：新建线程对象，未调用start()方法。
public static final State NEW;
// 运行：就绪（ready）+运行中（running）
public static final State RUNNABLE;
// 阻塞：线程阻塞于锁（获取锁时的状态）。
public static final State BLOCKED;
// 等待：等待其他线程做出一些特定动作（通知或中断）。
public static final State WAITING;
// 超时等待：在指定的时间后自行返回。
public static final State TIMED_WAITING;
// 终止：线程执行完毕
public static final State TERMINATED;
```

> wait与sleep的区别：

|          | wait       | slepp        |
| -------- | ---------- | ------------ |
| 类       | Object类   | 线程类       |
| 锁的释放 | 释放锁     | 不释放锁     |
| 使用范围 | 同步代码块 | 任意位置     |
| 异常捕获 | 不需要捕获 | 需要捕获异常 |

## 1.3 并发与并行

并发：多线程操作同一个资源，交替执行（CPU单核）。

并行：多个线程同时进行，使用线程池操作。（CPU多核）。

> 并发编程的本质：充分利用CPU的资源。
>
> Java多线程是并行（左右CPU都具有负载）。













































