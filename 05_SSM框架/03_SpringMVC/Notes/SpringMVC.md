# 一、MVC

## 1.1 MVC简介

**MVC是模型（Model）、视图（View）和控制器（Controller）的简写，是一种软件设计规范。**

- 将业务逻辑、数据、显示分离的方法来组织代码。
- MVC的主要作用是**降低了视图与业务逻辑间的双向耦合**。
- **MVC是一种架构模式**。

**Model（模型）** 

> 数据模型，提供要展示的数据，因此包含数据和行为，可以认为是领域模型或JavaBean组件（包含数据和行为），不过现在一般都分离开来：Value Object（数据Dao） 和 服务层（行为Service）。也就是模型提供了模型数据查询和模型数据的状态更新等功能，包括数据和业务。 

**View（视图）**

> 负责进行模型的展示，一般就是我们见到的用户界面，客户想看到的东西。

**Controller（控制器）**

> 接收用户请求，委托给模型进行处理（状态改变），处理完毕后把返回的模型数据返回给视图，由视图负责展示。也就是说控制器做了个调度员的工作。

**最典型的MVC就是JSP + servlet + javabean的模式：**

1. 用户发请求
2. Servlet接收请求数据，并调用对应的业务逻辑方法
3. 业务处理完毕，返回更新后的数据给servlet
4. servlet转向到JSP，由JSP来渲染页面
5. 响应给前端更新后的页面

**MVC职责分析：**

- Controller：控制器
  1. 获取表单数据
  2. 调用业务逻辑
  3. 转向指定页面

- Model：模型
  1. 业务逻辑
  2. 保存数据的状态

- View：视图
  1. 显示页面

![](SpringMVC.assets/640 (1).png)

## 1.2 MVC的发展

- Model1：模型+视图。

- Model2：模型+视图+控制。

Model2不仅提高了代码的复用率与项目的扩展性，且大大降低了项目的维护成本。Model 1模式的实现比较简单，适用于快速开发小规模项目，Model1中JSP页面身兼View和Controller两种角色，将控制逻辑和表现逻辑混杂在一起，从而导致代码的重用性非常低，增加了应用的扩展性和维护的难度。Model2消除了Model1的缺点。

## 1.3 回顾Servlet

1. 新建父工程，导入依赖：pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.shinrin</groupId>
    <artifactId>SpringMVC_PROJ</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>SpringMVC_01_Servlet</module>
    </modules>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.5.RELEASE</version>
        </dependency>
    </dependencies>

</project>
```

2. 创建Servlet子模块（添加Web app支持）
3. 导入servlet和jsp的依赖：pom.xml

```xml
  <dependencies>
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
  </dependencies>
```

4. 配置文件过滤：pom.xml

```xml
  <!-- 解决资源过滤问题 -->
  <build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>
```

5. 编写Servlet类，处理用户请求

```java
//实现Servlet接口
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得参数
        String method = req.getParameter("method");
        if (method.equals("add")){
            req.getSession().setAttribute("msg", "执行了add方法。");
        }
        if (method.equals("delete")){
            req.getSession().setAttribute("msg", "执行了delete方法。");
        }
        //业务逻辑
        //视图跳转
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
```

6. 编写Hello.jsp，在WEB-INF目录下创建jsp文件夹，新建hello.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shinrin</title>
</head>
<body>
${msg}
</body>
</html>
```

7. web.xml中注册Servlet

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
  <servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.shinrin.servlet.HelloServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/user</url-pattern>
  </servlet-mapping>

</web-app>
```

8. 配置Tomcat（http://localhost:8080/）
9. 测试
   - [http://localhost:8080/user?method=add](http://localhost:8080/user?method=add)
   - http://localhost:8080/user?method=delete

# 二、SpringMVC

## 2.1 SpringMVC简介

**Spring的功能**

1. 将url映射到java类或java类的方法 。
2. 封装用户提交的数据 。
3. 处理请求、调用相关的业务处理、封装响应数据 。
4. 将响应的数据进行渲染 . jsp / html 等表示层数据 。

> 常见的服务器端MVC框架有：Struts、Spring MVC、ASP.NET MVC、Zend、Framework、JSF。
>
> 常见前端MVC框架：vue、angularjs、react、backbone。
>
> 由MVC演化出了另外一些模式如：MVP、MVVM 等等

**Spring MVC的特点**

1. 轻量级，简单易学
2. 高效 , 基于请求响应的MVC框架
3. 与Spring兼容性好，无缝结合
4. 约定优于配置
5. 功能强大：RESTful、数据验证、格式化、本地化、主题等
6. 简洁灵活

> Spring的web框架围绕**DispatcherServlet** [ 调度Servlet ] 设计。DispatcherServlet的作用是将请求分发到不同的处理器。从Spring 2.5开始，使用Java 5或者以上版本的用户可以采用基于注解形式进行开发。

## 2.2 中心控制器

Spring MVC框架以请求为驱动 , 围绕一个中心Servlet分派请求及提供其他功能，DispatcherServlet是一个实际的Servlet (它继承自HttpServlet 基类)。

![](SpringMVC.assets/u=2655822046,4090403229&fm=15&gp=0.jpg)

**SpringMVC的原理**

![](SpringMVC.assets/未命名文件 (1).png)

流程说明：

（1）客户端（浏览器）发送请求，直接请求到DispatcherServlet。

（2）DispatcherServlet根据请求信息调用HandlerMapping，解析请求对应的Handler。

（3）解析到对应的Handler后，开始由HandlerAdapter适配器处理。

（4）HandlerAdapter会根据Handler来调用真正的处理器来处理请求，并处理相应的业务逻辑。

（5）处理器处理完业务后，会返回一个ModelAndView对象，Model是返回的数据对象，View是逻辑上的View。

（6）ViewResolver会根据逻辑View查找实际的View。

（7）DispaterServlet把返回的Model（数据对象）传递给View。

（8）通过View将数据对象返回给请求者（浏览器）

























