package com.shinrin.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array arr = new Array(16);
        for (int i = 0; i < 24; i++) {
            arr.add(i,i);
//            System.out.println(i + " " + arr.getCapacity() + " " + arr.getSize());
        }
        arr.print();
        arr.addFirst(-1);
        arr.print();
        arr.removeLast();
        arr.print();
        arr.remove(2);
        arr.print();
    }
}
