# JavaWEB

## 一、基本概念

### 1.1 前言

web开发：

- web，网页

  - 静态web
    - html，css
    - 数据始终不发生变化
  - 动态web
    - TB，每个网站
    - 数据始终会发生变化，不同用户不同时间
    - 技术栈：Servlet/JSP，ASP，PHP

  在Java中，动态web资源开发技术统称为JavaWEB。

### 1.2 web应用程序

web应用程序：可以提供浏览器访问的程序。

- 多个html可以被外界访问，对外界提供访问。
- 可访问页面或资源，存储在远端服务器上。
- URL
- 统一的web资源放在同一个文件夹下，web应用程序==>Tomcat服务器
- 一个web由多个部分组成（静态web，动态web）
  - html，css，js
  - jsp，servlet
  - Java程序
  - jar包
  - 配置文件（Properties）

web应用程序由服务器向外界提供访问。

### 1.3 静态web

![静态web](JavaWEB.assets/静态web.png)

- 静态web的缺点
  - 页面无法更新
    - 轮播图，点击特效：伪动态
    - JavaScript
    - VBScript
  - 无法与数据库交互（数据无法持久化，用户无法交互）

### 1.4 动态web

![动态web](JavaWEB.assets/动态web-1602518506399.png)

缺点：

- 动态web资源出错，需要重新编写后台，再次发布。
  - 停机维护。
- 优点
  - web页面可以动态更新
  - 可以与数据库交互（数据持久化：用户信息）

## 二、web服务器

### 2.1 web编程语言

ASP:

- 微软

- HTML中嵌入VB脚本，ASP+COM
- 页面杂乱，维护成本高

PHP：

- 开发速度快，功能强大，跨平台，代码简单
- 无法承载大访问量（局限）

JSP/Servlet：

- Sun公司主推的B/S（浏览器与服务器）架构
- 基于Java语言（较多开源组件）
- 可以承载三高问题
- 语法接近ASP，加强市场强度

### 2.2 web服务器

服务器：被动操作，处理用户请求与响应。

- IIS：微软，windows自带。

- Tomcat：Apache公司，运行JSP页面和Servlet。

### 2.3 Tomcat安装

- Java下没有jre文件夹：

  进入jdk目录

  输入bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre

- 配置JAVA_JRE环境变量
- 配置CATALINA_HOME环境变量（Tomcat路径）并写入Path

