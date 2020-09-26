package com.shinrin.java;

import org.junit.Test;
import java.util.Date;

/*
--------------------
常见异常：
	1.常见异常
	2.异常处理机制：try-catch-finally
	3.异常处理机制：throws
	4.手动抛出异常：throw
	5.自定义异常：
--------------------
异常分类：
    1.Error：JVM无法解决，内存溢出等。不针对处理。
    2.Exception：空指针、文件不存在、网络中断、数组下标越界。
--------------------
异常体系结构：
    java.lang.Throwable
        |-----java.lang.Error:不针对处理。
        |-----java.lang.Exception:可做处理的异常。
            |-----编译时异常（checked）
                |-----IOException
                    |-----FileNotFoundException
                |-----ClassNotFoundException
            |-----运行时异常（unchecked）
                |-----NullPointerException
                |-----ArrayIndexOutOfBoundsException
                |-----ClassCastException
                |-----NumberFormatException
                |-----InputMismatchException
                |-----ArithmeticException
--------------------
 */
public class ExceptionTest {

    //NullPointerException
    @Test
    public void test1(){
        String str = null;
        System.out.println(str.charAt(0));
    }

    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        String str = "abc";
        System.out.println(str.charAt(3));
    }

    //ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String str = (String)obj;
    }

}
