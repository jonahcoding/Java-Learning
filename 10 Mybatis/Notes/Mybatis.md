一、JDBC回顾

1.1 JDBC编程步骤：

1. 加载数据库驱动
2. 创建并获取数据库连接（connection）
3. 创建JDBC statement对象
4. 设置SQL语句
5. 设置SQL语句参数（通过preparedStatement）
6. 通过statement执行SQL并获取结果（使用resultSet接收）
7. 对SQL执行结果进行解析操作
8. 释放资源（preparedStatement、resultSet、connection）

1.2 问题总结：

1. 数据库连接使用时创建，不用时释放，频繁操作浪费资源，影响性能。
   - 优化：使用数据库连接池管理连接。
2. SQL语句硬编码在Java代码中，修改SQL语句后需要重新编译Java代码，不利于系统维护。
   - 优化：将SQL语句放置在xml配置文件中。
3. preparedStatement设置参数，对占位符位置和参数值硬编码在Java代码中，不易维护。
   - 优化：SQL语句、占位符及参数全部配置在xml中。
4. 从resultSet中遍历结果集数据时，存在硬编码，将获取表的字段进行硬编码，不易维护。
   - 优化：查询结果集自动映射为Java对象。

1.3 JDBC代码如下：

```java
package com.shinrin.mybatis.jdbc;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的Statement（防止SQL注入攻击，提高数据库性能）
        PreparedStatement preparedStatement = null;
        //查询结果集
        ResultSet resultSet = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库连接
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis001?characterEncoding=utf-8", "root", "123");
            //定义sql语句（?表示占位符）
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，参数1为sql语句中参数的序号（从1开始），参数2为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询（返回结果集）
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
```

二、MyBatis概述

MyBatis介绍：

- mybatis是一个持久层的框架，是apache下的顶级项目（开源）。

- mybatis托管到goolecode下，再后来托管到[github](https://github.com/mybatis/mybatis-3/releases)下。
- mybatis提供映射，可自由灵活生成（半自动化）满足需要sql语句。
  - **输入映射**：对preparedStatement中的输入参数自动进行映射。
  - **输出映射**：将查询结果集灵活映射成java对象。

