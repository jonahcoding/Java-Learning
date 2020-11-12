## Linux新增用户

- 创建用户： adduser username

- 设置密码： passwd username

- 授权sudo权限：vim /etc/sudoers

  ```
  文件内容改变如下：
  root ALL=(ALL) ALL 已有行
  username ALL=(ALL) ALL 新增行
  ```



## Java安装

检查是否安装OpenJDK，有则卸载：

```
rpm -e --nodeps `rpm -qa | grep java`
```

安装jdk：

```
tar zxvf jdk-8u271-linux-x64.tar.gz
mkdir /usr/local/java
mv jdk1.8.0_271/ /usr/local/java
```

修改配置文件：

```
# java jdk1.8.0_271
JAVA_HOME=/usr/local/java/jdk1.8.0_271
CLASSPATH=%JAVA_HOME%/lib:%JAVA_HOME%/jre/lib
PATH=$PATH:$JAVA_HOME/bin:$JAVA_HOME/jre/bin
export PATH CLASSPATH JAVA_PATH
```

配置生效：

```
source /etc/profile
```



## MySQL安装

检查是否安装OpenJDK，有则卸载：

```
rpm -e --nodeps `rpm -qa | grep mysql`
```

### 下载

下载地址：https://dev.mysql.com/downloads/mysql/

版本选择：8.0.21 Linux - Generic（glibc 2.12）（x86，43-bit）

### 安装

1. xShell拷贝到服务器，并解压

```
tar -vxJf mysql-8.0.21-linux-glibc2.12-x86_64.tar.xz
```

2. 解压后的MySQL目录拷贝到指定路径下

```
mv mysql-8.0.21-linux-glibc2.12-x86_64 /usr/local/mysql/mysql-8.0.21
```

3. 为MySQL添加用户组和用户

```
# 创建mysql用户组
groupadd mysql
# 创建mysql用户并添加到mysql用户组
useradd -r -g mysql mysql
```

4. MySQL文件夹中创建data、log目录用来存放数据和日志

```
cd /usr/local/mysql/mysql-8.0.21
mkdir data
mkdir log
```

5. 更改MySQL文件夹所有者为mysql用户/组

```
chown -R mysql.mysql /usr/local/mysql/mysql-8.0.21
```

6. 新建/etc/my.cnf配置文件

```
[mysqld]
 
#默认存储引擎InnoDB 
default-storage-engine=InnoDB 
 
#用户
user = mysql
 
#监听端口　　
port = 3306
 
#socket通信设置
socket=/tmp/mysql.sock
 
#mysql的安装目录 
basedir=/usr/local/mysql/mysql-8.0.21
 
#数据文件位置
datadir=/usr/local/mysql/mysql-8.0.21/data
 
#允许最大连接数 
max_connections=512
 
#等待关闭连接时间
wait_timeout=600
 
#服务端字符集
character-set-server=utf8mb4
 
#错误日志
log-error=/usr/local/mysql/mysql-8.0.21/log/error.log
```

7. 初始化（无密码）

```
/usr/local/mysql/mysql-8.0.21/bin/mysqld --initialize-insecure
```

### 设置开机启动

1. 复制脚本到资源目录

```
cp -a /usr/local/mysql/mysql-8.0.21/support-files/mysql.server /etc/rc.d/init.d/mysqld
```

2. 赋予可执行权限

```
chmod +x /etc/rc.d/init.d/mysqld
```

3. 添加为服务

```
chkconfig --add mysqld
```

4.  查看系统服务列表中是否有mysqld服务 

```
chkconfig --list
# 如无，则执行：chkconfig --level 345 mysqld on
```

5. 启动MySQL

```
service mysqld start
```

### 配置环境变量

1. 打开配置文件

```
vi /etc/profile
```

2. 配置文件末尾添加环境MySQL变量

```
export PATH=$PATH:/usr/local/mysql/mysql-8.0.21/bin
```

3. 配置生效

```
source /etc/profile
```

4. 测试

```
mysql
```

### 登录MySQL

1. 登录数据库

```
mysql -u root -p
# 密码为空
```

2. 初始化root密码

```
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.01 sec)
```

3. 开启数据库远程连接

```
mysql> CREATE USER 'root'@'%' IDENTIFIED BY 'password';
Query OK, 0 rows affected (2.44 sec)
 
mysql> GRANT ALL ON *.* TO 'root'@'%'; 
Query OK, 0 rows affected (0.00 sec)
 
mysql> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.00 sec)
```

4. Navicat / DataGrip测试连接（阿里云服务器需要配置安全组规则3306）































