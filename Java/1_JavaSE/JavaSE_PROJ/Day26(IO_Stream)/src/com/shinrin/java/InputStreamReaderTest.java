package com.shinrin.java;

/*
----------------------------------------
转换流：（属于字符流）
    InputStreamReader：将一个字节的输入流转换为字符的输入流
    OutputStreamWriter：将一个字符的输出流转换为字节的输出流

提供字节流与字符流的转换：

解码：字节、字节数组->字符数组、字符串
编码：字符数组、字符串->字节、字节数组

字符集：
----------------------------------------
*/

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    @Test
    public void test1(){
        InputStreamReader isr = null;
        try{
            FileInputStream fis = new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis,"gbk");
            char[] cbuff = new char[20];
            int len;
            while ((len = isr.read(cbuff)) != -1){
                String str = new String(cbuff, 0, len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (isr != null){
                try {
                    isr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //综合使用InputStreamReader和OutputStreamWriter
    @Test
    public void test2() throws Exception {
        //1.造文件、造流
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }
        //3.关闭资源
        isr.close();
        osw.close();
    }
}
