/*
========================================
----------------------------------------
字符型常量与字符串常量：
	1.字符型常量由单引号引起的一个字符，字符串常量由双引号引起的0个字符或n个字符。
	2.字符常量相当于一个整型值（ASCII），字符串常量代表一个地址（字符串首地址）。
	3.字符常量占两个字节，字符串占2n个字节。
	注：字符封装类 Character成员常量 Character.SIZE 值为16(bits)，2字节。

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
