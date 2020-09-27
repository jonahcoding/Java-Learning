package com.shinrin.java;

/*
--------------------
四、finally：
     "throws + 异常类型"写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
说明：
    1.finally是可选的.
    2.finally中声明一定会被执行的代码，即使try或catch中有return语句。
应用：
    JVM不能自动回收数据库连接、输入输出流、网络编程Socket等资源，需要手动释放【声明在finally中】。
--------------------
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionFinally {
    @Test
    public void method() {
        FileInputStream fls = null;
        try {
            File file = new File("hello.txt");
            fls = new FileInputStream(file);
            int data = fls.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fls.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fls != null)
                    fls.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
