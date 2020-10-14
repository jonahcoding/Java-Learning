# JUC

## 一、JUC定义

> **java.util工具包。**

实现线程的方式：

- 继承Thread类：复写run()方法（线程执行代码），调用**start()方法（由native修饰）**启动。
- 实现Rnunnable接口：实现类复写run()方法，实例化对象作为Thread类的构造参数，调用start()。
- 实现Callable（有返回值）：
- ThreadPoolExecutor（线程池）：

## 二、进程与线程

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

## 三、并发与并行

并发：多线程操作同一个资源，交替执行（CPU单核）。

并行：多个线程同时进行，使用线程池操作。（CPU多核）。

> 并发编程的本质：**充分利用CPU的资源。**
>
> Java多线程是并行（左右CPU都具有负载）。

## 四、Lock

共享锁与独占锁：AbstractQueuedSynchronizer对于共享同步和独占同步的支持。

> 独占模式

AbstractQueuedSynchronizer（AQS，抽象队列同步器）使用一个volatile类型的int作为同步变量，任何想获得锁的进程竞争该变量，已获得锁的线程继续业务的执行，未获得锁的进程放入FIFO队列中，等待再次竞争。

### 4.1 锁的独占与共享

java并发包提供的加锁模式分为独占锁与共享锁。

- 独占锁：仅一个线程持有锁，ReentrantLock就是以独占方式实现的互斥锁。

- 共享锁：允许多个线程同时获取锁，并发访问共享资源，如：ReadWriteLock。

**AQS的内部类Node定义了两个常量SHARED（共享）和EXCLUSIVE（独占）**，他们分别标识 AQS队列中等待线程的锁获取模式。

注：

​		独占锁是一种悲观保守的加锁策略，避免了读/写冲突，如某个只读线程获取锁，其余线程均等待（存在问题：读操作不会影响文件一致性）。共享锁是一种乐观锁，可允许多个执行读操作的线程同时访问共享资源。java的并发包中提供了**ReadWriteLock（读-写锁），允许一个资源被多个读操作访问或一个写操作访问，但两者不能同时进行。**

### 4.2 锁的公平与非公平

​		锁的公平与非公平，是指线程请求获取锁的过程中，是否允许插队。在公平锁上，线程将按他们发出请求的顺序来获得锁；而非公平锁则允许在线程发出请求后立即尝试获取锁，如果可用则可直接获取锁，尝试失败才进行排队等待。ReentrantLock提供了两种锁获取方式，FairSyn和NofairSync。**结论：ReentrantLock是以独占锁的加锁策略实现的互斥锁，同时它提供了公平和非公平两种锁获取方式**。

### 4.3 AQS提供的模板方法

AQS提供了独占锁和共享锁必须实现的方法。

#### 4.3.1 具有独占锁功能的子类必须实现：

- tryAcquire（获取锁）
- tryRelease（释放锁）
- isHeldExclusively（是否独占锁）
- ...

#### 4.3.2 具有共享锁功能的子类必须实现：

- tryAcquireShared
- tryReleaseShared
- ...

> 带Shared后缀的方法均支持共享锁加锁。
>
> Semaphore是一种共享锁，ReentrantLock是一种独占锁。
>
> 独占锁获取锁时，设置节点模式为Node.EXCLUSIVE。
>
> 共享锁获取锁，节点模式则为Node.SHARED。





























