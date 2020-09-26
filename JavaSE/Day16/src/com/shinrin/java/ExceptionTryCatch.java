package com.shinrin.java;

import org.junit.Test;

/*
--------------------
一、抓抛模型:
    抛：程序正常执行遇到异常时，生成该异常类的对象，并将其抛出，其后代码不再执行。
    抓：即异常的处理方式，try-catch-finally 或 throws。

二、try-catch-finally

    try{
        可能出现异常的代码
    }catch(异常类型1 变量1){
        处理方式1
    }catch(异常类型2 变量2){
        处理方式2
    }catch(异常类型3 变量3){
        处理方式3
    }
    ...
    finally{
        //一定会执行的代码
    }
说明：
    1.finally可选。
    2.try将可能出现异常的代码包装，生成异常类对象，与catch匹配。
    3.匹配成功，进行处理。处理完成后跳出try-catch。
    4.catch中异常类有继承关系时，子类在前，父类在后。
    5.常用异常对象处理方法：e.getMessage() 和  e.printStackTrace()
    6.try结构中变量为外部无效。

--------------------
 */
public class ExceptionTryCatch {

    @Test
    public void test1(){
        String str = "123";
//        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("异常处理前！");
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("异常处理后！");
    }
}
