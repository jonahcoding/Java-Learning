package com.shinrin.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "hello.txt";
        String destPath = "world.txt";
//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start));//618

    }
}
