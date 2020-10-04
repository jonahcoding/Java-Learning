package com.shinrin.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
----------------------------------------
File类（内存层面）：
    代表一个文件或文件目录（java.io包）。
    1.创建File类的实例（4种）：
    2.File方法（内存层面）：
        获取文件信息：
            public String getAbsoluteFile()：获取绝对路径
            public String getPath()：        获取路径
            public String getName()：        获取文件名
            public String getParent()：      获取上层文件路径
            public long length()：           获取文件长度
            public long lastModified()：     获取最后修改时间（ms级）
        获取文件目录：
            public String[] list()：         获取指定目录下的所有文件或文件目录的名称数组。
            public File[] listFiles()：      获取指定目录下的所有文件或文件目录的File数组。
        文件重命名（修改路径）：
            public boolean renameTo(File dest)：把文件重命名为指定的文件路径。
            注：要求原文件存在，目标文件不存在。
        判断方法：
            public boolean isDirectory():
            public boolean isFile()：
            public boolean exists()：
            public boolean canRead()：
            public boolean canWrite()：
            public boolean isHidden()：
        创建、删除：
            public boolean createNewFile()： 创建文件，存在则不创建返回false
            public boolean mkdir()：         创建文件夹，存在则不创建。上层目录不存在时不创建。
            public boolean mkdirs()：        上层目录不存在时一并创建。
            public boolean delete()：        删除文件（不进回收站）
    3.涉及磁盘文件读写，必须使用IO流完成
----------------------------------------
*/
public class FileTest {
    @Test
    public void test1(){
        //构造器(4种)：绝对路径与相对路径
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\Workspace\\hello.txt");
        File file3 = new File("E:\\Workspace", "hello");
        File file4 = new File(file3, "hello.txt");
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
        //
    }

    //File类的方法
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\Workspace\\HELLO\\hello.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        //目录必须存在，否则空指针异常
        File file1 = new File("E:\\Workspace\\Git");

        String[] list1 = file1.list();
        for (String s: list1) {
            System.out.println(s);
        }

        File file2 = new File("E:\\Workspace\\Git");

        String[] list2 = file2.list();
        for (String s: list2) {
            System.out.println(s);
        }
    }

    @Test
    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\Workspace\\HELLO\\HELLO.txt");
        boolean renameTo = file1.renameTo(file2);
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());//操作前先判断文件是否存在。
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    //文件的创建于删除
    @Test
    public void test6() throws IOException {
        //文件的创建、删除
        File file1 = new File("hello.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功！");
        }else {
            file1.delete();
            System.out.println("删除成功！");
        }
    }

    //文件目录的创建、删除
    @Test
    public void test7(){
        File file1 = new File("E:\\Workspace\\HELLO1");
        boolean mkdir1 = file1.mkdir();
        if (mkdir1){
            System.out.println("创建成功HELLO1");
        }

        File file2 = new File("E:\\Workspace1\\HELLO2");
        boolean mkdir2 = file2.mkdirs();
        if (mkdir2){
            System.out.println("创建成功HELLO2");
        }
    }
}
