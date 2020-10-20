package com.shinrin.java;
/*
----------------------------------------
流：
一、概述
    IO：数据传输（读写文件、网络通信）。
    从内存角度：输入（从文件读数据到内存）、输出（从内存写数据到文件）。
二、分类
    1.按数据单位：
        字节流：8bit（InputStream\OutputStream）
        字符流：16bit（Reader\Writer）
    2.按流向：
        输入流：
        输出流：
    3.按流的角色：
        节点流：直接操作文件
        处理流：
三、流的体系结构
    抽象基类          节点流（文件流）         缓冲流（处理流的一种）
    InputStream      FileInputStream       BufferedInputStream
    OutputStream     FileOutputStream      BufferedOutputStream
    Reader           FileReader            BufferedReader
    Writer           FileWriter            BufferedWriter
四、重点
    抽象基类、访问文件、缓冲流、转换流、对象流
五、转换流（属于字符流）
    InputStreamReader：将一个字节的输入流转换为字符的输入流
    OutputStreamWriter：将一个字符的输出流转换为字节的输出流
六、标准输入输出流：
    System.in:  InputStream
    System.out: PrintStream
    重定向：(更改默认设备)
        setIn(InputStream in)
        setIn(PrintStream out)
七、 打印流：
    PrintStream 和 PrintWriter
    提供了一系列重载的print() 和 println()
八、 数据流
    DataInputStream 和 DataOutputStream
    作用：用于读取或写出基本数据类型的变量或字符串
九、对象流
    1.ObjectInputStream 和 ObjectOutputStream
    2.作用：用于存储和读取基本数据类型数据或对象的处理流（持久化）。
    3.要求对象必须可序列化（所属类及其属性必须可序列化）
        a.实现接口：Serializable
        b.提供全局常量：serialVersionUID
        c.内部属性可序列化（基本类型默认可序列化）
        d.ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
    4.序列化机制：
        把内存中的Java对象转换成平台无关的二进制流从而允许持久地保存在磁盘上，
        或通过网络将这种二进制流传输到另一个网络节点。
        当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
十、随机存取文件流（RandomAccessFile）
    1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
    2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
    3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。否则覆盖。
    4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
十一、NIO
    1.jdk 7.0 时，引入了 Path、Paths、Files三个类。
    2.此三个类声明在：java.nio.file包下。
    3.Path可以看做是java.io.File类的升级版本。也可以表示文件或文件目录，与平台无关
    4.如何实例化Path:使用Paths.
        static Path get(String first, String … more) : 用于将多个字符串串连成路径
        static Path get(URI uri): 返回指定uri对应的Path路径
----------------------------------------
*/

import org.junit.Test;

import java.io.*;

public class FileReadWriterTest {
    //从硬盘文件读到内存
    //1.read：读取一个字符，返回值int型，使用时需要转char
    //2.异常处理：保证流一定关闭。
    //3.读入文件：必须存在，否则FileNotFoundException
    @Test
    public void testFileRead() {//throw异常无法关闭流，使用try—catch代替
        FileReader fr = null;
        try{
            //1.实例化File对象，指明要操作的文件。
            File file = new File("hello.txt");//当前Module
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据读入
            int data;//返回读入的一个字符，到达文件末尾时返回-1。
            while ((data  = fr.read()) != -1){
                System.out.println((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.流的关闭（手动关闭资源）
            if (fr != null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //从硬盘读入到内存（升级）
    @Test
    public void testFileReader1() throws IOException {
        FileReader fr = null;
        try{
            File file = new File("hello.txt");//当前Module
            fr = new FileReader(file);
            char[] cbuff = new char[5];
            int len;
            while ((len = fr.read(cbuff)) != -1) {
                //方式一
//                for (int i = 0; i < len; i++) {       //读入多少取出多少
//                    System.out.print(cbuff[i]);
//                }
                //方式二
                String str = new String(cbuff, 0, len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //从硬盘写出到文件
    //1.文件不存在时，自动创建。
    //2.选择构造器指定覆盖或末尾追加。
    //      FileWriter(file)\FileWriter(file,false)：覆盖
    //      FileWriter(file,true)：追加
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try{
            File file = new File("hello.txt");//当前Module
//        fw = new FileWriter(file);//覆盖原文件数据
            fw = new FileWriter(file, true);//末尾追加
            fw.write(" Have a nice day!");//覆盖原文件数据
            fw.write(" Thanks!");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw != null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读写，实现拷贝
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try{
            //1.创建File对象
            File src = new File("hello.txt");
            File dest = new File("world.txt");
            //2.创建流对象
            fr = new FileReader(src);
            fw = new FileWriter(dest);

            //3.数据的读入和写出操作
            char[] cbuff = new char[5];
            int len;    //记录每次读到的字符个数。
            while ((len = fr.read(cbuff)) != -1){
                fw.write(cbuff,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭流资源
            try{
                if (fw != null){
                    fw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try{
                if (fr != null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
