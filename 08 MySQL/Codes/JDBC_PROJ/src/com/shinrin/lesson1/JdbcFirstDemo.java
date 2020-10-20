package com.shinrin.lesson1;
/**
 * Jdbc步骤分析
 */

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库DriverManager
        //参数：支持中文，utf8编码，安全连接，（时区，否则报错）
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        //3.执行SQL的对象Statement
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);  //链表形式
        //4.获取返回的结果集
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }
        //5.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}