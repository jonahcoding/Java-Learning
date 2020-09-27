package com.shinrin.java;

/*执行结果：
    方法A
    A方法的finally
    制造异常
    方法B
    方法B的finally*/

public class ExceptionByReturn {
    static void methodA() {
        try {
            System.out.println("方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("A方法的finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("方法B");
            return;
        } finally {
            System.out.println("方法B的finally");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {//new RuntimeException("制造异常")
            System.out.println(e.getMessage());
        }

        methodB();
    }
}