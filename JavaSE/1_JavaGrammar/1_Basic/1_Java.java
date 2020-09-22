/*
========================================
----------------------------------------
Java特点：
	1.面向对象（封装、继承、多态）
	2.平台无关性（JVM）
    3.内置GC
    4.多线程
    5.网络编程
    6.编译、解释并存

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

JVM、JDK与JRE：
    JVM：运行java字节码的虚拟机，不同系统特定实现，使相同字节码产生相同结果。
        java源代码->运行 的过程：
            1..java源文件由JDK中的javac编译生成.class字节码文件。
            2..class字节码文件通过JVM生成可执行二进制文件。
    JDK：Java SDK，Java创建、编译环境。
    JRE：Java运行环境。

Java和C++：
    1.Java只支持OOP，C++同时支持POP和OOP。
    1.Java不支持直接访问内存，安全但低效。
    2.Java单继承，C++支持多继承，Java接口可以多继承。
    3.Java有GC机制，C++需要手动释放内存。
    4.C语言字符串或字符数组末尾'\0'。

Java主类：
    一个源文件可定义多个类，但只能存在一个主类（包含main方法），当类声明为public时，类名须与源文件名一致。

Java编译型与解释型并存：
    1.JDK将源文件编译为字节码文件。
    2.字节码文件运行时JVM将其解释。

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

DOS常用命令：
	Dir：列出工作目录的子文件夹
	cd：切换工作路径
	mkdir：新建文件夹
	rd：删除文件夹（空文件夹）
	echo：写文件（echo 123->test.txt）
	del：删除文件
	cls：清空屏幕
    exit：退出（如MySQL）
	
字符型常量与字符串常量：
	1.字符型常量由单引号引起的一个字符，字符串常量由双引号引起的0个字符或n个字符。
	2.字符常量相当于一个整型值（ASCII），字符串常量代表一个地址（字符串首地址）。
	3.字符常量占两个字节，字符串占2n个字节。
	注：字符封装类 Character成员常量 Character.SIZE 值为16(bits)，2字节。

Java数据类型：
	1.基本数据类型：
		基本数据类型占内存的大小固定，不随硬件平台变化而变化，保证移植性。
		boolean(Boolean)：-
		bite(Byte)：8bits
		char(Character)：16bit
		short(Short)：16bits
		int(Integer)：32bits
		long(Long)：64bits
		float(Float)：32bits
		double(Double)：64bits
		void(Void)：-

标识符与关键字的区别：
	关键字：语言本身对其赋予特殊含义，特定情况下使用。
	标识符：名称、标记。

自增、自减运算符：
	前置：先自增或自减再参与运算。
	后置：先自增或自减再参与运算。

continue、break、return：
	contnue：结束本次循环，进入下次循环。
	break：跳出循环。
	return：
		1.return;	//结束当前函数(无返回值)。
		2.return returnValue;	//返回函数返回值

Java泛型与类型擦除、通配符：
	Java泛型（模板，伪泛型）：
		多种数据类型执行相同的代码，具体类型在使用时指定。
		泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
			1.泛型类
			2.泛型接口
			3.泛型方法
	类型擦除：
		Java的泛型是伪泛型，即Java泛型仅在编译期有效，运行期被擦除。（与C++泛型的区别）
	通配符：
		常用的通配符为： T，E，K，V，？
		1. ？：表示不确定的 java 类型
		2. T (type) ：表示具体的一个java类型
		3. K V (key value) ：分别代表java键值中的Key Value
		4. E (element) ：代表Element

==与equals()区别：
	==：
		Java只有值传递，对于基本数据类型比较值，对于引用对象（引用对象存的值是对象的地址）比较地址。
	equals() : 
		判断两个对象是否相等，不能用于比较基本数据类型的变量。equals()方法存在于Object类中，而Object类是所有类的直接或间接父类。
		Object类equals()方法：
			public boolean equals(Object obj) {
				return (this == obj);
			}
	equals() 使用：
		情况 1：类没有覆盖（重写） equals()方法。默认使用Object类equals()方法，等价于通过“==”比较这两个对象。。
		情况 2：类覆盖（重写）了 equals()方法。重写equals()方法以比较两个对象的内容相等；是则返回 true(即，认为这两个对象相等)。
	注：String类对equals()进行了重写。

hashCode()与 equals()：
	什么是hashCode()？
		获取哈希码（散列码），一个int整数，确定该对象在哈希表中的索引位置。
		定义在Object类中，使用C或C++实现，将对象在内存中的位置转换为整数后返回。
		//public native int hashCode();
	hashCode()的作用？
		hashSet（散列表）存储键值对，实现快速查找。
		例：使用hashSet（散列表）检查对象是否重复？
			将对象存入hashSet时，hashSet获取该对象的hashCode与已有hashCode进行比较，如hashCode相同，再调用equals()比较是否为同一对象，
			是则不存入hashCode；否则将该对象散列到其它位置。以此减少equals()次数，提高执行效率。

			




----------------------------------------
========================================
*/

//Object类equals()方法：
public boolean equals(Object obj) {
	return (this == obj);
}

//String类对equals()进行了重写：
public boolean equals(Object anObject) {
	if (this == anObject) {
		return true;
	}
	if (anObject instanceof String) {
		String anotherString = (String)anObject;
		int n = value.length;
		if (n == anotherString.value.length) {
			char v1[] = value;
			char v2[] = anotherString.value;
			int i = 0;
			while (n-- != 0) {
				if (v1[i] != v2[i])
					return false;
				i++;
			}
			return true;
		}
	}
	return false;
}

