/*
========================================
----------------------------------------
一、Num & Math 类
	Number类：
		包括子类包装类（Integer、Long、Byte、Double、Float、Short）。
	Math类：
		Math包含了用于执行基本数学运算的属性和方法（static），如初等指数、对数、平方根和三角函数。
	常用类方法：

二、Character 类
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

三、String 类
	特点：一经创建，无法改变 String 对象。
	常用类方法：

四、Java StringBuffer 和 StringBuilder 类
	特点：StringBuffer 和 StringBuilder 类的对象能够多次修改，并且不产生新的未使用对象。
	区别：
		StringBuilder（Java 5）线程不安全（不能同步访问）、速度快。
		StringBuffer线程安全、速度慢。

五、数组与Array类
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

六、Date类
    创建或格式化日期对象。
	构造函数：
		Date( );	使用当前日期和时间初始化对象。
        Date(long millisec);	接收一个参数，该参数是从1970年1月1日起的毫秒数。
        使用SimpleDateFormat格式化日期：
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            System.out.println("当前时间为: " + ft.format(dNow));

七、休眠与时间测量：
    线程休眠：Thread.sleep(1000*3);   // 休眠3秒，让出系统资源
    时间测量：
         long start = System.currentTimeMillis( );
         Thread.sleep(5*60*10);     //3000毫秒（3秒）
         long end = System.currentTimeMillis( );
         long diff = end - start;

八、Calendar类
    创建一个当前日期的Calendar对象：Calendar c = Calendar.getInstance();//默认是当前日期
    创建一个指定日期的Calendar对象：先创建一个Calendar的对象，再设定该对象中的年月日参数。
        Calendar c1 = Calendar.getInstance();
        c1.set(2009, 6, 12); 

九、GregorianCalendar类
    GregorianCalendar是Calendar类的子类。

十、正则表达式
    正则表达式定义了字符串的模式。
    正则表达式可以用来搜索、编辑或处理文本。
    正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。

十一、Java流
    流：一个数据的序列。输入流表示从一个源读取数据，输出流表示向一个目标写数据。
    1.从控制台读取字符/字符串输入：
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int read( ) throws IOException      //从输入流读取一个字符并把该字符作为整数值返回。 当流结束的时候返回 -1。该方法抛出 IOException。
        String readLine( ) throws IOException
    2.向控制台输出：
        void write(int byteval)
        System.out.write(b);
        System.out.write('\n');

十二、文件和I/O流
    文件：
        读取文件：
            1.使用字符串类型的文件名来创建一个输入流对象来读取文件：
                InputStream read = new FileInputStream("C:/java/hello");
            2.先使用 File() 方法来创建一个文件对象，再使用该文件对象来创建一个输入流对象来读取文件。
                File f = new File("C:/java/hello");
                InputStream read = new FileInputStream(f);
        写文件：
            目标文件不存在，那么该流会创建该文件。
            1.使用字符串类型的文件名来创建一个输出流对象来写文件：
                OutputStream write = new FileOutputStream("C:/java/hello");
            2.先使用 File() 方法来创建一个文件对象，再使用该文件对象来创建一个输出流对象来写文件。
                File f = new File("C:/java/hello");
                OutputStream write = new FileOutputStream(f);
        目录：
            创建目录：
                mkdir( )：创建一个文件夹，成功则返回true，失败则返回false。
                mkdirs()：创建一个文件夹和它的所有父文件夹。
                    String dirname = "/tmp/user/java/bin";
                    File d = new File(dirname);
                    d.mkdirs();
            读取目录：
                一个目录是一个 File 对象，它包含其他文件和文件夹。
                isDirectory() 方法判断当前对象是否为目录。
                通过调用该对象上的 list() 方法，来提取其包含的文件和文件夹的列表。
                    String dirname = "/tmp";
                    File f1 = new File(dirname);
                    String s[] = f1.list();
                    File f = new File(dirname + "/" + s[i]);
            删除目录：
    I/O流：
        IO 流分类：
            按照流的流向分，可以分为输入流和输出流；
            按照操作单元划分，可以划分为字节流和字符流；
                InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
                OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。
            按照流字符流的角色划分为节点流和处理流。
        注：字符流是由 Java 虚拟机将字节转换得到的，转换低效，所以IO流提供了直接操作字符的接口。


十三、Scanner 类：
    获取用户输入：
        Scanner s = new Scanner(System.in);
    next()：
        1、一定要读取到有效字符后才可以结束输入。
        2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
        3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
        4.next() 不能得到带有空格的字符串。
    nextLine()：
        1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
        2、可以获得空白。

十四、异常
    Throwable 异常类，拥有以下两个子类：
        Exception（异常）：程序本身可处理的错误。如：未指定引用对象、下标越界、运算符错误。
        Error（错误）：程序无法处理的错误。如：JVM运行错误（内存不足）、未定义类。
    Throwable 类常用方法：
        public string getMessage():返回异常发生时的简要描述
        public string toString():返回异常发生时的详细信息
        public string getLocalizedMessage():返回异常对象的本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与 getMessage（）返回的结果相同
        public void printStackTrace():在控制台上打印 Throwable 对象封装的异常信息
    try-catch-finally
        try 块： 用于捕获异常。其后可接零个或多个 catch 块，如果没有 catch 块，则必须跟一个 finally 块。
        catch 块： 用于处理 try 捕获到的异常。
        finally 块： 无论是否捕获或处理异常，finally 块里的语句都会被执行。finally return会覆盖 try 或 catch 中的 return。
    使用 try-with-resources 代替 try-catch-finally。

十五、多线程
    线程、程序、进程？
        线程是比进程更小的执行单位，一个进程在其执行的过程中可以产生多个线程，同类的多个线程共享同一块内存空间和一组系统资源。
        程序是含有指令和数据的文件，被存储在磁盘或其他的数据存储设备中，程序是静态的代码。
        进程是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。系统运行一个程序即是一个进程从创建，运行到消亡的过程。
    线程的基本状态：
        初始：
        运行：
        阻塞：
        等待：
        超时等待：
        终止：
    
========================================
*/
    
