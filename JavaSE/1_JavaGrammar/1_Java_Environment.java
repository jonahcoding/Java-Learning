/*
Java特点：
	1.面向对象
	2.跨平台
	3.虚拟机，内置GC

Java执行机制：
	解释执行（跨平台）：
		1..java源文件编译生成.class字节码文件
		2.解释执行字节码文件
	注：与翻译执行的区别。
	
Java环境变量配置：
	新建系统变量：
		变量名：JAVA_HOME
		变量值：E:\App\Java\jdk1.8.0
	新建系统变量：
		变量名：CLASS_PATH
		变量值：;% JAVA_HOME%\lib; %JAVA_HOME%\lib\tools.jar
	编辑Path变量：
		变量名：Path
		变量值：在末尾添加 ;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

DOS常用命令：
	Dir：列出工作目录的子文件夹
	cd：切换工作路径
	mkdir：新建文件夹
	rd：删除文件夹（空文件夹）
	echo：写文件（echo 123->test.txt）
	del：删除文件
	cls：清空屏幕
	exit：退出（如MySQL）
	
Java编译执行工具：
	编译：javac
	执行：java
	
Java语言规范：
	类：
		 a.	同一个源文件中可以定义多个类。
		 b.	编译后，每个类都会生成独立的 .class 文件。
		 c.	一个类中，只能有一个主函数，每个类都可以有自己的主函数。
		 d.	public 修饰的类称为公开类，要求类名必须与文件名称完全相同，包括大小写。
		 e.	一个源文件中，只能有一个公开类。
	包：
		声明：package 包名;
		作用：归纳、整理、管理 .class 文件（为字节码文件添加前缀）
		带包编译：javac -d.sourceName.java
		带包运行：java PackageName.ClassName
		规则：域名倒置（从大到小）
	注释：
		单行注释：
		多行注释：
		文档注释：
		生成外部文档：javaoc -d . HelloWorld.java
	标识符命名：
		I. 语法规定：
		   a) 可以由：字母、数字、_ 、$ 组成，但不能以数字开头。
		   b) 不能与关键字，保留字重名。
		II. 约定俗成：
		   a) 望文生义、见名知义。
		   b) 类名由一个或多个单词组成，每个单词首字母大写。
		   c) 函数名、变量名由一个或多个单词组成，首单词、首字母小写，拼接词首字母大写。
		   d) 包名全小写，只可以使用特殊字符 “.” ，并且不以 “.” 开头或结尾。
		   e) 常量全大写，多个单词用 _ 连接。
*/