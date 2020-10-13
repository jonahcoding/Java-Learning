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

### 2.3 Tomcat详解

#### 2.3.1 Windows平台安装与启动

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

#### 2.3.2 Linux平台安装与启动

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

#### 2.3.3 Tomcat配置文件

E:\App\Tomcat\apache-tomcat-8.5.59\conf\server.xml

- 配置端口：Connector（默认为8080）

  - tomcat默认端口号：8080
  - maysql：3306
  - http：80
  - https：443

  ```xml
  <Connector port="8080" protocol="HTTP/1.1"
  		connectionTimeout="20000"
  		redirectPort="8443" />
  ```

- 配置主机名称：Host项（默认localhost）和本机hosts文件。

  - 默认主机名：localhost==>127.0.0.1
  - 默认网站应用存放位置：webapps

  ```xml
  <Host name="localhost"  appBase="webapps"
  		unpackWARs="true" autoDeploy="true">
  ```

**【重点】**

网站如何访问？

1. 输入域名，回车
2. 检查本机hosts文件是否存在该域名映射
   1. 存在：返回域名对应的IP，访问该IP
   2. 不存在：去DNS服务器查找，存在则返回IP，不存在则返回未找到。

### 2.4 web发布

- 网站存放在服务器（Tomcat）中指定的web应用的文件夹（webapps）下，即可访问。

网站结构：

```
--webapps:Tomcat服务器的web目录
	-ROOT
	-JonahCoding：网站的目录名
		-WEB-INF
			-classes：java程序
			-lib：web应用依赖的jar包
			-web.xml：网站配置文件
		-index.html：默认首页
		-static
			-css
				-style.css
			-js
			-img
		-......		
```

## 三、Http

### 3.1 HTTP

HTTP（超文本传输协议）是一个简单的请求-响应协议，通常运行在TCP上。

- 文本：html，字符串，...
- 超文本：图片，音乐，视频，定位，地图...
- 端口：80

Https：安全的

- 端口443

### 3.2 Http的发展（面试：区别）

- http1.0
  - HTTP/1.0：客户端与服务端连接后，只能获取一个web资源，即会断开连接。
- http2.0
  - HTTP/1.1：客户端与服务端连接后，可以获取多个资源。

### 3.3 Http请求与响应

#### 3.3.1 请求

- 客户端==>发送请求（Request）==>服务器

```
Request URL: https://www.baidu.com/		请求地址
Request Method: GET		get方法/post方法
Status Code: 200 OK		状态码：200
Remote（远程） Address: 36.152.44.95:443（地址：端口）
```

```
Accept:text/html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9		语言
Cache-Control: max-age=0
Connection: keep-alive
```

1. **请求行**
   - 请求行中的请求方式：GET
   - 请求方式：**Get，Post**，HEAD，DELETE，PUT，TRACT
     - get：请求可携带参数少，大小有限制，在URL地址栏显示数据内容、不安全但高效。
     - post：请求参数无限制，大小无限制，URL不限制数据内容，安全但低效。
2. **消息头**

```
Accept: 告知浏览器，所支持的数据类型
Accept-Encoding: 支持的编码格式GBK/UTF-8
Accept-Language: 语言环境
Cache-Control: 缓存控制
Connection: 告知浏览器，请求完成断开或保持连接
HOST: 主机....../.
```

#### 3.3.2 响应

- 客户端<==发送响应（Reponse）<==服务器

```
Cache-Control: private		缓存控制
Connection: keep-alive		连接（http1.1）
Content-Encoding: gzip		编码
Content-Type: text/html;charset=utf-8	类型
```

1. **响应体**

   ```
   Accept: 告知浏览器，所支持的数据类型
   Accept-Encoding: 支持的编码格式GBK/UTF-8
   Accept-Language: 语言环境
   Cache-Control: 缓存控制
   Connection: 告知浏览器，请求完成断开或保持连接
   HOST: 主机....../.
   Refresh: 告知客户端刷新间隔
   Location: 使网页重新定位
   ```

2. **响应状态码**

   - 200：请求响应成功	200
   - 3xx：请求重定向
     - 重定向：
       - 4xx：找不到资源	404
   - 5xx：服务器diamante错误  500    502(网关错误)

【重点】

## 四、Maven

作用：自动导入配置jar包。

### 4.1 Maven项目架构管理工具

- Maven核心思想：约定大于配置
  - 不违反约束（规则、规范）

### 4.2 安装与配置

- 下载：http://maven.apache.org/download.cgi
  - apache-maven-3.6.3-bin.zip（解压）
  - apache-maven-3.6.3-src.zip

- 配置环境变量：
  - 新建MAVEN_HOME：E:\App\Maven\apache-maven-3.6.3
  - Path：%MAVEN_HOME%\bin
  - 新建M2_HOME：E:\App\Maven\apache-maven-3.6.3\bin

- 测试：`mvn -version`

### 4.3 配置镜像（阿里云）

- 作用：加速下载
- 文件：E:\App\Maven\apache-maven-3.6.3\conf\settings.xml

```xml
<mirrors>
      <mirror>
         <id>nexus-aliyun</id>
         <mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
         <name>Nexus aliyun</name>
         <url>http://maven.aliyun.com/nexus/content/groups/public</url>
      </mirror> 
</mirrors>
```

### 4.4 本地仓库

- Maven目录下新建文件夹作为本地仓库

```xml
<localRepository>E:\App\Maven\apache-maven-3.6.3\maven-repo</localRepository>
```

### 4.5 IDEA中使用Maven

#### 4.5.1 创建Maven项目：

- 勾选Create from archetype以使用模板（可选）`maven-archetype-webapp`
- 项目名称：
- 项目路径：
- 选择Maven版本：

- Groupid：com.shinrin

- Artifactid：javaweb-01-maven（项目名）

- Verson：1.0-SNAPSHOT

- 配置文件：

- 仓库：

#### 4.5.2 Maven初始化

- 初次打开项目，等待初始化完成（从镜像源下载文件至本地仓库）

#### 4.5.3 IDEA中Maven设置

settings-->Build==>Maven==>Importing==>Automatically download==>Sources（可选）

>创建带模板的Maven项目：`maven-archetype-webapp`  	web应用
>
>默认不存在java源码目录和resources资源目录，新建并Mark Directory as ...（标记文件夹）

模块管理：Project Structure ==> Modules

### 4.6 IDEA中配置Tomcat

Run/Debug Configuretions==》添加配置==》Tomcat（local本地）

重要配置：

1. Name
2. Application server：选择已安装的Tomcat
3. 选择浏览器
4. 选择JDK
5. HTTP端口：8080

警告修复：

- Fix（Deployment选项）选择当前项目
- Application context：不写默认为localhost:8080，填写shinrin则访问localhost:8080/shinrin
  - Application context为**虚拟路径映射**（IDEA默认使用/javaweb_01_maven_war填充）。

### 4.7 Maven侧边栏

- Lifecycle：maven的命令行操作
- Plugins：插件
- Dependencies：jar包，项目依赖

### 4.8 pom.xml文件

pom.xml：Maven的核心配置文件

模板生成项目的pom.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
  <!--Maven版本和头文件-->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <!--配置的GAV-->
  <groupId>com.shinrin</groupId>
  <artifactId>javaweb-01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  <!--Packaging：项目打包方式
  jar：java应用
  war：web应用
  -->
  <packaging>war</packaging>
  <!--项目名称-->
  <name>javaweb-01-maven Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>
  <!--配置-->
  <properties>
    <!--项目的默认构建编码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--编码版本-->
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
  <!--项目依赖-->
  <dependencies>
  <!--具体依赖的jar包-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <!--项目构建的插件-->
  <build>
    <finalName>javaweb-01-maven</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

项目为空的pom.xml：

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.9.RELEASE</version>
    </dependency>
</dependencies>
```

从https://mvnrepository.com/获取目标jar包的dependency粘贴到pom.xml，刷新即可导入。

> **Maven资源导出问题**（如规定java目录不能导出xml等文件）
>
> **原因：约束大于配置**
>
> **解决方案**：https://www.cnblogs.com/pixy/p/4798089.html

```xml
    <!--解决资源导出问题-->
    <!--忽略对resources和java目录下的xml和properties文件过滤-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <excludes>
                    <exclude>**/*.properties</exclude>
                    <exclude>**/*.xml</exclude>
                </excludes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```

### 4.9 常见问题

