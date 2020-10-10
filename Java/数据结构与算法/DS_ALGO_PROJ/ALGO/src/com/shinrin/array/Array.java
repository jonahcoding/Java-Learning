package com.shinrin.array;

public class Array {
    private int initialLen = 16;
    private int m_size = 0;
    private int m_capacity;
    private int[] m_data;
    private double expandFactor = 0.75;

    public Array(){
        m_capacity = initialLen;
        m_data = new int[m_capacity];
    }

    public Array(int len){
        if (len <= 0){
            m_capacity = initialLen;
        }else {
            m_capacity = len;
        }
        m_data = new int[m_capacity];
    }

    public void resize(int len){
        int[] resizeArr = new int[len];
        for (int i = 0; i < m_size; i++) {
            resizeArr[i] = m_data[i];
        }
        m_data = resizeArr;
        m_capacity = len;
    }

    public void add(int index, int num){
        if (index < 0 || index > m_size) {
            System.out.println("添加位置非法！");
            return;
        }
        if (m_size >= m_capacity * expandFactor) {
            resize(m_capacity * 2);
        }
        for (int i = m_size; i > index; i--) {
            m_data[i] = m_data[i - 1];
        }
        m_data[index] = num;
        m_size++;
    }

    public void addFirst(int num){
        add(0, num);
    }

    public void addLast(int num){
        if (m_size >= m_capacity){
            resize(m_capacity * 2);
        }
        m_data[m_size] = num;
        m_size++;
    }

    public void remove(int index){
        if (index < 0 || index >= m_size)
        {
            System.out.println("删除位置非法！");
            return;
        }
        int res = m_data[index];
        m_size--;
        for (int i = index; i < m_size; i++)
        {
            m_data[i] = m_data[i + 1];
        }
        if (m_size < m_capacity / 4) {
            resize(m_capacity / 2);
        }
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        if (m_size == 0)
        {
            System.out.println("删除位置非法！");
            return;
        }
//        remove(size);
        m_size--;
        if (m_size < m_capacity / 4)
        {
            resize(m_capacity / 2);
        }
    }

    void removeElement(int num){
        int index = find(num);
        if (index != -1){
            remove(index);
        }
    }

    int find(int num){
        for (int i = 0; i < m_size; i++) {
            if (m_data[i] == num){
                return i;
            }
        }
        return -1;
    }

    void set(int index,int num){
        if (index < 0 || index >= m_size)
        {
            System.out.println("位置非法！");
            return;
        }
        m_data[index] = num;
    }

    int get(int index) {
        return m_data[index];
    }

    boolean contains(int num){
        for (int i = 0; i < m_size; i++) {
            if (m_data[i] == num){
                return true;
            }
        }
        return false;
    }

    public int capacity(){
        return m_capacity;
    }

    public int size(){
        return m_size;
    }

    boolean isEmpty(){
        return m_size == 0;
    }

    public void print(){
        System.out.print("[Array]    ");
        System.out.println("Capacity = " + capacity() + "    Size = " + size());
        System.out.print("[");
        for (int i = 0; i < m_size; i++) {
            System.out.print(m_data[i]);
            if (i != m_size -1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
