DROP TABLE IF EXISTS `grade`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `teacher1`;
DROP TABLE IF EXISTS `test`;

CREATE DATABASE  IF NOT EXISTS `school`;
USE `school`;

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade`(
  `GradeID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '年级编号',
  `GradeName` VARCHAR(50) NOT NULL COMMENT '年级名称',
  PRIMARY KEY (`GradeID`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `grade`(`GradeID`,`GradeName`) VALUES (1,'大一'),(2,'大二'),(3,'大三'),(4,'大四');

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result`(
  `StudentNo` INT(4) NOT NULL COMMENT '学号',
  `SubjectNo` INT(4) NOT NULL COMMENT '课程编号',
  `ExamDate` DATETIME NOT NULL COMMENT '考试日期',
  `StudentResult` INT(4) NOT NULL COMMENT '考试日期',
  KEY `SubjectNo` (`SubjectNo`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `result`(`StudentNo`,`SubjectNo`,`ExamDate`,`StudentResult`) VALUES (1001,1,'2013-11-11 16:00:00',98);

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`(
  `StudentNo` INT(4) NOT NULL COMMENT '学号',
  `LoginPwd` VARCHAR(20) DEFAULT NULL,
  `StudentName` VARCHAR(20) DEFAULT NULL COMMENT '学生姓名',
  `Sex` TINYINT(1) DEFAULT NULL COMMENT '性别，取值0或1',
  `GradeId` INT(11) DEFAULT NULL COMMENT '年级编号',
  `Phone` VARCHAR(50) NOT NULL COMMENT '联系电话',
  `Address` VARCHAR(255) NOT NULL COMMENT '地址',
  `BornDate` DATETIME DEFAULT NULL COMMENT '出生日期',
  `Email` VARCHAR(50) NOT NULL COMMENT '邮箱编号',
  `IdentityCard` VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`StudentNo`),
  UNIQUE KEY `IdentityCard` (`IdentityCard`),
  KEY `Email`(`Email`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO `student`(`StudentNo`,`LoginPwd`,`StudentName`,`Sex`,`GradeId`,`Phone`,`Address`,`BornDate`,`Email`,`IdentityCard`) 
VALUES (1001,'123456','Teemo','1',1,'0966188','China','2000-01-01 00:00:00','Teemo@qq.com','00250001');

INSERT INTO `student`(`StudentNo`,`LoginPwd`,`StudentName`,`Sex`,`GradeId`,`Phone`,`Address`,`BornDate`,`Email`,`IdentityCard`) 
VALUES (1002,'123456','YaSuo','1',1,'0966128','China','2000-01-01 00:00:00','YaSuo@qq.com','00250002');


-- 查询全部的学生 
SELECT * FROM student;
-- 查询学生表的指定字段
SELECT `StudentNo`,`StudentName` FROM student
-- 别名，为查询结果起个名字
SELECT `StudentNo` AS 学号,`StudentName` AS 姓名 FROM student

-- 函数 Concat(a,b)  拼接
SELECT CONCAT('姓名：',StudentName) AS 新名字 FROM student;

-- 查询全部考试成绩
SELECT * FROM result;
SELECT `StudentNo` FROM result;
-- 去重(重复的数据只显示一条)
SELECT DISTINCT  `StudentNo` FROM result;

-- 查询系统版本(函数)
SELECT VERSION()

-- 计算（表达式）
SELECT 100*3-1 AS 计算结果;

-- 查询自增的步长（变量）
SELECT @@auto_increment_increment
 
-- 考试成绩+1
SELECT `StudentNo`,`StudentResult`+1 AS '提分后' FROM result;


-- ===================where=======================
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

-- ===================联表查询=======================
SELECT * FROM student;
SELECT * FROM result;

/*
分析：
	1.分析查询的字段来自哪些表
	2.确定使用哪种连接查询？（7种）
		确定交叉点（两个表中相同的数据）
		判断的条件：学生表中的StudentNo = 成绩表StudentNo
		
*/ 

-- Inner Join
SELECT studentNo,studentName,SubjectNo,StudentResult
FROM student AS s
INNER JOIN result AS r
ON s.studentNo = r.studentNo;


-- Right Join
SELECT studentNo,studentName,SubjectNo,StudentResult
FROM student s
RIGHT JOIN result r
ON s.studentNo = r.studentNo;

-- Left Join
SELECT studentNo,studentName,SubjectName,StudentResult
FROM student s
LEFT JOIN result r
ON s.studentNo = r.studentNo;

-- 需求：查询参加了考试的同学信息：学号，姓名，科目，分数。
-- 分析：
-- 	表：student、result、subject
--	其中，student与result交叉StudentNo,result与subject交叉SubjectNo

SELECT s.studentNo,studentName,SubjectName,StudentResult
FROM student s
RIGHT JOIN result r
ON r.studentNo = s.studentNo
INNER JOIN `subject` sub
ON r.SubjectNo = sub.SubjectNo

-- 排序：升序ASC，降序DESC
-- ORDER BY 要排序的字段 升序/降序 
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN SUBJECT sub
ON r.SubjectNo = sub.SubjectNo
WHERE subjectName = '数据结构'
ORDER BY StudentResult ASC
 
 
 -- 分页：每页只显示五条数据
 -- 语法：limit 起始值，页面的大小
 
 
 -- ===================常用函数
 
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

-- ========================聚合函数
SELECT COUNT(studentname) FROM student; -- Count(字段)，忽略null值
SELECT COUNT(*) FROM student; -- Count(*)，不忽略null值，本质是计算行数
SELECT COUNT(1) FROM result; -- Count(1)，不忽略所有的null值，本质是计算行数

SELECT SUM(StudentResult) AS 总分 FROM result
SELECT AVG(StudentResult) AS 平均分 FROM result
SELECT MAX(StudentResult) AS 最高分 FROM result
SELECT MIN(StudentResult) AS 最低分 FROM result

-- 查询不同课程的平均分，最高分，最低分
-- 核心：依据不同的课程分组
SELECT SubjectName,AVG(StudentResult) AS 平均分,MAX(StudentResult),MIN(StudentResult)
FROM result r
INNER JOIN `subject` sub
ON r.SubjectNo = sub.SubjectNo
GROUP BY r.SubjectNo -- 通过某字段分组
HAVING 平均分>80

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
