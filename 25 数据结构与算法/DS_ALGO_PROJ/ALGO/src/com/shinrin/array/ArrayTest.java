package com.shinrin.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array arr = new Array(16);
        for (int i = 0; i < 24; i++) {
            arr.add(i,i);
        }
        arr.print();
        arr.addFirst(-1);
        arr.print();
        arr.addLast(24);
        arr.print();
        arr.add(3,333);
        arr.print();
        arr.print();
        arr.remove(3);
        arr.removeLast();
        arr.print();
        arr.removeFirst();
        arr.print();

        System.out.println("数组为空？" + arr.isEmpty());
        System.out.println("包含15？" + arr.contains(15));
        System.out.println("获取索引位15：" + arr.get(15));
        arr.set(15, 155);
        arr.print();
        System.out.println("获取索引位122：" + arr.get(122));
    }
}
