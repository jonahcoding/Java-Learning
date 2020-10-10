package com.shinrin.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
public class TCPTest3 {

    //try-catch-finally处理异常
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("A.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }
        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("beauty.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");
        OutputStream os = socket.getOutputStream();
        os.write("文件已接收！".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}
