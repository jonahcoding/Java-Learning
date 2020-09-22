/*
========================================
----------------------------------------

Java数据类型：
    1.基本数据类型（包装类、占用大小）：
        基本数据类型占内存的大小固定，不随硬件平台变化而变化，保证移植性。
        整形（4种）：
            bite(Byte)：8bits       
            short(Short)：16bits
            int(Integer)：32bits
            long(Long)：64bits  （long l1 = 9223372036854775807L）
        浮点型（2种）：
            float(Float)：32bits    （float f = 1.2F）
            double(Double)：64bits
        布尔类型（1种）：
            boolean(Boolean)：-
        字符类型（1种）：
            char(Character)：16bit
    2.引用数据类型：
        数组：
        类：
        接口：
    注：boolean类型逻辑上占1位，但官方文档未明确，依赖于JVM厂商具体实现（考虑计算机高效存取因素）。

类型转换：
    1.自动类型转换：
        a)	两种类型相互兼容
        b)	目标类型大于原类型
            float f = 3.5F;
            double d = f;
    2.强制类型转换：
        a)	两种类型相互兼容
        b)	目标类型小于原类型		
            short s2 = 128;
            byte b2 = (byte)s2;

自动装箱与拆箱：
    装箱：将基本类型用它们对应的引用类型包装起来；
    拆箱：将包装类型转换为基本数据类型；

基本数据类型的包装类与常量池：
    常量池技术：
         Byte,Short,Integer,Long包装类默认创建了数值[-128，127] 的相应类型的缓存数据。
         Character创建了数值在[0,127]范围的缓存数据。
         Boolean 直接返回True Or False。
         如果超出对应范围仍然会去创建新的对象。 为啥把缓存设置为[-128，127]区间？
    例：
        Integer i1=40；Java 在编译时将其封装成 Integer i1=Integer.valueOf(40); ，从而使用常量池中的对象。
        Integer i1 = new Integer(40);创建新的对象。
        +运算符不适用于Integer，会对Integer对象自动拆箱。
    注：缓存池设定[-128，127]区间的依据是什么？
----------------------------------------
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
========================================
*/
    
