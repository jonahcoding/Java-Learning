package com.shinrin.array;

public class Array {
    private int initialLen = 16;
    private int size = 0;
    private int capacity;
    private int[] m_data;
    private double expandFactor = 0.75;

    public Array(){
        capacity = initialLen;
        m_data = new int[capacity];
    }

    public Array(int len){
        if (len <= 0){
            capacity = initialLen;
        }else {
            capacity = len;
        }
        m_data = new int[capacity];
    }

    public void resize(int len){
        int[] resizeArr = new int[len];
        for (int i = 0; i < size; i++) {
            resizeArr[i] = m_data[i];
        }
        m_data = resizeArr;
        capacity = len;
    }

    public void add(int index, int num){
        if (index < 0 || index > size) {
            System.out.println("添加位置非法！");
            return;
        }
        if (size >= capacity * expandFactor) {
            resize(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            m_data[i] = m_data[i - 1];
        }
        m_data[index] = num;
        size++;
    }

    public void addFirst(int num){
        add(0, num);
    }

    public void addLast(int num){
        if (size >= capacity){
            resize(capacity * 2);
        }
        m_data[size] = num;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= size)
        {
            System.out.println("删除位置非法！");
            return;
        }
        int res = m_data[index];
        size--;
        for (int i = index; i < size; i++)
        {
            m_data[i] = m_data[i + 1];
        }
        if (size < capacity / 4) {
            resize(capacity / 2);
        }
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        if (size == 0)
        {
            System.out.println("删除位置非法！");
            return;
        }
//        remove(size);
        size--;
        if (size < capacity / 4)
        {
            resize(capacity / 2);
        }
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return size;
    }

    public void print(){
        System.out.print("[Array]    ");
        System.out.println("Capacity = " + capacity + "    Size = " + size);
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(m_data[i]);
            if (i != size-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
