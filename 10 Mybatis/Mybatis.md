环境设置：

- Mybatis：9.28

- JDK:1.8

- MySQL：5.7

- Maven：3.6.1
- IDEA

回顾：

- JDBC
- MySQL
- Java基础
- Maven
- Junit

# 一、MyBatis

## 1.1 MyBatis简介

- MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。

- MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。

- MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

- 原为Apache开源项目iBatis，后改名MyBatis迁移到google code及github。

中文文档：https://mybatis.org/mybatis-3/zh/index.html

## 1.2 获取MyBatis

- github：https://github.com/mybatis/mybatis-3

- maven仓库：https://mvnrepository.com/artifact/org.mybatis/mybatis/3.5.2

  ```xml
  <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
  <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.2</version>
  </dependency>
  ```

## 1.3 持久化

数据持久化

- 持久化是将程序的数据在持久状态和瞬时状态转换的过程。
- 内存特点：**断电即失**
- 数据库（JDBC）、IO文件持久化。

为什么需要持久化？

- 不容丢失的对象。
- 内存昂贵。

## 1.4 持久层

Dao层、Service层、Controller层...

- 完成持久化工作的代码
- 层界限明显。

## 1.5 为什么需要MyBatis

简化JDBC操作。

特点：

- 简单易学
- 灵活： sql在xml文件中，便于统一管理和优化。
- 解除sql与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离。
- 提供映射标签，支持对象与数据库的orm字段关系映射
- 提供对象关系映射标签，支持对象关系组建维护
- 提供xml标签，支持编写动态sql。 

# 二、测试MyBatis

思路：搭建环境==>导入MyBatis==>编写代码==>测试

## 2.1 搭建环境

1. 数据库建表

```mysql
CREATE DATABASE `mybatis`;

USE `mybatis`;

CREATE TABLE `user`(
 `id` INT(20) NOT NULL PRIMARY KEY,
 `name` VARCHAR(30) DEFAULT NULL,
 `pwd` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`id`,`name`,`pwd`) VALUES
(1,'Teemo','123456'),
(2,'YaSuo','123456'),
(3,'Lux','123890')
```

2. 新建项目

   - 新建普通Maven项目（MyBatis-Study）

   - 删除src目录

   - 导入依赖：mysql驱动、mybatis、junit

     ```xml
         <!--导入依赖-->
         <dependencies>
         <!--mysql驱动-->
             <dependency>
                 <groupId>mysql</groupId>
                 <artifactId>mysql-connector-java</artifactId>
                 <version>5.1.47</version>
             </dependency>
         <!--mybatis-->
             <dependency>
                 <groupId>org.mybatis</groupId>
                 <artifactId>mybatis</artifactId>
                 <version>3.5.2</version>
             </dependency>
         <!--junit-->
             <dependency>
                 <groupId>junit</groupId>
                 <artifactId>junit</artifactId>
                 <version>4.12</version>
                 <scope>test</scope>
             </dependency>
         </dependencies>
     ```

## 2.2 新建模块

模块名：mybatis-01

- 核心配置文件：src\main\resources\mybatis-config.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE configuration
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-config.dtd">
  <configuration>
      <environments default="development">
          <environment id="development">
              <transactionManager type="JDBC"/>
              <dataSource type="POOLED">
                  <property name="driver" value="com.mysql.jdbc.Driver"/>
                  <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                  <property name="username" value="root"/>
                  <property name="password" value="123456"/>
              </dataSource>
          </environment>
      </environments>
  
  </configuration>
  ```

- 编写MyBatis工具类：src\main\java\com\shinrin\utils\MyBatisUtils.java

  ```java
  //SqlSessionFactory ==>  SqlSession
  public class MyBatisUtils {
      private static SqlSessionFactory sqlSessionFactory;
  
      static {
          try {
              //一、获取SqlSessionFactory对象
              String resource = "mybatis-config.xml";
              InputStream inputStream = Resources.getResourceAsStream(resource);
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          } catch (IOException e){
              e.printStackTrace();
          }
      }
      //二、通过获取SqlSessionFactory对象获取SqlSession实例
      //SqlSession包含了面向数据库执行SQL命令所需的方法。
      public static SqlSession getSqlSession(){
          return sqlSessionFactory.openSession();
      }
  }
  ```

## 2.3 编写代码

- 实体类：src\main\java\com\shinrin\pojo\User.java

  ```JAVA
  package com.shinrin.pojo;
  
  public class User {
      private int id;
      private String name;
      private String pwd;
  
      public User(){
  
      }
  
      public User(int id, String name, String pwd){
          this.id = id;
          this.name = name;
          this.pwd = pwd;
      }
  
      public int getId(){
          return id;
      }
  
      public void setId(int id){
          this.id = id;
      }
  
      public String getName(){
          return this.name;
      }
  
      public void setName(String name){
          this.name = name;
      }
  
      public String getPwd(){
          return this.pwd;
      }
  
      public void setPwd(String pwd){
          this.pwd = pwd;
      }
  
  }
  ```

- Dao接口：src\main\java\com\shinrin\pojo\User.java

  ```java
  public interface UserDao {
      public List<User> getUserList();
  }
  ```

- 接口实现（Mapper配置文件）：src\main\java\com\shinrin\dao\UserMapper.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <!--namespace=绑定一个对应的Dao/Mapper接口-->
  <mapper namespace="com.shinrin.dao.UserDao">
      <!--select查询语句-->
      <select id="getUserList" resultType="com.shinrin.pojo.User">
          select * from mybatis.user
      </select>
  
  </mapper>
  ```

## 2.4 测试



