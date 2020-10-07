# 一、MySQL

## 1.1 数据库概述

**1.定义**

用于存储和管理数据的仓库（文件系统）。

**2.特点**

1. 持久化存储数据。
2. 方便存储和管理数据。
3. 使用了统一的方式操作数据库 – SQL（关系型数据库通用）

**3.数据的存储方式**

1. 内存：高效，临时（非永久保存）。
2. 文件：数据操作复杂，永久保存。
3. 数据库：永久保存，操作效率高，边界管理。

## 1.2 MySQL目录结构

​	数据库（文件夹）-->表（文件）-->数据（文件中的数据）
​	数据库管理程序（DBMS）：管理多个数据库（表-->记录）

## 1.3 SQL

**1.定义**

​	Structured Query Language：结构化查询语言
​	定义了操作所有关系型数据库的规则。

**2.通用语法**

1. SQL 语句可以单行或多行书写，以分号结尾。
2. 可使用空格和缩进来增强语句的可读性。
3. MySQL 数据库的 SQL 语句不区分大小写，关键字建议使用大写。
4. 三种注释：-- 注释
5. SQL语句以分号结尾。

**3.SQL分类**

​	DDL (Data Definition Language) 数据定义语言
​		用来定义数据库对象：数据库，表，列等。
​		关键字：create, drop, alter 等。
​	DML (Data Manipulation Language) 数据操作语言
​		用来对数据库中表的数据进行增删改。
​		关键字：insert, delete, update 等。
​	DQL (Data Query Language) 数据查询语言
​		用来查询数据库中表的记录(数据)。
​		关键字：select, where 等。
​	DCL (Data Control Language) 数据控制语言(了解)
​		用来定义数据库的访问权限和安全级别，及创建用户。
​		关键字：GRANT， REVOKE 等。

## 1.4 MySQL安装

**1.新建配置文件**

说明：MySQL目录下，新建my.ini，以ANSI编码。

```
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=E:\\App\\mysql-8.0.21
# 设置mysql数据库的数据的存放目录(忽略，由系统生成)
#datadir=E:\\App\\mysql-8.0.21\\Data
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。
max_connect_errors=10
# 服务端使用的字符集默认为utf8mb4
character-set-server=utf8mb4
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“mysql_native_password”插件认证
#mysql_native_password
default_authentication_plugin=mysql_native_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8mb4
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8mb4
```

**2.安装服务**

	mysqld --install
如果提示已存在：

```
sc delete mysql
```

**3.初始化**

```
mysqld --initialize --console
//生成初始密码，记录
```

**4.开启服务**

```
net start mysql
```

**5.登录连接**

 ```
mysql -u root -p
 ```

密码过时：

```
mysqladmin -uroot -p password
```

修改密码：

```
ALTER USER 'root'@'localhost' IDENTIFIED BY '新密码';
```

初次修改密码：

```
alter user user() identified by "password";
```

**6.设置环境变量**

1. 自建变量：

   ```
   mysql：D:\App\mysql-8.0.21
   ```

2. 新增Path：

   ```
   %mysql%\bin
   ```

## 1.5 连接数据库

**命令行连接：**

```sql
mysql -uroot -p1704 --连接数据库
update mysql.user set authentication_string=password('1704') where user='root' and Host='localhost'; --修改密码
flush privileges; --刷新权限
--------------------------
--所有语句分号结尾
show databases; --查看所有数据库
use school; --切换数据库：use 数据库名
show tables; --查看数据库中所有表
describe student; -- 显示表中所有信息
```

---



# 二、操作数据库

## 2.1 操作数据库

```sql
CREATE DATABASE IF NOT EXISTS westos; -- 新建数据库
SHOW DATABASES;	-- 查看数据库
DROP DATABASE IF EXISTS westos; -- 删除数据库
```

## 2.2 数据库的列类型

> 数值

- tinyint	  1个字节。
- smallint   2个字节。
- mediumint  3个字节。
- int            4个字节。
- bigint       8个字节。
- float         单精度浮点数。
- double     双精度浮点数。
- decimal   字符串形式的浮点数。

> 字符串

- char         字符串固定大小 0~255
- varchar    可变字符串        0~65535    常用的变量 String
- tinytext    微型文本            2^8 - 1
- text           文本串                2^16 - 1     保存大文本

> 时间日期

java.util.Date

- data           YYYY-MM-DD，日期格式。
- time           HH: mm:: ss       时间格式。
- **datetime   YYYY-MM-DD HH: mm: ss 最常用的时间格式**
- **timestamp 时间戳，1970.1.1到现在的毫秒数！**
- year            年份表示

> null

- 没有值，未知。
- 注：不使用NULL运算，否则结果为NULL

## 2.3 数据库的字段属性（重点）

Unsigned：

- 无符号整数
- 不能声明为负数

zerofill：

- 0填充
- 不足的位数，使用0填充

自增：

- 上一条记录的基础上+1
- 通常用来设计唯一的主键~index，必须整数类型。
- 可以自定义设计主键自增的起始值和步长。

非空NULL not null：

- 设置为not null时，不赋值将报错。
- NULL，不填写值时默认为null。

默认：

- 设置默认的值。

## 2.4 创建数据库表

```sql
CREATE TABLE IF NOT EXISTS `student`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '家庭住址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8
```

格式：

```
CREATE TABLE IF NOT EXISTS `表名`(
	'字段名' 列类型 [属性] [索引] [注释],
	'字段名' 列类型 [属性] [索引] [注释],
	......
	'字段名' 列类型 [属性] [索引] [注释]
)[表的类型][字符集][注释]
```

常用语句：

```sql
SHOW CREATE DATABASE school; -- 查看创建school数据库的语句。
SHOW CREATE TABLE student; -- 查看student数据表的定义语句。
DESC student; -- 查看student数据表的结构
```

## 2.5 数据表的类型

INNODE：当前默认

MYISAM：早先使用

|              | MYISAM | INNODB    |
| ------------ | ------ | --------- |
| 事务支持     | 不支持 | 支持      |
| 数据行锁定   | 不支持 | 支持      |
| 外键约束     | 不支持 | 支持      |
| 全文索引     | 支持   | 不支持    |
| 表空间的大小 | 较小   | 较大，2倍 |

常规使用操作：

- MYISAM	节约空间，速度较快
- INNODB     安全性高，事务处理，多表多用户操作。

> 在物理空间存在的位置

所有的数据库文件存储在data目录下，一个文件夹对应一个数据库。

MySQL引擎在物理文件上的区别：

- INNODB在数据库表中只有一个*.frm文件，以及上级目录下的ibdata1文件。
- MYISAM对应文件
  - *.frm	表结构的定义文件
  - *.MYD  数据文件（data）
  - *.MYI   索引文件（index）

> 设置数据库表的字符集编码

```sql
CHARSET=utf8
```

MySQL默认编码不支持中文，需要修改。

在my.ini中配置默认编码（仅本机有效）：

```ini
character-set-server=utf8
```

## 2.6 修改删除表

> 修改

```sql
-- 修改表名：ALTER TABLE 旧表名 RENAME AS 新表名
ALTER TABLE teacher RENAME AS teacher1
-- 增加表的字段：ALTER TABLE 表名 ADD 字段名 列属性
ALTER TABLE teacher1 ADD age INT(11)
-- 修改表的字段（重命名，修改约束）
-- ALTER TABLE 表名 MODIFY 字段名 列属性[]
ALTER TABLE teacher1 MODIFY age VARCHAR(11) -- 修改约束
-- ALTER TABLE 表名 CHANGE 旧字段名 新字段名 列属性[] 
ALTER TABLE teacher1 CHANGE age age1 INT(1) -- 字段重命名
-- 删除表的字段：ALTER TABLE 表名 DROP 字段名
ALTER TABLE teacher1 DROP age1
```

**注：MODIFY与CHAGE的区别**

> 删除

```sql
-- 删除表 （先判断是否存在）
DROP TABLE IF EXISTS teacher1
```

---



# 三、MySQL数据管理（DML）

## 3.1 外键（了解）

  方式一：创建表时实现外键关系

```sql
CREATE TABLE `grade`(
  `gradeid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '年级ID',
  `gradename` VARCHAR(20) NOT NULL COMMENT '年级名称',
  PRIMARY KEY (`gradeid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

-- 学生表的gradeid引用年级表的gradeid：
-- 1. 定义外键key
-- 2. 执行引用
CREATE TABLE IF NOT EXISTS `student`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '家庭住址',
  `gradeid` INT(10) NOT NULL COMMENT '学生的年级',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '学生的地址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY(`id`),
  KEY `FK_gradeid` (`gradeid`),
  CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`)
  
)ENGINE=INNODB DEFAULT CHARSET=utf8
```

注：删除具有外键关系的表，必须先删除引用别人的表（从表），再删除被引用的表（主表）。

方式二：

```sql
ALTER TABLE `student`
ADD CONSTRAINT `FK_gradeid` FOREIGN KEY(`gradeid`) REFERENCES `grade`(`gradeid`);
```

注：以上为物理外键，数据库级别不建议使用（过多及其复杂）。

后续使用程序实现 。





## 3.3 添加语句

> insert

```sql
INSERT INTO `grade`(`gradename`) VALUES('大四')

-- 主键自增可忽略
INSERT INTO `grade` VALUES('大三')

-- 一般插入语句，数据应与字段一一对应

-- 插入多个字段
INSERT INTO `grade`(`gradename`)
VALUES('大一'),('大二')

INSERT INTO `student`(`name`) VALUES('Teemo')
INSERT INTO `student`(`name`,`pwd`,`sex`) VALUES('YaSuo','0-8-0','man')
INSERT INTO `student`(`name`,`pwd`,`sex`) 
VALUES('LiQing','0-7-0','man'),('ZOE','8-0-0','Girl')

-- 插入语句
-- insert into 表名(字段1,字段2,字段3)values('值1','值2','值3')
```

**注：**

- **字段与字段逗号分隔。**

- **值与字段一一对应。**



## 3.4 修改

> update 

```sql
-- 限制条件（否则改动全表数据！）
UPDATE `student` SET `name`='Tristana' WHERE id = 1;
-- 修改多个属性，逗号隔开
UPDATE `student` SET `name`='Tristana',sex = 'women' WHERE id = 1;

-- 修改语句
-- UPDATE 表名 SET 字段1=值,字段2=值 WHERE [条件];
```

条件：Where子句运算符 id等于大于某个值，或在某个区间内修改。

操作符返回布尔值。

| 运算符              | 含义                 | 示例 | 结果 |
| ------------------- | -------------------- | ---- | ---- |
| =                   | 等于                 |      |      |
| <> 或 !=            | 不等于               |      |      |
| >                   |                      |      |      |
| <                   |                      |      |      |
| >=                  |                      |      |      |
| <=                  |                      |      |      |
| BETWEEN ... AND ... | 在某个范围内，闭区间 |      |      |
| AND                 | 与                   |      |      |
| OR                  | 或                   |      |      |

```sql
-- 通过多个条件定位数据
UPDATE `student` SET `name`='Teemo' WHERE `name`='YaSuo' AND `sex`='男';
```

注：

- value可以是一个具体值，也可以是一个变量。



## 3.5 删除

> delete命令

```sql
-- 删除指定数据
DELETE FROM `student` WHERE id = 1;
-- 清空表
DELETE FROM `student`;
```

>TRUNCATE命令 

```sql
-- 清空表
TRUNCATE `student`;
```

> delete与TRUNCATE的区别

```sql
CREATE TABLE `test`(
  `id` INT(4) NOT NULL AUTO_INCREMENT,
  `coll` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `test`(`coll`)VALUES('1'),('2'),('3');

DELETE FROM `test`; -- 不会影响自增（自增量不变）

TRUNCATE `test`;
```

- InnoDB：自增列重新从1开始（存储在内存中，断电即失）
- MyISAM：继续从上一个自增量开始（存储在文件中，不会丢失）



# 四、DQL

（Data Query LANGUAGE：数据查询语言）

- 关键字select

## 4.1 查询指定字段

```sql
-- 查询全部的学生 
SELECT * FROM student;
-- 查询学生表的指定字段
SELECT `StudentNo`,`StudentName` FROM student;
-- 别名，为查询结果起个名字
SELECT `StudentNo` AS 学号,`StudentName` AS 姓名 FROM student;

-- 函数 Concat(a,b)  拼接
SELECT CONCAT('姓名：',StudentName) AS 新名字 FROM student;
```

语法：SELECT 字段,... FROM 表

>distinct去重

```sql
-- 查询全部考试成绩
SELECT * FROM result;
SELECT `StudentNo` FROM result;
-- 去重(重复的数据只显示一条)
SELECT DISTINCT  `StudentNo` FROM result;
```

> 数据库的列（表达式）

```sql
-- 查询系统版本(函数)
SELECT VERSION()
-- 计算（表达式）
SELECT 100*3-1 AS 计算结果;
-- 查询自增的步长（变量）
SELECT @@auto_increment_increment
-- 考试成绩+1
SELECT `StudentNo`,`StudentResult`+1 AS '提分后' FROM result;
```

数据库中的表达式：文本值，列，Null，函数，计算表达式，系统变量...

## 4.2 where条件子句

作用：检索数据中符合条件的值

> 逻辑运算符

| 运算符  | 语法               | 描述   |
| ------- | ------------------ | ------ |
| and &&  | a and b    a&&b    | 逻辑与 |
| or \|\| | a or b    a \|\| b | 逻辑或 |
| Not !   | not a    ! a       | 逻辑非 |

```sql
SELECT studentNo,`StudentResult` FROM result;
-- 条件查询
SELECT studentNo,`StudentResult` FROM result
WHERE StudentResult>=95 AND StudentReslut<= 100;
-- 模糊查询（区间）
SELECT StudentNo,SubjectNo,`StudentResult` FROM result
WHERE StudentResult BETWEEN 95 AND 100;
-- 查询除1000号学生外的同学成绩
SELECT studentNo,`StudentResult` FROM result
WHERE StudentNo!=1000;
-- 或者
SELECT studentNo,`StudentResult` FROM result
WHERE NOT StudentNo=1000;
```

> 模糊查询：比较运算符

| 运算符      | 语法              | 描述                  |
| ----------- | ----------------- | --------------------- |
| IS NULL     | a is null         |                       |
| IS NOT NULL | a is not null     |                       |
| BETWEEN     | a between b and c | a在b与c之间           |
| **Like**    | a like b          | a匹配b                |
| **In**      | a in(a1,a2,a3)    | a是a1,a2,a3中的某一个 |

```sql
-- ===================模糊查询=======================
-- like结合 %（代表0到任意个字符） _（一个字符） __（两个字符）
-- 查询以T开头
SELECT StudentNo,StudentName FROM student
WHERE Student NAME LIKE 'T%';
SELECT StudentNo,StudentName FROM student
WHERE Student NAME LIKE 'T_';
SELECT StudentNo,StudentName FROM student
WHERE Student NAME LIKE 'T_';

-- 查询含有T的数据
SELECT StudentNo,StudentName FROM student
WHERE Student NAME LIKE '%T%';

-- in（具体的一个或多个值）
-- 查询1001,1002，1003号
SELECT StudentNo，StudentName FROM student
WHERE Student IN (1001,1002,1003);

SELECT StudentNo，StudentName FROM student
WHERE Address IN ('中国','北京');

-- 查询地名为空 null ''
SELECT StudentNo，StudentName FROM student
WHERE Address='' OR Address IS NULL;
```

## 4.3 联表查询

```sql
-- ===================联表查询=======================
/*
分析：
	1.分析查询的字段来自哪些表？
	2.确定使用哪种连接查询？（7种）
		确定交叉点：学生表中的StudentNo = 成绩表StudentNo	
*/ 
-- Inner Join
SELECT s.studentNo,studentName,SubjectNo,StudentResult
FROM student AS s
INNER JOIN result AS r
ON s.studentNo = r.studentNo;

-- Right Join
SELECT s.studentNo,studentName,SubjectNo,StudentResult
FROM student s
RIGHT JOIN result r
ON s.studentNo = r.studentNo;

-- Left Join
SELECT s.studentNo,studentName,SubjectNo,StudentResult
FROM student s
LEFT JOIN result r
ON s.studentNo = r.studentNo;
```

| 连接                   | 说明                                               |
| ---------------------- | -------------------------------------------------- |
| Left Join（左连接）    | 返回包括左表中的所有记录和右表中联结字段相等的记录 |
| Inner Join（等值连接） | 只返回两个表中联结字段相等的行                     |
| Right Join（右连接）   | 返回包括右表中的所有记录和左表中联结字段相等的记录 |

> 自连接

核心：一张表拆为两张一样的表。

```sql
SELECT a.`categoryName` AS 'A表',b.`categoryName` AS 'B表'
FROM `category` AS a,`category` AS b
WHERE a.`categoryid` = b.`pid`
```

联表查询示例：

```sql
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN subject sub
ON r.SubjectNo = sub.SubjectNo
WHERE subjectName = '数据结构'
```

## 4.4 分页与排序

> 排序order by

```sql
-- ORDER BY 要排序的字段 升序ASC/降序DESC 
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN SUBJECT sub
ON r.SubjectNo = sub.SubjectNo
WHERE subjectName = '数据结构'
ORDER BY StudentResult ASC
```

> 分页

缓解数据库压力，（瀑布流与之相反）

```sql
-- 取《数据结构》课程成绩排名前十的学生信息
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN SUBJECT sub
ON r.SubjectNo = sub.SubjectNo
WHERE SubjectName = '数据结构' AND StudentResult>=80
ORDER BY StudentResult DESC
LIMIT 0,10
-- 第一页 limit 0,5	(1-1)*5
-- 第二页 limit 5-5	(2-1)*5
-- 第三页 limit 10-5	(3-1)*5
-- 第N页  limit 0-5	 (n-1)*pageSize
-- pageSize：页面大小
-- (n-1)*pageSize：起始值
-- n：当前页
-- 数据总数/页面大小 = 总页数
```

语法：`limit(查询起始下标,pageSize)`

## 4.5 子查询与嵌套查询

where中嵌套判断。

```sql
-- 方式一：使用连接查询
SELECT DISTINCT s.StudentNo,StudentName
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN subject sub
ON sub.SubjectNo = r.SubjectNo
WHERE SubjectName = '数据结构' AND StudentResult>=80

-- 方式二：子查询
SELECT DISTINCT s.StudentNo,StudentName
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
WHERE StudentResult>=80 AND SubjectNo = (
	SELECT SubjectNo FROM subject
    WHERE SubjectName='数据结构'
)

-- 方式三：嵌套查询
SELECT StudentNo,StudentName FROM student WHERE StudentNo IN(
	SELECT StudentNo FROM result WHERE StudentResult>80 AND SubjectNo = (
    	SELECT SubjectNo FROM subject WHERE SubjectName = '数据结构'
    )
)
```

## 4.6 分组与过滤

```sql
-- 查询不同课程的平均分，最高分，最低分
-- 核心：依据不同的课程分组
SELECT SubjectName,AVG(StudentResult) AS 平均分,MAX(StudentResult),MIN(StudentResult)
FROM result r
INNER JOIN `subject` sub
ON r.SubjectNo = sub.SubjectNo
GROUP BY r.SubjectNo -- 通过某字段分组
HAVING 平均分>80  -- 对分组结果再次过滤
```

## 4.7 Select总结

```
select 去重 要查询的字段 from 表名（表和字段可以起别名）
xxx join 要连接的表 on 等值判断
where （具体的值，子查询语句）
Group By（通过某个字段分组）
Having （过滤分组后的信息，使用同where）
Order By ... (通过某个字段排序)[升序/降序]
Limit startIndex，pageSize

业务层面：
查询：跨表、跨库
```

---

# 五、MySQL函数

## 5.1 常用函数

```sql
-- 数学运算
SELECT ABS(-8) -- 绝对值
SELECT CEILING(9.3) -- 向上取整
SELECT FLOOR(9.7) -- 向下取整
SELECT RAND() -- 返回0-1的随机数
SELECT SIGN(-10) -- 判断一个数的符号 0返回0，正数返回1，负数返回-1
-- 字符串函数
SELECT CHAR_LENGTH('若樱倾城雨') -- 字符串长度 
SELECT CONCAT('Hello', 'World') -- 字符串拼接
SELECT INSERT('Hello',1,2,'he') -- 替换（指定位置）
SELECT LOWER('HELLO') -- 转小写
SELECT UPPER('hello') -- 转大写
SELECT INSTR('hello','l') -- 返回第一次出现的索引位置
SELECT REPLACE('Apple','pple','phone') -- 替换指定内容
SELECT SUBSTR('HELLO',3,5) -- 截取子串
SELECT REVERSE('Teemo') -- 反转  
-- 查询姓'周'的同学，替换姓为'邹'
SELECT REPLACE(studentname,'周','邹') FROM student
WHERE studentname LIKE '周%'
-- 时间和日期函数
SELECT CURRENT_DATE() -- 获取当前日期
SELECT CURRENT_TIME() -- 获取当前时间
SELECT NOW() -- 获取当前时间
SELECT LOCALTIME() -- 获取本地时间
```

## 5.2 聚合函数（常用）

```sql
SELECT COUNT(studentname) FROM student; -- Count(字段)，忽略null值
SELECT COUNT(*) FROM student; -- Count(*)，不忽略null值，本质是计算行数
SELECT COUNT(1) FROM result; -- Count(1)，不忽略所有的null值，本质是计算行数

SELECT SUM(StudentResult) AS 总分 FROM result
SELECT AVG(StudentResult) AS 平均分 FROM result
SELECT MAX(StudentResult) AS 最高分 FROM result
SELECT MIN(StudentResult) AS 最低分 FROM result
```

## 5.3 数据库级别的MD5加密（扩展）

```sql
DROP TABLE testmd5

CREATE TABLE testmd5(
  `id` INT(4) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `pwd` VARCHAR(50) NOT NULL,
  PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO testmd5 VALUES(1,'Teemo','123456'),(2,'YaSuo','234561'),(3,'LiQing','345612')

-- 加密
UPDATE testmd5 SET pwd=MD5(pwd) WHERE id =1
-- 全部加密
UPDATE testmd5 SET pwd=MD5(pwd) 
-- 插入时加密
INSERT INTO testmd5 VALUES(4,'ZhaoXin',MD5('123456'))
-- 校验：对用户输入的密码进行加密，比较加密后的结构
SELECT * FROM testmd5 WHERE `name` = 'Teemo' AND pwd = MD5('123456')
```

---

# 六、事务

## 6.1 事务定义

将一组SQL放在一个批次中执行

>事务原则：ACID原则 原子性、一致性、隔离性、持久性

**原子性：**事务是一个不可再分割的工作单元，事务中的操作要么都发生，要么都不发生。

**一致性：**事务前后的数据完整性保持一致。

**持久性：**事务一旦提交不可逆，被持久化到数据库中。

**隔离性：**不同的事务同时操纵相同的数据时，每个事务都有各自的完整数据空间。

> 隔离导致的一些问题

**脏读：**一个事务读取了另一个事物未提交的数据。

**不可重复读：**在一个事务内读取表中的某一行数据，多次读取结果不同。

**虚读（幻读）：**一个事务内读取到了别的事务插入的数据。

```sql
-- mysql 默认开启事务自动提交

-- 手动处理事务
SET autocommit = 0; -- 关闭自动提交
-- 事务开启
START TRANSACTION  -- 标记一个事务的开始
-- 操作数据
INSERT xxx
INSERT xxx

-- 提交：持久化
COMMIT
-- 回滚：恢复上次操作前的状态
ROLLBACK

-- 事务结束
SET autocommit = 1; -- 开启自动提交

-- 了解
SAVEPOINT 保存点名 -- 设置一个事务的保存点
ROLLBACK TO SAVEPOINT 保存点名 -- 回滚到保存点
RELEASE SAVEPOINT 保存点名 -- 撤销保存点
```

## 6.2 事务的应用

案例：转账

```sql
CREATE DATABASE shop CHARACTER SET utf8 COLLATE utf8_general_ci;
USE shop;

CREATE TABLE `account`(
 `id` INT(3) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(30) NOT NULL,
 `money` DECIMAL(9,2) NOT NULL,
 PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `account`(`name`,`money`)
VALUES ('A',2000.00),('B',10000.00);

-- 模拟转账
SET autocommit = 0; -- 关闭自动提交
START TRANSACTION -- 开启一个事务
UPDATE `account` SET money=money-500 WHERE `name` = 'A';
UPDATE `account` SET money=money+500 WHERE `name` = 'B';

COMMIT; -- 一经提交，即持久化
ROLLBACK;

SET autocommit = 1; -- 开启自动提交
```

---

# 七、索引

> 索引（index）帮助MySQL高效获取数据的数据结构。

## 7.1 索引分类

- 主键索引（PRIMARY KEY）
  - 唯一标识，不可重复，只能有一个列作为主键
- 唯一索引（UNIQUE KEY）
  - 避免重复的列出现，唯一索引可以重复，多个列都可以表示为唯一索引。
- 常规索引（KEY/INDEX）
  - 默认的。
- 全文索引（FullText）
  - 特定数据库引擎下有，如MyISAM

```sql
-- 索引的使用
-- 1、创建表的时候给字段增加索引
-- 2、创建完毕后，增加索引。

-- 显示所有的索引信息
USE school;
SHOW INDEX FROM student;

-- 增加一个全文索引
ALTER TABLE school.student ADD FULLTEXT INDEX `studentName`(`studentName`);

-- EXPLAIN 分析sql执行的状况
EXPLAIN SELECT * FROM student; -- 非全文索引

SELECT * FROM student WHERE MATCH(studentName) AGAINST('Teemo');
```

## 7.2 索引测试

```sql
CREATE DATABASE app;
USE app;

-- 测试索引 建表并用函数插入100万条数据
CREATE TABLE `app_user`(
`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) DEFAULT '' COMMENT '用户昵称',
`email` VARCHAR(50) NOT NULL COMMENT '用户邮箱',
`phone` VARCHAR(20) DEFAULT '' COMMENT '手机号',
`gender` TINYINT(4) UNSIGNED DEFAULT '0' COMMENT '性别 0男  1女',
`password` VARCHAR(100) NOT NULL COMMENT '密码',
`age` TINYINT(4) DEFAULT '0' COMMENT '年龄',
`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY(`id`)
)ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = 'app用户表'

SET GLOBAL log_bin_trust_function_creators=TRUE;
-- 插入100万条数据
DELIMITER $$
CREATE FUNCTION mock_data_version2()
RETURNS INT 
BEGIN
	DECLARE num INT DEFAULT 1000000;
	DECLARE i INT DEFAULT 0;
	WHILE i<num DO
	  INSERT INTO `app_user` (`name`,email,phone,gender,`password`,age)VALUES    (CONCAT('用户',i),'123456@qq.com',
		CONCAT('13',FLOOR(RAND()*((999999999-100000000)+100000000))),
		FLOOR(RAND()*2),
		UUID(),
		FLOOR(RAND()*100));
	SET i = i+1;
END WHILE;
RETURN i;
END;
SELECT mock_data_version2()

-- 测试索引作用
SELECT * FROM app_user WHERE `name` = '用户80000'  -- 不使用索引
CREATE INDEX id_user_app_name ON app_user(`name`)
SELECT * FROM app_user WHERE `name` = '用户99999'  -- 使用索引
```

## 7.3 索引原则

- 表中数据量较多时使用索引（小数据量表不宜使用）
- 进程变动数据不能加索引
- 索引一般加在被查询的字段上

>索引的数据结构

Hash类型的索引

Btree：InnoDB的默认数据结构

文章：http://blog.codinglabs.org/articles/theory-of-mysql-index.html

# 八、权限管理和数据库备份

## 8.1 权限管理

```sql
-- 创建用户
CREATE USER shinrin IDENTIFIED BY '123456'
-- 修改密码（当前用户）
SET PASSWORD = '123456'
-- 修改密码（指定用户）
SET PASSWORD FOR shinrin = '123456'
-- 修改用户名
RENAME USER shinrin TO jonah
-- 用户授权：全部的权限，库，表（该用户无法为其他用户授权）
GRANT ALL PRIVILEGES ON *.* TO jonah
-- 查询权限
SHOW GRANTS FOR jonah
-- 查询root权限
SHOW GRANTS FOR root@localhost
-- 撤销权限：库 用户
REVOKE ALL PRIVILEGES ON *.* TO jonah
-- 删除用户
DROP USER jonah
```

## 8.2 数据库备份

- 重要数据不丢失
- 数据迁移

备份方式：

- 拷贝物理文件
- 可视化工具导出
- 命令行导出mysqldump

```sql
-- 命令行使用mysqldump导出
-- mysqldump 本机 用户名 密码 库 表 >目标文件
mysqldump -hlocalhost -uroot -p123456 库 表1 表2 >D:/a.sql
```

- 命令行导入数据库

```sql
-- 登录 转到要导入的数据库下
source d:/a.sql
```

# 九、数据库规约、三大范式

## 9.1 数据库设计的必要性

数据库应避免出现以下缺陷：

- 数据冗余，浪费空间

- 数据库插入和删除困难、异常【屏蔽使用物理外键】
- 程序性能差

良好的数据库设计：

- 节省内存空间
- 保证数据库完整性
- 便于开发系统

软件开发设计：

- 分析需求：分析业务和需要处理的数据库的需求
- 概要设计：涉及关系图E-R图

设计数据库的步骤：（个人博客）

- 收集信息，分析需求
  - 用户表（登录注销、个人信息、写博客、创建分类）
  - 分类表（文章分类、创建者）
  - 文章表（文章信息）
  - 评论表
  - 友链表（友链信息）
  - 自定义表（系统信息，关键字，主题）key：value
  - 说说表（心情，ID，内容，创建时间）
  
- 标识实体（把需求落地到每个字段）

- 标识实体之间的关系

  - 写博客：user-->blog
  - 创建分类：user-->category
  - 关注：user-->userfollow
  - 友链：links
  - 评论：user-->user bolg

  阿里：https://pro.ant.design/index-cn

## 9.2 三大范式

数据规范化的必要性：

- 信息重复
- 更新异常
- 插入异常
  - 无法显示正常信息
- 删除异常
  - 丢失有效信息

**三大范式：**https://www.cnblogs.com/wsg25/p/9615100.html

- 第一范式：原子性，**要求数据库表的每一列都是不可分割的原子数据项。**
- 第二范式：满足第一范式，同时每张表只描述一件事物。
- 第三范式：确保数据表中的每一列数据和主键直接相关（不能间接相关）。

**规范与性能考虑：**关联查询的表不超过三张。

- 考虑商业化的需求和目标，（成本，用户体验！）数据库的性能更为重要。
- 规范性能的问题时，考虑规范性。
- 增加冗余字段。（多表查询变为单表查询）
- 增加计算列。（大数据量的查询降为小数据量的查询：索引）

# 十、JDBC（重点）

## 10.1 数据库驱动

应用程序	<<==	JDBC	<<==	数据库驱动	<<==	数据库。

## 10.2 JDBC

SUN公司为简化开发人员的（对数据库的统一的）操作，提供的规范。

1. 新建数据库数据

```sql
CREATE DATABASE jdbcStudy CHARACTER SET utf8 COLLATE utf8_general_ci;

USE jdbcStudy;

CREATE TABLE users(
	id INT PRIMARY KEY,
	name VARCHAR(40),
	password VARCHAR(40),
	email VARCHAR(60),
	birthday DATE
);

INSERT INTO users(id,NAME,password,email,birthday)
VALUES(1,'Teemo','123456','teemo@qq.com','2020-01-01'),
(2,'YaSuo','123456','YaSuo@qq.com','2020-01-02'),
(3,'ZhaoXin','123456','ZhaoXin@qq.com','2020-01-03');
```

2. 新建Java项目JDBC
3. 导入Jdbc包
4. 实现类访问数据库
   - 加载驱动
   - 连接数据库DriverManager
   - 执行SQL的对象Statement
   - 获取返回结果集
   - 释放连接

```java
package com.shinrin.java;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库DriverManager
        //参数：支持中文，utf8编码，安全连接，（时区，否则报错）
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        //3.执行SQL的对象Statement
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);  //链表形式
        //4.获取返回的结果集
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }
        //5.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

## 10.3 JDBC分析

> DriverManager

```java
//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(url,username,password);
//connection 即数据库
connection.rollback();
connection.commit();
connection.setAutoCommit(true);
 
```

> URL

```java
String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
//mysql -- 3306
//协议：//主机地址:端口号//数据库名?参数1&参数2&参数3
//oracle -- 1521
//jdbc:oracle:thin:@localhost:1521:sid
```

> Statement执行SQL的对象，

```java
String sql = "SELECT * FROM users";	//SQL语句
statement.executeQuery(sql);    //查询，返回链表
statement.execute(sql);         //执行任何SQL语句
statement.executeUpdate(sql);   //更新，插入，删除
```

>ResultSet查询的结果集：封装了所有的结果

```sql
resultSet.getObject("未知字段类型");
resultSet.getInt("字段类型int");
resultSet.getString("字段类型varchar");

resultSet.beforeFirst();	//移动到首元素前
resultSet.afterLast();		//移动到尾元素后
resultSet.next();			//下一元素
resultSet.previous();   	//移动到前一行
```

## 10.4 JDBC程序

- 配置文件（驱动、url、账号、密码）
- 工具类（获取连接、释放连接）
- 测试类（增删改查）

**db.properrties**

```properties
# 路径：/src/db.properrties
# 作用：配置信息
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8
username=root
password=123456
```

**JdbcUtils.java**

```java
//工具类：连接、释放数据库
package com.shinrin.lesson2.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            System.out.println(driver);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (st != null){
            try{
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
```

**Test.java**

```java
package com.shinrin.lesson2;

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql1 = "INSERT INTO users(id,name,password,email,birthday)" +
                    "VALUES(4,'ZOE','123456','zoe@qq.com','2020-01-04')";
            String sql2 = "DELETE FROM users WHERE id = 4;";
            String sql3 = "UPDATE users SET `name` = 'Jerrry',`email` = 'jerry@qq.com' WHERE id = 1;";
            String sql4 = "SELECT * FROM users WHERE id = 1;";
            int i = st.executeUpdate(sql1);     //增
			//int i = st.executeUpdate(sql2);   //删
			//int i = st.executeUpdate(sql3);   //改
            rs = st.executeQuery(sql4);   //查
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

            if (i > 0){
                System.out.println("更新成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
```

## 10.5 SQL注入

注入本质：SQL语句拼接。

**使用PrepareStatement防止SQL注入。**

**原理**：**把用户非法输入的单引号用\反斜杠做了转义**。

```java
package com.shinrin.lesson3;

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestInsert {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils.getConnection();
            //区别：使用?占位符代替参数（此处以查找为例）
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)value(?,?,?,?,?)";
            st = conn.prepareStatement(sql);//    预编译sql，不执行
            //手动为参数赋值
            st.setInt(1,4);
            st.setString(2,"ZOE");
            st.setString(3,"123456");
            st.setString(4,"zoe@qq.com");
            //获取当前时间
            //java.util.Date  date=new java.util.Date();
            //java.sql.Date  sqldate=new java.sql.Date(date.getTime());
            st.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
```

## 10.6 IDEA连接数据库

> 注意问题：

导入mysql包（当前工程lib目录）

时区设置

## 10.7 IDEA处理事务

> ACID原则

- 原子性：全部完成或全不完成。

- 一致性：总数不变。

- 隔离性：多个进程互不干扰。

- 持久性：一旦提交不可逆，持久化到数据库。

> 隔离性的问题：

- 脏读：一个事物读取了另一个没有提交的事务。

- 不可重复读：在同一个事物内，重复读取表中的数据，表数据发生了改变。

- 虚读（幻读）：在一个事物内，读取到了别人插入的数据，倒置前后读取结果不一致。

>代码实现

1. 开启事务：conn.setAutoCommit(false);//开始事务（关闭自动提交）。
2. 一组业务，执行完毕提交事务。
3. catch代码段中显式定义回滚语句（可省略，默认失败即回滚）。
4. 释放连接。

```sql
package com.shinrin.lesson4;

import com.shinrin.lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);//开始事务（关闭自动提交）
            String sql1 = "update account set money = money - 100 where name = 'A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            //int x = 1/0;  //出错回滚，不提交。

            String sql2 = "update account set money = money + 100 where name = 'B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
            System.out.println("成功！");
        }catch (SQLException e){
            try{
                conn.rollback();    //此处显式定义，实则失败默认回滚。
            }catch (SQLException se){
                se.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
```

## 10.8 数据库连接池

背景：数据库频繁连接—释放浪费资源。

**池化技术**：预备资源。

常用连接数=最小连接数。

最大连接数：业务最高承载上限。

编写连接池，实现接口DataSource

>开源数据源实现

DBCP：

C3P0：

Druid（ali）：

项目开发中无需编写代码连接数据库。

>DBCP

所需jar包：

- commons-dbcp-1.4.jar

- commons-pool-1.6.jar
- commons-logging-1.2.jar
- mysql-connector-java-8.0.21.jar

**dbcpconfig.properties**

```properties
#连接设置
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/jdbcstudy?useSSL=true&serverTimezone=GMT%2B8
username=root
password=123456

#<!-- 初始化连接 -->
initialSize=10

#最大连接数量
maxActive=50

#<!-- 最大空闲连接 -->
maxIdle=20

#<!-- 最小空闲连接 -->
minIdle=5

#<!-- 超时等待时间以毫秒为单位 6000毫秒/1000等于60秒 -->
maxWait=60000

#JDBC驱动建立连接时附带的连接属性属性的格式必须为这样：[属性名=property;]
#注意："user" 与 "password" 两个属性会被明确地传递，因此这里不需要包含他们。
connectionProperties=useUnicode=true;characterEncoding=utf8

#指定由连接池所创建的连接的自动提交（auto-commit）状态。
defaultAutoCommit=true

#driver default 指定由连接池所创建的连接的事务级别（TransactionIsolation）。
#可用值为下列之一：（详情可见javadoc。）NONE,READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE
defaultTransactionIsolation=READ_UNCOMMITTED
```

**JdbcUtils_DBCP.java**

```java
package com.shinrin.lesson5.utils;
/**
 * DBCP工具类
 */

import com.shinrin.lesson2.utils.JdbcUtils;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils_DBCP {

    private static DataSource dataSource = null;
    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);
            //创建数据源 工厂模式
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static  Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (st != null){
            try{
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
```

**TestDBCP.java**

```java
package com.shinrin.lesson5;

import com.shinrin.lesson2.utils.JdbcUtils;
import com.shinrin.lesson5.utils.JdbcUtils_DBCP;
/**
 * 测试DBCP
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDBCP {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            //【与自定义相比，仅次处改变】
            conn = JdbcUtils_DBCP.getConnection();
            //区别：使用?占位符代替参数（此处以查找为例）
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)value(?,?,?,?,?)";
            st = conn.prepareStatement(sql);//    预编译sql，不执行
            //手动为参数赋值
            st.setInt(1,4);
            st.setString(2,"ZOE");
            st.setString(3,"123456");
            st.setString(4,"zoe@qq.com");
            //获取当前时间
            //java.util.Date  date=new java.util.Date();
            //java.sql.Date  sqldate=new java.sql.Date(date.getTime());
            st.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
```

> C3P0

所需jar包：

- c3p0-0.9.5.5.jar
- mchange-commons-java-0.2.19.jar

**c3p0-config.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<c3p0-config>
    <default-config>
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=true&amp;serverTimezone=GMT%2B8</property>
        <property name="user">root</property>
        <property name="password">123456</property>

        <property name="acquireIncrement">5</property>
        <property name="initialPoolSize">10</property>
        <property name="minPoolSize">5</property>
        <property name="maxPoolSize">20</property>
    </default-config>

    <named-config name="MySQL">
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=true&amp;serverTimezone=GMT%2B8</property>
        <property name="user">root</property>
        <property name="password">123456</property>

        <property name="acquireIncrement">5</property>
        <property name="initialPoolSize">10</property>
        <property name="minPoolSize">5</property>
       <property name="maxPoolSize">20</property>
    </named-config>
</c3p0-config>
```

**JdbcUtils_C3P0.java**

```java
package com.shinrin.lesson5.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils_C3P0 {

    private static DataSource dataSource = null;
    static {
        try {
            dataSource = new ComboPooledDataSource("MySQL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (st != null){
            try{
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
```

**TestC3P0.java**

```java
package com.shinrin.lesson5;

import com.shinrin.lesson2.utils.JdbcUtils;
import com.shinrin.lesson5.utils.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_C3P0.getConnection();
            //区别：使用?占位符代替参数（此处以查找为例）
            String sql = "insert into users(id,`name`,`password`,`email`,`birthday`)value(?,?,?,?,?)";
            st = conn.prepareStatement(sql);//    预编译sql，不执行
            //手动为参数赋值
            st.setInt(1,5);
            st.setString(2,"Kitty");
            st.setString(3,"123456");
            st.setString(4,"kitty@qq.com");
            //获取当前时间
            //java.util.Date  date=new java.util.Date();
            //java.sql.Date  sqldate=new java.sql.Date(date.getTime());
            st.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
```

