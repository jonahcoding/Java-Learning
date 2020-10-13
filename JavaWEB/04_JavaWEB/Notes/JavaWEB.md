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

#### 2.3.1 Windows平台安装：

版本环境

- Java版本：1.8.0_261

- Tomcat版本：8.5.59

安装步骤：

1. 配置JAVA_JRE环境变量：
2. 配置CATALINA_HOME环境变量（Tomcat路径）
3. 双击startup.bat ，等待启动成功。
4. 浏览器键入localhost:8080测试。

> 可能存在的问题：Java下没有jre文件夹

解决方案：

1. cmd进入jdk目录
2. bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre

#### 2.3.2 Linux平台安装

打开centos7网络：

1. `vim /etc/sysconfig/network-scripts/ifcfg-ens33`修改 `ONBOOT=yes`
2. `service network restart`
3. 获取IP，远程登录。

安装Java：

1. 解压Jdk压缩包并移动至/usr/loacl/java/目录下
2. 修改环境变量：`vim /etc/profile`

```
export JAVA_HOME=/usr/local/java/jdk1.8.0_261
export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin
```

3. 配置生效：`source /etc/profile`
4. 测试：`java -version`

安装Tomcat：https://mirrors.cnnic.cn/apache/tomcat/

1. 解压Tomcat压缩包并移动至/usr/loacl/tomcat/目录下

2. 新建快捷启动方式：

   ```
   cp /usr/local/tomcat/apache-tomcat-8.5.59/bin/catalina.sh /etc/init.d/tomcat
   ```

3. 修改脚本权限（所有人）：` chmod 755 /etc/init.d/tomcat `

4. 配置脚本：`vim /etc/init.d/tomcat`

   ```
   #chkconfig: 2345 10 90
   #description: tomcat service 
   export JAVA_HOME=/usr/local/java/jdk1.8.0_261
   export CATALINA_HOME=/usr/local/tomcat/apache-tomcat-8.5.59
   ```

5. 设置Tomcat开机启动：` chkconfig tomcat on `

6. 启动\关闭Tomcat：` service tomcat start\stop `

7. 开放8080端口（否则无法访问）： [](https://blog.csdn.net/qq_36473199/article/details/87227661)

8. 测试：服务器ip:8080

