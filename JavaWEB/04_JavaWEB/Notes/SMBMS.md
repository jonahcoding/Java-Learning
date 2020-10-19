# 超市订单管理系统（Servlet）

## 一、前期准备

### 1.1 系统架构

![](SMBMS.assets/SMBMS架构.png)

### 1.2 数据库

数据库：smbms（超市管理系统）

```mysql
CREATE DATABASE `smbms`;
USE `smbms`;
```

- 表：
  - smbms_address（配送地址）
  - smbms_bill（订单）
  - smbms_provider（供应商）
  - smbms_role（管理员）
  - smbms_user（用户）

### 1.3 项目搭建

1. 新建Maven项目（web模板），项目名：smbms-web

2. 配置Tomcat（访问地址：http://localhost:8080/smbms/）

3. 测试项目是否可以运行

4. 导入包：jsp、servlet、mysql驱动、jstl、standard

5. 创建项目包结构：（路径：java/com/shinrin/）dao、filter、pojo、service、servlet、util

6. 编写实体类：（路径：java/com/shinrin/pojo/）Bill、Provider、Role、User

   - ORM映射：表-类映射

7. 编写公共基础类

   - 数据库配置文件（文件：resources/db.properties）

     ```properties
     driver=com.mysql.jdbc.Driver
     url=jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8
     username=root
     password=123456
     ```

   - 数据库操作类（路径：java/com/shinrin/dao/BaseDao.java）

   - 编写字符编码过滤器（路径：java/com/shinrin/filter/CharacterEncodingFilter.java）

8. 导入静态资源

   - （路径：webapp/）calendar、css、images、js文件夹。

