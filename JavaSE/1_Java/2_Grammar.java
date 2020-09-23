/*
========================================
----------------------------------------
【Java语法基础】
一、Java数据类型：
	1.基本数据类型（整型4、浮点型2、布尔型1、字符型1）：
		基本数据类型占内存的大小固定，不随硬件平台变化而变化，保证移植性。
		[数据类型]	 [包装类]		[大小/位]	[默认初始值]	[使用]
		bite		(Byte)			8			0
		short		(Short)			16			0
		int			(Integer)		32			0
		long		(Long)			64	  		0L			  long l1 = 9223372036854775807L
		float		(Float)			32		 	0.0f	 	  float f = 1.2F
		double		(Double)		64			0.0
		boolean		(Boolean)		-			false
		char		(Character)		16			'\u0000'
		注：
			boolean类型逻辑上占1位，但官方文档未明确，依赖于JVM厂商具体实现（考虑计算机高效存取因素）。
			char类型是单一的 16 位 Unicode 字符。
    2.引用数据类型：
        数组：
        类：
		接口：
	3.类型转换：
		自动类型转换：
			a)	两种类型相互兼容
			b)	目标类型大于原类型
				float f = 3.5F;
				double d = f;
		强制类型转换：
			a)	两种类型相互兼容
			b)	目标类型小于原类型		
				short s2 = 128;
				byte b2 = (byte)s2;
	4.自动装箱与拆箱：
		装箱：将基本类型用它们对应的引用类型包装起来；
		拆箱：将包装类型转换为基本数据类型；
	5.基本数据类型的包装类的常量池：
		常量池技术：
			Byte,Short,Integer,Long包装类默认创建了数值[-128，127] 的相应类型的缓存数据。
			Character创建了数值在[0,127]范围的缓存数据。
			Boolean 返回True Or False。
			如果超出对应范围将会创建新的对象。
		例：
			Integer i1=40；Java 在编译时将其封装成 Integer i1=Integer.valueOf(40); ，从而使用常量池中的对象。
			Integer i1 = new Integer(40);创建新的对象。
			+运算符不适用于Integer包装类，会对Integer对象自动拆箱。
    	注：缓存池设定[-128，127]区间的依据是什么？
		
二、字符型常量与字符串常量：
	1.字符型常量由单引号引起的一个字符，字符串常量由双引号引起的0个字符或n个字符。
	2.字符常量相当于一个整型值（ASCII），字符串常量代表一个地址（字符串首地址）。
	3.字符常量占两个字节，字符串占多个字节。
	注：字符封装类 Character成员常量 Character.SIZE 值为16(bits)，2字节。

三、变量
	局部变量：
	类变量（静态变量）：
	成员变量（非静态变量）：

四、枚举
	定义：枚举限制变量使用预先设定好的值。
	声明与定义：enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }

五、分支、选择、循环结构
	1.分支结构：
		if(..){...};
		if(..){...}else{...};
		if(..){...}else if(..){...}else{...};
	2.选择结构：
		switch(expression){
			case value1 :
				doSomething();
				break; 
			case value2 :
				doSomething();
				break; 
			default : 
		}
	3.循环结构：
		do{...}while(..);
		while(..){...};

六、函数（方法）
	返回值：
		有返回值：返回值数据类型（方法体通过 return 返回方法执行结果）
		无返回值：void
	形参与实参：
		对于基本数据类型：形参对实参进行值的拷贝，方法体内修改形参不会影响实参。
		对于引用数据类型：实参引用变量的值是其引用对象的地址，而形参拷贝了实参的值（对象地址），因此可对实参进行修改。
	
七、深拷贝与浅拷贝：
    深拷贝：对基本数据类型进行值传递，对引用类型创建新的对象并复制其值。
    浅拷贝：对基本数据类型进行值传递，对引用类型进行引用传递般的拷贝。

八、continue、break、return：
	contnue：结束本次循环，进入下次循环。
	break：跳出循环。
	return：
		1.return;	//结束当前函数(无返回值)。
		2.return returnValue;	//返回函数返回值

九、Java关键字
	访问控制：
		private：类内可见，使用对象：变量、方法。注意：不能修饰类（外部类）。
		protected：同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
		public：对所有类可见。使用对象：类、接口、变量、方法。
		default：同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
	类、方法、变量修饰符：
		abstract：创建抽象类和抽象方法。
			修饰类：abstract与final不能同时修饰一个类，抽象类无法被实例化，用于子类继承扩展。
			抽象方法：abstract与final、static不能同时修饰一个方法，父类抽象方法由非抽象子类实现。
		class：类
		extends：继承
		final：
			修饰类：不能被继承，其中所有方法隐式指定为final方法。
			修饰方法：可以被继承，无法被重写（防止修改）。
			修饰变量：变为常量，基本数据类型一经初始化无法修改，引用类型无法更改指向。
			注：private方法隐式指定为final。
		implements：实现（接口）
		interface：接口
		native：本地，原生方法（非 Java 实现）
		new：创建对象
		static：
			静态成员变量（对象共享）和静态成员方法（不调用非静态成员）：存放于堆（JDK8之前存放在方法区，JDK8元空间取代永久代，常量池、静态成员（反射数据：与类相关，与实例无关）迁移至堆）。
			静态代码块（类中方法体外）：早于非静态方法执行，只执行一次。
			静态内部类：不依赖外围类创建，不使用外围类的非静态成员。
			静态导包：import static指定导入静态资源，无须使用类名调用。
		strictfp		严格,精准
		synchronized：声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。
		transient：在已序列化的类中使变量不序列化（生命周期缩短为程序运行周期，而非存储在磁盘中）。
		volatile：修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值；当成员变量发生变化时，会强制线程将变化值回写到共享内存；确保多线程访问的值一致。
	程序控制语句：
		instanceof：实例
	错误处理：
		assert			断言表达式是否为真
		catch			捕捉异常
		finally			有没有异常都执行
		throw			抛出一个异常对象
		throws			声明一个异常可能被抛出
		try				捕获异常
	包相关：
		import：
		package：
	基本类型：
	变量引用：
		super：访问父类（超类）成员。
		this：访问当前类的成员。
		void：无返回值	
	    注：
			1.子类构造器中使用super调用父类构造器时，该语句应位于构造器首行。
			2.this调用本类其它构造器时，该语句应位于构造器首行。
			3.super、this不能用于静态方法（属于类）。（super指向父类对象，this指向本类对象）
	保留关键字：
		goto			
		const	
		null	
	
十、运算符
	算术运算符：
	关系运算符：
	位运算符：
	逻辑运算符：
	赋值运算符：
	其他运算符：
		条件运算符（三元运算符）：
		instanceof 运算符：该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。使用：( Object reference variable ) instanceof  (class/interface type)
	
十一、Num & Math 类
	Number类：
		包括子类包装类（Integer、Long、Byte、Double、Float、Short）。
	Math类：
		Math包含了用于执行基本数学运算的属性和方法（static），如初等指数、对数、平方根和三角函数。
	常用类方法：

十二、Character 类
	转义序列：前面有反斜杠（\）的字符代表转义字符（针对编译器）。
		转义序列	描述
		\t	在文中该处插入一个tab键
		\b	在文中该处插入一个后退键
		\n	在文中该处换行
		\r	在文中该处插入回车
		\f	在文中该处插入换页符
		\'	在文中该处插入单引号
		\"	在文中该处插入双引号
		\\	在文中该处插入反斜杠
	常用类方法：

十三、String 类
	特点：一经创建，无法改变 String 对象。
	常用类方法：

十四、Java StringBuffer 和 StringBuilder 类
	特点：StringBuffer 和 StringBuilder 类的对象能够多次修改，并且不产生新的未使用对象。
	区别：
		StringBuilder（Java 5）线程不安全（不能同步访问）、速度快。
		StringBuffer线程安全、速度慢。

十五、数组与Array类
	数组：
		定义：dataType[] arrayRefVar = new dataType[arraySize];	或	dataType[] arrayRefVar = {value0, value1, ..., valuek};
		for_each遍历：for(type element: array) { System.out.println(element); }
	Array类：
		包：java.util.Arrays，提供静态方法。
		成员方法：
			fill：数组赋值
			sort：数组排序（升序）
			equals：比较数组是否相等（元素）
			binarySearch：二分查找（数组须有序）

十六、Date类
	构造函数：
		Date( );	使用当前日期和时间初始化对象。
		Date(long millisec);	接收一个参数，该参数是从1970年1月1日起的毫秒数。

----------------------------------------
常量池：
Integer i1 = 40;
Integer i2 = 40;
Integer i3 = 0;
Integer i4 = new Integer(40);
Integer i5 = new Integer(40);
Integer i6 = new Integer(0);

System.out.println("i1=i2   " + (i1 == i2));
System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
System.out.println("i1=i4   " + (i1 == i4));
System.out.println("i4=i5   " + (i4 == i5));
System.out.println("i4=i5+i6   " + (i4 == i5 + i6));   
System.out.println("40=i5+i6   " + (40 == i5 + i6));     

结果：
    i1=i2   true
    i1=i2+i3   true
    i1=i4   false
    i4=i5   false
    i4=i5+i6   true
    40=i5+i6   true
----------------------------------------

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

hashSet（散列表）：
	由数组、

hashCode()与 equals()：
	什么是hashCode()？
		获取哈希码（散列码），一个int整数，确定该对象在哈希表中的索引位置。
		定义在Object类中，使用C或C++实现，将对象在内存中的位置转换为整数后返回。
		散列表存储键值对，实现快速查找。
		//public native int hashCode();
	hashCode()的作用？
		例：使用hashSet检查对象是否重复？
			将对象存入hashSet时，hashSet获取该对象的hashCode与已有hashCode进行比较，如果hashCode相同，再调用equals()比较是否为同一对象，
			是则不存入hashCode，否则存入当前hashCode下；如果hashCode相同，则将该对象散列到其它位置。以此减少equals()次数，提高执行效率。
	为什么重写equals()时必须重写hashCode()？
		对象相等，hashCode相同；hashCode相同，对象不一定相等。
		hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写 hashCode()，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）
	为什么两个对象有相同的 hashcode 值，它们也不一定是相等的？
		hashCode采用的杂凑算法的优劣决定具有相同杂凑值的对象数量。
		hashCode仅用于减小查找成本。
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
