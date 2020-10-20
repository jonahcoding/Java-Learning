package com.shinrin.java;

//Error：JVM无法解决的问题，内存溢出等。不针对处理。

public class ErrorTest {
    public static void main(String[] args) {
        //1.栈溢出：java.lang.StackOverflowError
        //main(args);
        //2.堆溢出：java.lang.OutOfMemoryError
        Integer[] arr = new Integer[1024*1024*1024];
    }
}
