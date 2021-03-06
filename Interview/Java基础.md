### 程序、进程、线程的基本概念与相互之间的关系

#### 程序

> 一组计算机可执行指令的有序集合（存储在磁盘或其他存储设备中）。
>
> 程序是静态的实体。

#### 进程

> 一个具有独立功能的程序在某个数据集合上的执行过程。
>
> 程序执行过程中系统进行资源分配和管理的最小单位。
>
> 进程是动态的实体。

#### 线程

>  独立调度和执行的基本单位，进程的实际运作单位 。
>
> 进程在执行过程中产生多个线程，同一进程的多个线程共享进程资源。

联系：一个运行中的程序至少有一个进程，一个进程至少有一个线程。

### Java语言特点

1. 面向对象：封装、继承、多态。
2. 平台无关性：JVM实现；基本类型大小固定，不随硬件架构变化。
3. 编译与解释并存：半编译型，最终执行代码非CPU可直接执行的二进制机器码（性能弱）。
4. 自动内存管理
5. 支持多线程与网络编程

### 面向过程与面向对象

**面向过程**：性能优于面向对象（调用类实例化需要消耗资源）；多用于单片机、嵌入式、Unix/Linux。

**面向对象**：易维护、易复用、易扩展。（低耦合）

### ==、equals()和hashCode()

#### ==

> 判断两个对象是否相等；对于引用类型比较内存地址（是否是同一个对象），对于基本类型比较值。

#### equals()

> 判断两个对象内容是否相同；未重写equals()时比较对象地址（等价于==）。

注：String类中的equals()已被重写；创建String对象时先在常量池中查找是否有已存在的值与待创建的值相同的对象，有则引用，没有则在常量池中新建String对象。

#### hashCode()

> 作用：根据对象的地址获取哈希码（散列码，一个int整数），确定对象在哈希表（散列表）中的索引位置。
>
> 定义在JDK的Object.java中，任何类都有hashCode()。
>
> 散列表存储键值对，可根据key快速检索出对应的value。

#### HashSet如何检查重复

> 对象加入HashSet后，HashSet计算该对象的hashcode值来判断对象应加入的位置：与其他已加入的对象的hashcode值比较，如有相同hashcode值则调用equals()方法检查对象内容是否相同，如果内容相同则不加入，如果内容不同，则重新散列到其他位置。如果没有与该对象相同的hashcode值，则加入成功。

#### 为什么在重写equals方法的时候要重写hashCode的方法

> 新加入对象，先根据hashCode()判断，再根据equals()判断。如果只重写equals()而不重写hashCode()，会产生hashcode值不同但equals()值判断结果为true的情况。
>
> Java的某些容器中，不允许有两个（内容）完全相同的对象，插入对象时判断相同则覆盖。如果只重写equals()而不重写hashCode()会造成（内容）相同对象散列到不同位置。

#### 如何重写equals()和hashCode()

```java
@Override
public int hashCode() {
    int hash = 1;
    hash = hash * 17 + id;
    hash = hash * 31 + department.hashCode();
    return hash;
}
@Override
public boolean equals(Object obj) {
    if (obj == null)
        return false;
    if (obj == this)
        return true;
    if (obj instanceof SimpleDemo) {
        SimpleDemo sd = (SimpleDemo) obj;
        return sd.department.equals(department) && sd.id == id;
```

### JVM、JDK、JRE

#### JVM

> Java虚拟机（JVM）是运行 Java 字节码的虚拟机。JVM有针对不同系统的特定实现（Windows，Linux，macOS），目的是使用相同的字节码，产生相同的结果。 （Java不需要在不同OS上重新编译）

#### JDK

> 包括JRE、编译器（javac）和工具（javadoc和jdb）。Java编译环境，创建和编译程序。

#### JRE

> 包括JVM、Java类库、Java命令和其他基础组件。Java运行环境，运行已编译的Java程序。

### Java与C++区别

1. Java不提供指针来直接访问内存，内存安全。
2. Java类单继承，C++支持多重继承；但Java接口可以多继承。
3. Java有自动内存管理机制，无需开发人员手动申请、释放内存。

### 基本类型

#### 字符型常量与字符串常量的区别

字符常量：单引号引起的一个字符；相当于一个整型值（ASCII值），可参与运算；占两个字节。

字符串常量：双引号引起的若干个字符；代表地址值（字符串对象在内存中的位置）；若干字节（一个结束标志）

|  基本类型  | boolean | byte |   char    | short |   int   | long | float | double | void |
| :--------: | :-----: | :--: | :-------: | :---: | :-----: | :--: | :---: | :----: | :--: |
| 大小(字节) |  ----   |  1   |     2     |   2   |    4    |  8   |   4   |   8    | ---- |
|  包装类型  | Boolean | Byte | Character | Short | Integer | Long | Float | Double | Void |

#### 自动装箱与拆箱

- 装箱：基本数据类型使用对应的引用类型包装。
- 拆箱：将包装类型转换为基本数据类型。

#### &与&&的区别

1. 都可用作运算与的操作符，表示逻辑与（and）；表达式两边都为true时结果才为true，否则为false。
2. &&有短路功能：第一个表达式为false时，不再计算第二个表达式。
3. &可用作位运算符：左右两边表达式非boolean类型时，&表示按位与操作（通常使用0x0f取低四位）。

#### 隐式类型转换

①short s1 = 1; s1 = s1 + 1; ②short s1 = 1; s1 += 1;

- ①中的s1+1自动提升类型为int，无法赋值再给short型的s1：强制类型转换错误。

- ②中的+=为Java语言规定的运算符，特殊处理，可以编译成功。

说明：Java不能隐式执行向下转型，会使精度降低。

```java
public class TypeConvert {
    public static void main(String[] args) {
        // Java不能隐式执行向下转型，会使精度降低。
        // 字面量1.1属于double类型，不能直接赋值给float。
        // float f = 1.1;
        float f = 1.1f;
        // 字面量1属于int类型，不能隐式地将int类型下转型为short类型。
        short s1 = 1;
         // s1 = s1 + 1;
        // +=运算符执行隐式类型转换：
        s1 += 1;
        // 显式向下转型
        s1 = (short) (s1 + 1);
}
```

#### char变量是否可以存储一个汉字

- char型变量用来存储Unicode编码的字符，而Unicode编码字符集中包含了汉字，故char型变量可以存储汉字
- 未包含在Unicode编码集中的特殊汉字，不能使用char型变量存储。
- Unicode编码和char类型的变量都占用两个字节，

#### 整形包装类缓存池

```java
public class IntegerPackDemo {
  public static void main(String[] args) {
    Integer x = 3; 	// 装箱
    int z = x; 		// 拆箱
    Integer y = 3;
    System.out.println(x == y); // true
    // -------------------------
    Integer a = new Integer(3);
    Integer b = new Integer(3);
    System.out.println(a == b); // false，==对于引用类型比较内存地址。
    System.out.println(a.equals.(b)); // true，重写了equals方法，比较值，而非对象地址。
    // ------------------------
    // 缓存池
    Integer aa = Integer.valueOf(123);
    Integer bb = Integer.valueOf(123);
    System.out.println(aa == bb); // true，123未超出缓存池的范围
    /**
    * valueOf的源码
    * public static Integer valueOf(int i) {
    *      // 判断是否在Integer的范围内
    *     if (i >= IntegerCache.low && i <= IntegerCache.high)
    *         return IntegerCache.cache[i + (-IntegerCache.low)];
    *     return new Integer(i);
    * }
    */
  }
}
```

使用自动装箱方式创建一个Integer对象，当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，当下次再出现该数值时，直接从缓存中取出对应的Integer对象。所以上述代码中，x和y引用的是相同的Integer对象。

### 面向对象

#### 封装、继承、多态

**封装**

> 属性私有化，提供外界可访问的方法操作属性。

**继承**

> 使用已存在的类的定义作为建立新类的基础，新类增加新的属性（数据）和方法（功能），实现复用。无法选择性地继承父类。
>
> 子类拥有父类的所有属性和方法（构造方法除外），但无法访问父类的私有属性和方法（仅拥有）。
>
> 子类可对父类进行扩展。
>
> 子类可重写父类方法。

**多态**

> **程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定**，即一个引用变量到底会指向哪个类的实例对象，该引用变量的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。 
>
> Java中实现多态的方式：继承（多个子类重写同一方法）、接口（实现接口并覆盖接口中同一方法）。

#### 构造器是否可被override（重写）

子类不会继承父类的构造器，所以无法重写构造器。但可以拥有自己的构造器。

#### 构造方法的特性

1. 方法名与类名相同。
2. 无返回值，不使用void声明。
3. 创建类的对象时自动执行，无需手动调用。

#### 接口与抽象类的区别

**设计层面：抽象是对类的抽象，是一种模板设计；接口是对行为的抽象，是一种行为的规范。**

**接口**

> JDK8之前：抽象方法（public abstract，不提供实现）+ 全局静态常量（public static final）。
>
> JDK8之后新增：default方法（提供实现，实现类的对象调用），static方法（实现，接口调用）。
>
> 无构造函数。

**抽象类**

> 可定义普通成员变量、普通成员方法和构造函数。
>
> 抽象方法：public、protected和default修饰（不提供抽象方法的实现，无private方法）。

注：一个类同时实现两个接口并且两个接口定义了相同的默认方法，则该方法必须重写。

**接口与抽象类的选择**

> 接口用来定义一组规范的方法，更改需求时只修改实现类。
>
> 如果多个实现类中有相同可复用的代码，可在实现类与接口之间添加抽象类，抽出公共代码放在抽象类中。

#### 成员变量与局部变量的区别

1. 成员变量属于类（或类的实例）（private、public、static及final修饰），局部变量属于方法（final修饰）。
2. 成员变量存储在堆内存，局部变量存储在栈内存。
3. 成员变量默认初始化，局部变量不会默认初始化。

#### 重载与重写

**重载**

> 同一个类中方法名相同，参数类型、个数、顺序不同，方法返回值和访问修饰符可以不同。

**重写**

> 在子类中对父类允许访问的方法重新编写，仅改变方法行为：方法名、参数列表相同，返回值范围小于等于父类，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。

#### 对象实体与对象引用

1. new运算符创建对象实例，对象引用指向对象实例。
2. 对象实例存储在堆内存，对象引用存储在栈内存。
3. 对象引用可指向0个或1个对象，1个对象可以有n个引用。

#### 对象相等与引用相等

对象是否相等比较对象的内容，引用是否相等比较指向的内存地址。

### 值传递

值传递：向方法传递变量的值，对值参数的操作不会更改原有变量（基本数据类型：数值型或布尔型）的值。

引用传递：向方法传递变量的地址值，对引用参数的操作会改变原有变量的值。

```java
// 借助数组实现swap
public static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp; 
}
```

### String

#### String、StringBuffer、StringBuilder的区别，String为什么不可变

可变性

> String类使用final关键字修饰字符数组来保存字符串`private final char value[]`，String对象不可变。
>
> StringBuffer和StringBuilder都继承自AbstractStringBuilder类，使用`char[] value`保存数组，故可变。

线程安全性

> String对象不可变，即为常量，线程安全。
>
>  StringBuffer对方法加了同步锁，故线程安全。
>
> StringBuilder未对方法加同步锁，故线程不安全（不能同步访问）。

性能

> 对String类型的对象改变时，产生新的String对象并将原有指针指向新的String对象（效率低、浪费内存）。
>
> StringBuffer对对象本身进行操作，不产生新的对象（超过缓冲区容量后自动扩容）。
>
> StringBuilder在Java5中提出，非线程安全故速度优于StringBuffer。

**总结**

- **String：不可变字符序列（final修饰，操作时创建新对象）、效率低、线程安全（常量）。**
- **StringBuffer：可变字符序列、效率低（不能同步访问）、线程安全（方法加入同步锁synchronized）。**
- **StringBuilder：可变字符序列、效率高、线程不安全。**

**使用**

1. **操作少量数据：String。**
2. **单线程下操作大量数据：StringBuilder。**
3. **多线程下操作大量数据：StringBuffer。**

```java
public static void main(String[] args) {
    // String
    String str = "hello";
    long start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
        str += i; // 创建多少个对象，，
    }
    System.out.println("String: " + (System.currentTimeMillis() - start));

    // StringBuffer
    StringBuffer sb = new StringBuffer("hello");
    long start1 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        sb.append(i);
    }
    System.out.println("StringBuffer: " + (System.currentTimeMillis() - start1));


    // StringBuilder
    StringBuilder stringBuilder = new StringBuilder("hello");
    long start2 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        stringBuilder.append(i);
    }
    System.out.println("StringBuilder: " + (System.currentTimeMillis() - start2));
}
```

#### String A = "123"; String B = new String("123");生成几个对象？

如果常量池中存在"123"，则创建一个对象；如果不存在，则创建两个对象。

#### String.intern()方法

```java
public class StringTest {
	public static void main(String[] args) {
        String str1 = "todo";
        String str2 = "todo";
        String str3 = "to";
        String str4 = "do";
        String str5 = str3 + str4;
        String str6 = new String(str1);
 
        System.out.println("------普通String测试结果------");
        System.out.print("str1 == str2 ? ");
        System.out.println( str1 == str2);
        System.out.print("str1 == str5 ? ");
        System.out.println(str1 == str5);
        System.out.print("str1 == str6 ? ");
        System.out.print(str1 == str6);
        System.out.println();
 
        System.out.println("---------intern测试结果---------");
        System.out.print("str1.intern() == str2.intern() ? ");
        System.out.println(str1.intern() == str2.intern());
        System.out.print("str1.intern() == str5.intern() ? ");
        System.out.println(str1.intern() == str5.intern());
        System.out.print("str1.intern() == str6.intern() ? ");
        System.out.println(str1.intern() == str6.intern());
        System.out.print("str1 == str6.intern() ? ");
        System.out.println(str1 == str6.intern());
	}
}
```

运行结果

```java
------普通String测试结果------
str1 == str2 ? true
str1 == str5 ? false
str1 == str6 ? false
---------intern测试结果---------
str1.intern() == str2.intern() ? true
str1.intern() == str5.intern() ? true
str1.intern() == str6.intern() ? true
str1 == str6.intern() ? true
```

**普通String分析**

编译完成后，class文件会在字符串常量池中保存"todo"、"to"和"do"三个String常量。变量str1和str2保存的是常量池中"todo"的引用，故str1==str2成立；**执行str5 = str3 + str4 时，JVM先创建一个StringBuilder对象，然后使用StringBuilder.append()方法将str3与str4拼接，再通过StringBuilder.toString()方法返回一个String对象的引用赋给str5，**故str1 == str5 不成立；String str6 = new String(str1)显式创建了新的对象，故str1 == str6 不成立。

**intern分析**

String.intern()是一个Native方法（调用C++的StringTable::intern()方法实现）。**通过str.intern()调用intern()后，JVM在当前类的常量池查找是否存在与str等值的String，存在则返回常量池中相应String的引用，不存在则在常量池中创建一个等值的String并返回它的引用。**因此，等值的String对象使用intern()方法均返回常量池中同一个String的引用，等值的String对象通过intern()后可使用==匹配。

补充

JDK6中，字符串常量池位于永久代（PermGen，一块主要用于存放已加载的类信息和字符串池的大小固定的区域）中。执行intern()方法时，若常量池中不存在等值字符串。**JVM会在字符串常量池中创建一个等值的字符串，然后返回该字符串的引用。**此外，JVM自动在常量池中保存一份之前已使用的字符串合集。存在的问题：①永久代大小固定，不能对不受控制的运行时字符串（用户输入）使用intern()方法，否则可能引发PermGen内存溢出；②String对象保存在堆区，Java堆区与PermGen物理隔离，对多个不等值的字符串对象执行intern()操作，导致内存中存在许多重复的字符串，造成内存损失。

JDK7中，常量池从PermGen转移到堆区，执行intern操作时，**如果字符串常量池已存在该字符串，则直接返回字符串引用，否则复制该字符串的引用到常量池并返回。**常量池不再受固定大小的限制，此外，位于堆区的常量池中的对象可以被垃圾回收（常量池中的字符串不再有指向它的引用时，JVM进行回收）。使用-XX:StringTableSize虚拟机参数可设置常量池的map大小。字符串常量池内部实现为一个HashMap，在确定程序中需要intern()的字符串数目时，可将map的size设为所需数目*2（减少哈希冲突），节省内存、提高效率。

使用

intern()的优点：执行速度快、直接使用==判断快去equals()方法；内存占用少。

### 关键字

#### final

**修饰变量、方法、类。**

1. final变量：基本类型，初始化数值后无法更改；引用类型，初始化后无法（更改）指向其他对象。
2. final类：无法被继承，类中的所有成员方法隐式指定为final方法。
3. final方法：①锁定方法，防止继承子类修改；②内嵌调用提高效率（Java早期版本）。类的private方法隐式指定为final。

**优点**

1. 提高性能，JVM和Java应用会缓存final变量。
2. final在多线程下安全。
3. 使用final关键字提高性能，JVM对方法变量类进行优化。

#### static

1. 修饰成员变量与成员方法：属于类，被类的所有对象共享，通过类名调用，静态变量存放在方法区。静态方法只能调用静态方法或静态变量。
2. 静态代码块：定义在类中方法外，静态代码块在非静态代码块之前执行，并且静态代码块只执行一次。
3. 静态内部类（static修饰类时只能修饰内部类）：非静态内部类编译后隐含保存一个引用，该引用指向它的外围类；静态内部类没有指向外围类的引用，即静态内部类的创建不依赖于外围类的创建，也无法使用外围类的非静态成员变量和方法。
4. 静态导包（导入类中的静态资源，JDK1.5）：`import static`导入某个类中的指定静态资源，直接使用类中静态成员变量和成员方法（无需通过类名调用）。

#### this

**含义**：当前对象的引用。

**使用**

1. 访问类的当前实例的变量。
2. 调用类的当前实例的方法。

#### super

**含义**：父类对象的引用。

**使用**

1. 访问父类对象的成员变量。
2. 调用父类对象的成员方法。

注

> 在构造器中使用super()调用父类构造方法时，该语句应位于构造器首行。this调用本类的构造方法时也应放在首行。
>
> static方法属于类，不定出现this与super。

#### final、finally和finalize的区别

- final：属性不可变、方法不可覆盖、类不可继承。内部类访问外围类的局部变量，局部变量应为final类型。
- finally：异常结构的一部分，必将执行的语句。
- finalize：Object类的方法，垃圾收集器执行时调用被回收对象的此方法，可重写以提供对其他资源的回收，如关闭文件。JVM不保证一定调用此方法。（没什么鸟用）

#### 作用域public、protected、friendly和private

| 作用域    | 当前类 | 同package | 子类 | 其他package |
| --------- | ------ | --------- | ---- | ----------- |
| public    | √      | √         | √    | √           |
| protected | √      | √         | √    | ×           |
| friendly  | √      | √         | ×    | ×           |
| private   | √      | ×         | ×    | ×           |

### 异常处理

所有异常继承自java.lang包中的Throwable类。Throwable的子类：Exception（异常）和Error（错误）。

#### Error

**程序无法处理的错误，表示代码运行时JVM（Java虚拟机）自身出现的问题。**如StackOverFlowError（栈溢出）、OutOfMemoryError（内存溢出），JVM将终止线程。

#### Exception

**程序本身可处理的异常。**Exception类的子类RuntimeException，RuntimeException异常由JVM抛出：NullPointerException（空指针）、ArithmeticException（算术运算异常）和 ArrayIndexOutOfBoundsException（下标越界异常）。 

#### 异常处理

- **try块**：用于捕获异常，可接多个catch；如无catch块时，必须接finally块。
- **catch块**：用于处理try捕获到的异常。
- **finally块**：无论异常处理与否都将执行的语句，当try或catch块中遇到return语句时，finally语句块将在方法返回前被执行。

**finally块不会执行的四种情况**

1. finally块第一句发生异常。
2. 在finally块之前执行了System.exit(int)已退出程序。
3. 程序所在的线程死亡。
4. 关闭了CPU。

注：当try块和finally块都有return语句时，在方法返回之前，finally语句的内容将被执行，并且finally语句的返回值会覆盖原始的返回值。

#### Throwable结构

Throewable

- Error
  - VirtulMachineError（栈溢出、内存溢出）
  - AWTError（ Abstract Window Toolkit ：抽象窗口工具包）
- Exception
  - IOException（IOException文件读写异常、EOFException读写文件尾异常、FileNotFoundException文件未找到异常、SQLException数据库异常）：非运行时异常，也称检查异常，不处理将无法编译成功。
  - RuntimeException（数学计算异常、空指针异常、数组索引越界异常、类文件未找到异常、类型转换异常）：运行时异常，异常不检查异常，由程序逻辑错误引起。

### IO

#### 获取键盘输入的两种方式

**Scanner**

```java
Scanner input = new Scanner(System.in);
String s = input.nextLine();
input.close();
```

**BufferedReader**

```java
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String s = input.readLine();
```

#### IO流的分类

- 按流向划分：输入流、输出流
- 按操作单元划分：字节流、字符流
- 按流的角色划分：节点流、处理流

> InputStream/Reader：所有输入流的基类，前者是字节输入流，后者是字符输入流。
>
> OutputStream/Writer：所有输出流的基类，前者是字节输出流，后者是字符输出流。

#### 文件读写与网络发送接受中，信息的最小存储单元都是字节，为何I/O流操作仍然区分为字节流和字符流？

字符流是由Java虚拟机将字节转换得到的，但此过程耗费时间，未知编码时易产生乱码问题。因此：I/O流提供了直接操作字符的接口，以方便对字符流的操作。（处理音频、图像文件使用字节流，涉及字符时使用字符流）

#### BIO、NIO、AIO有何区别？

- BIO（Blocking I/O）：同步阻塞I/O模式，数据的读写阻塞在一个线程内等待完成，低负载低并发的应用。
- NIO（New I/O）：Java1.4引入的同步非阻塞I/O模型，应用于高负载高并发环境。
- AIO（Asynchronous I/O）：NIO2，Java7中引入的异步非阻塞IO模型，基于异步与回调机制实现。

### 反射

#### 反射机制

Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取信息与动态调用对象方法的功能即为Java的反射机制。

#### 静态编译与动态编译

- 静态编译：编译时确定类型，绑定对象。
- 动态编译：运行时确定类型，绑定对象。

#### 反射机制的优缺点

- 优点：运行期间类型的判断，动态加载类，提高代码灵活度。
- 缺点：性能瓶颈，反射相当于一系列反射操作，需要通知JVM，性能弱于普通Java代码。

#### 反射的应用

模块化开发中，通过反射调用对应的字节码；动态代理模式设计模型、Spring、Hibernate框架等。

- JDBC连接数据库时使用`Class.forName()`通过反射加载数据。
- Spring框架：如XML配置模式，Spring通过XML配置模式装载Bean的过程。
  - 将XML或Properties加载到内存中。
  - Java类中解析XML或Properties中的内容，获取对应实体类的字节码字符串以及相关的属性信息。
  - 使用反射机制，获取字符串对应的某个类的Class实例。
  - 动态配置实例的属性。

#### 测试

**反射获取Class对象的三种方式**

```java
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一：对象名.getClass()，已有对象，反射无意义。
        Student student = new Student();
        Class studentClass1 = student.getClass();
        System.out.println(studentClass1.getName());
        //方式二：类名.getClass()，需要导包，过于依赖。
        Class studentClass2 = Student.class;
        System.out.println(studentClass1 == studentClass2);
        //方式三：Class.forName("包名.类名")，一般使用此种方法。
        Class studentClass3 = Class.forName("com.shinrin.Student");
        System.out.println(studentClass2 == studentClass3);
    }
}
```

**反射访问并调用构造方法**

```java
public class ConstructorsDemo {
    public static void main(String[] args) throws Exception {
        //1.加载对象
        Class studentClass = Class.forName("com.shinrin.Student");
        //2.获取公有构造方法
        Constructor[] constructors = studentClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //3.获取所有构造方法（公有、默认、受保护、私有）
        Constructor[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //4.获取公有、无参的构造方法
        Constructor constructor = studentClass.getConstructor();
        System.out.println(constructor);
        //调用构造方法
        Object object1 = constructor.newInstance();
        System.out.println(object1);

        //5.获取私有构造方法
        Constructor declaredConstructor = studentClass.getDeclaredConstructor(char.class);
        System.out.println(declaredConstructor);
        //调用构造方法
        declaredConstructor.setAccessible(true);//暴力访问
        Object  object2 = declaredConstructor.newInstance('1');
        System.out.println(object2);
    }
}
```

**反射访问并调用成员变量**

```java
public class FieldDemo {
    public static void main(String[] args) throws Exception {
        //1.获取Class
        Class studentClass = Class.forName("com.shinrin.Student");
        //2.获取所有公有的字段
        Field[] fields = studentClass.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        //3.获取所有字段
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field);
        }
        //4.获取字段并调用
        Field name = studentClass.getField("name");
        System.out.println(name);
        //获取一个对象
        Object o = studentClass.getConstructor().newInstance();
        Student student = (Student) o;
        name.set(o, "Teemo");
        System.out.println("姓名验证：" + student.name);
        //5.获取私有字段
        Field id = studentClass.getDeclaredField("id");
        System.out.println(id);
        id.setAccessible(true);//暴力反射，解除私有限定
        id.set(o, 1001);
        System.out.println("验证ID：" + student.getID());
    }
}
```

**反射访问并调用成员方法**

```java
public class MethodDemo {
    public static void main(String[] args) throws Exception {
        // 1.获取对象
        Class studentClass = Class.forName("com.shinrin.Student");
        // 2.获取所有公有方法
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        Method m = studentClass.getMethod("show1", String.class);
        System.out.println(m);
        // 实例化对象
        Object o = studentClass.getConstructor().newInstance();
        m.invoke(o, "HA");

        m = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true); // 暴力解除私有限定
        Object result = m.invoke(o, 20);//需要两个参数：要调用的对象（反射以获取）与实参
        System.out.println("返回值：" + result);
    }
}
```

### 深拷贝与浅拷贝

浅拷贝：基本数据类型值传递，引用数据类型引用传递，即为浅拷贝。

深拷贝：基本数据类型值传递，引用数据类型创建新的对象并拷贝内容，即为深拷贝。

> 浅拷贝中的两个引用指向同一个对象。



































































