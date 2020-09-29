package com.shinrin.java;

/*
--------------------
三、throws：
     "throws + 异常类型"写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
说明：
    1.throws抛出异常后，其后代码不再执行。
    2.throws将异常抛给方法调用者，本身并不处理异常。
    3.父类方法没有throws时，子类对该方法重写也不能使用throws。
    4.当方法为嵌套调用时，使用throws。

--------------------
 */

import java.io.*;

public class ExceptionThrow {
    //main()调用method2()，method2()调用method1()
    //最终异常由main处理。
    public static void main(String[] args) {
        try{
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException{
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException{
        File file= new File("hello.txt");
        FileInputStream fls = new FileInputStream(file);
        int data = fls.read();
        while(data!= -1){
            System.out.print((char)data);
            data = fls.read();
        }
        fls.close();
        System.out.println("文件读取完毕！");
    }
}
