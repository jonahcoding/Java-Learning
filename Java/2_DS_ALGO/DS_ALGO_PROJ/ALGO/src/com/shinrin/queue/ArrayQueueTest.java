package com.shinrin.queue;

public class ArrayQueueTest{
    public static void main(String[] args) {
        //创建队列
        ArrayQueue queue = new ArrayQueue(5);
        //打印队列
        queue.print();
        //入队
        int i = 5;
        while (i > 0){
            queue.enQueue(i);
            i--;
        }
        queue.print();
        queue.enQueue(6);
        queue.print();
        //打印队首元素
        System.out.println("FRONT = " + queue.front());
        //出队
        int j = 5;
        while (j > 0){
            queue.deQueue();
            queue.print();
            j--;
        }
        queue.print();
    }
}

class ArrayQueue {
    private int m_initLen = 10;
    private int front = -1;
    private int rear = -1;
    private int m_size = 0;
    private int m_capacity = 0;
    private int[] m_data = null;

    public ArrayQueue(){
        m_capacity = m_initLen;
        m_data = new int[m_initLen];
    }

    public ArrayQueue(int initLen){
        if (initLen <= 0){
            m_capacity = m_initLen;
        }else {
            m_capacity = initLen;
        }
        m_data = new int[m_capacity];
    }

    public void enQueue(int num){
        if (isFull()){
            System.out.println("Failed to enqueue, because the queue is full!");
            return;
        }
        front = 0;//  0
        rear++;
        m_data[rear] = num;
        m_size = rear - front + 1;
    }

    public void deQueue(){
        if (isEmpty()){
            System.out.println("Failed to dequeue, because the queue is empty!");
            return;
        }
        for (int i = 0; i < m_size-1; i++) {
            m_data[i] = m_data[i+1];
        }
        rear--;
        m_size = rear - front + 1;
    }

    public int front(){
        return m_data[front];
    }

    public boolean isFull(){
        if (m_capacity == m_size){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (m_size == 0){
            return true;
        }
        return false;
    }

    public void print(){
        System.out.print("Capacity： " + m_capacity + "  , Size： " + m_size);
        System.out.println("  , front: " + front + "  , rear: " + rear);
        if (isEmpty()){
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("front[");
        for (int i = 0; i < m_size; i++) {
            System.out.print(m_data[i]);
            if (i != m_size - 1){
                System.out.print(",");
            }
        }
        System.out.println("]rear");
    }
}
