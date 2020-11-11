- 创建用户： adduser username

- 设置密码： passwd username

- 授权sudo权限：vim /etc/sudoers

  ```
  文件内容改变如下：
  root ALL=(ALL) ALL 已有行
  username ALL=(ALL) ALL 新增行
  ```



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

