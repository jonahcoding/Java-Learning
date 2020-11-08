SSM整合

# 一、开发环境：

| 工具   | 版本   |
| ------ | ------ |
| IDEA   |        |
| MySQL  | 8.0.21 |
| Tomcat | 9.0.39 |
| Maven  | 3.6.3  |

# 二、数据库环境：

```sql
CREATE DATABASE `ssmbuild`;

USE `ssmbuild`;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books`(
    `bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
    `bookName` VARCHAR(100) NOT NULL COMMENT '书名',
    `bookCounts` INT(10) NOT NULL COMMENT '数量',
    `details` VARCHAR(200) NOT NULL COMMENT '描述',
    KEY `bookID` (`bookID`)
)ENGINE = INNODB DEFAULT CHARSET = utf8;

INSERT INTO `books`(`bookID`, `bookName`, `bookCounts`, `details`)VALUES
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',5,'从进门到进牢');
```

# 三、基本环境搭建：

1. 新建Maven项目SSM_PROJ，添加web支持。

2. 导入依赖（junit、数据库驱动、servlet、jsp、mybatis、mybatis-spring、spring）

   ```xml
   <dependencies>
      <!--Junit-->
      <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.12</version>
      </dependency>
      <!--数据库驱动-->
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>5.1.47</version>
      </dependency>
      <!-- 数据库连接池 -->
      <dependency>
          <groupId>com.mchange</groupId>
          <artifactId>c3p0</artifactId>
          <version>0.9.5.2</version>
      </dependency>
   
      <!--Servlet - JSP -->
      <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>servlet-api</artifactId>
          <version>2.5</version>
      </dependency>
      <dependency>
          <groupId>javax.servlet.jsp</groupId>
          <artifactId>jsp-api</artifactId>
          <version>2.2</version>
      </dependency>
      <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>jstl</artifactId>
          <version>1.2</version>
      </dependency>
   
      <!--Mybatis-->
      <dependency>
          <groupId>org.mybatis</groupId>
          <artifactId>mybatis</artifactId>
          <version>3.5.2</version>
      </dependency>
      <dependency>
          <groupId>org.mybatis</groupId>
          <artifactId>mybatis-spring</artifactId>
          <version>2.0.2</version>
      </dependency>
   
      <!--Spring-->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc</artifactId>
          <version>5.1.9.RELEASE</version>
      </dependency>
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-jdbc</artifactId>
          <version>5.1.9.RELEASE</version>
      </dependency>
   </dependencies>
   ```

3. 静态资源导出

   ```xml
   <build>
      <resources>
          <resource>
              <directory>src/main/java</directory>
              <includes>
                  <include>**/*.properties</include>
                  <include>**/*.xml</include>
              </includes>
              <filtering>false</filtering>
          </resource>
          <resource>
              <directory>src/main/resources</directory>
              <includes>
                  <include>**/*.properties</include>
                  <include>**/*.xml</include>
              </includes>
              <filtering>false</filtering>
          </resource>
      </resources>
   </build>
   ```

4. 建立基本结构

   - com.shinrin.pojo
   - com.shinrin.dao
   - com.shinrin.service
   - com.shinrin.controller

5. 配置框架

   - mybatis-config.xml

     ```xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE configuration
            PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-config.dtd">
     <configuration>
     
     </configuration>
     ```

   - applicationContext.xml

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans 
            http://www.springframework.org/schema/beans/spring-beans.xsd">
     
     </beans>
     ```

# 四、MyBatis层编写

1. 数据库配置文件：database.properties

   ```properties
   jdbc.driver=com.mysql.cj.jdbc.Driver
   jdbc.url=jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&Unicode=true&characterEncoding=utf8&serverTimezone=UTC
   jdbc.username=root
   jdbc.password=1704
   ```

2. IDEA关联数据库

3. 编写MyBatis的核心配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
   
       <typeAliases>
           <package name="com.shinrin.pojo"/>
       </typeAliases>
       <mappers>
           <mapper resource="com/shinrin/dao/BookMapper.xml"/>
       </mappers>
       
   </configuration>
   ```

   

