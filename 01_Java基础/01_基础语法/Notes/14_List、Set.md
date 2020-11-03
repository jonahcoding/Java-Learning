# 14_List、Set

## 相关问题：

## 一、数据结构

### 1.1 常见的数据结构

栈、队列、数组、链表和红黑树

#### 栈（Stack，堆栈）：

* 特点：
  * 线性表。
  * 仅在栈顶一端插入删除元素。
  * 先进后出（FILO）。

- 方法：
  - 入栈（压栈）：存入元素。
  - 出栈（弹栈）：取出元素。


#### 队列（Queue）：

* 特点：
  * 线性表。
  * 仅允许在队列的一端进行插入，在另一端进行删除。
  * 先进先出（FIFO）。

#### 数组（Array）：

* 特点：
  * 有序的元素序列（内存中连续的空间）
  * 查找元素快（通过索引访问）
  * 增删元素满（新建数组，按索引拷贝原数据元素）

####  链表（LinkedList）：

* 特点：
* 由一系列结点（链表元素）组成，结点运行时动态生成。
  * 每个结点包括两个部分：数据域（存储数据元素）、指针域（下一个节点地址）。
  * 查找元素慢：依次向后查找指定元素
  * 增删元素快：仅修改指针域（下个元素的地址）。
* 分类：
  * 单向链表：
  * 双向链表：
  * 循环链表：

#### 红黑树

**二叉树**：**binary tree** ,是每个结点不超过2的有序**树（tree）** 。

- 特点：
  - 每个结点上都最多只能有两个子结点。
  - 最顶上节点为根结点，左右两边被称作“左子树”和“右子树”。

**红黑树**：二叉查找树，插入新节点后仍为二叉查找树（树的键值有序）。

- 特性：
  1. 节点可以是红色的或者黑色的
  2. 根节点是黑色的
  3. 叶子节点(特指空节点)是黑色的
  4. 每个红色节点的子节点都是黑色的
  5. 任何一个节点到其每一个叶子节点的所有路径上黑色节点数相同

- 特点：
  - 查找速度快，趋于平衡树，最多查找次数与最少查找次数不多于二倍。

## 二、List集合

Collection中的常用几个子类（`java.util.List`集合、`java.util.Set`集合）。

### 1.1 List接口

`java.util.List`接口继承自`Collection`接口（单列集合），`List`接口的对象称为List集合。

**特点：**

- 线性方式存储。
- 元素可重复。（通过元素的equals()比较判断）
- 使用索引访问。
- 元素存取有序。

### 1.2 List常用方法

继承Collection接口的全部方法，同时增加特有方法（索引操作），如下：

- `public void add(int index, E element)`: 将指定的元素添加到指定位置。
- `public E get(int index)`:返回集合中指定位置的元素。
- `public E remove(int index)`: 移除列表中指定位置的元素, 返回的是被移除的元素。
- `public E set(int index, E element)`:更新指定位置的元素，返回更新前的元素。

List集合特有的方法都是跟索引相关，我们在基础班都学习过，那么我们再来复习一遍吧：

```java
public class ListDemo {
    public static void main(String[] args) {
        
    	List<String> list = new ArrayList<String>();
    	list.add("EZ");
    	list.add("Lux");
    	list.add("ZOE");
    	System.out.println(list);
        
    	list.add(1,"Yasuo");
    	System.out.println("打印数组："+list);
        
    	System.out.println("删除索引位置为2的元素："+list.remove(2));
    	System.out.println("打印数组："+list);

    	list.set(0, "Galen");
    	System.out.println(list);

    	for(int i = 0;i<list.size();i++){
    		System.out.println(list.get(i));
    	}
    	
    	for (String string : list) {
			System.out.println(string);
		}  	
	}
}
```

## 三、List的子类

### 3.1 ArrayList集合

`java.util.ArrayList`集合数据存储的结构是数组结构。

**特点：**元素增删慢，查找快。

**应用：**查询数据、遍历数据。

### 3.2 LinkedList集合

`java.util.LinkedList`集合数据存储的结构是链表结构**（双向链表）**。

**特点：**元素添加、删除速度快。

**应用**：首尾增删相关操作。

* `public void addFirst(E e)`:将指定元素插入此列表的开头。
* `public void addLast(E e)`:将指定元素添加到此列表的结尾。
* `public E getFirst()`:返回此列表的第一个元素。
* `public E getLast()`:返回此列表的最后一个元素。
* `public E removeFirst()`:移除并返回此列表的第一个元素。
* `public E removeLast()`:移除并返回此列表的最后一个元素。
* `public E pop()`:从此列表所表示的堆栈处弹出一个元素。
* `public void push(E e)`:将元素推入此列表所表示的堆栈。
* `public boolean isEmpty()`：如果列表不包含元素，则返回true。

~~~java
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        link.addFirst("Teemo");
        link.addFirst("Tom");
        link.addFirst("Jerry");
        System.out.println(link);
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());

        while (!link.isEmpty()) { 
            System.out.println(link.pop()); 
        }
        System.out.println(link);
    }
}
~~~

## 四、Set接口

`java.util.Set`接口继承自`Collection`接口。

**特点：**

- `Set`接口中元素无序

- 以某种规则保证存入的元素不出现重复。

`Set`集合的子类：`java.util.HashSet`、`java.util.LinkedHashSet`

> 注：Set集合取出元素的方式：迭代器、for each。

### 4.1 HashSet集合介绍

`java.util.HashSet`是`Set`接口的一个实现类。

**特点：**

- 元素不重复。
- 元素无序(存取顺序不一致)。
- 底层实现是`java.util.HashMap`。

`HashSet`：**根据对象的哈希值来确定元素在集合中的存储位置**，（良好的存取和查找性能）。

**保证元素唯一性依赖于：`hashCode`与`equals`方法。**

~~~java
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String>  set = new HashSet<String>();
        set.add(new String("Ari"));
        set.add("Poppy");
        set.add("Liqing"); 
        set.add("Ari");  
        for (String name : set) {
            System.out.println(name);
        }
    }
}
~~~

输出结果如下，说明Set集合中不能存储重复元素：

~~~
cba
abc
bac
~~~

> 注：第二次存入"Ari"失败。（Set不允许元素重复）

### 4.2  HashSet集合存储数据的结构（哈希表）

什么是哈希表呢？

**JDK1.8之前：**哈希表存储使用数组+链表实现，同一hash值的对象存储在同一个链表中，但同一hash值的对象较多时，查找效率变低。

**JDK1.8开始**：哈希表存储采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

**JDK1.8**引入红黑树大程度优化了HashMap的性能，根据对象的hashCode和equals方法来保证集合对象的唯一。

### 4.3  HashSet存储自定义类型元素

如果在集合中存放自定义的对象，就必须复写hashCode和equals方法建立属于当前对象的比较方式，以保证其唯一。

~~~java
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age &&
               Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
~~~

~~~java
public class HashSetDemo2 {
    public static void main(String[] args) {
        HashSet<Student> stuSet = new HashSet<Student>();
        Student stu = new Student("Teemo", 7);
        stuSet.add(stu);
        stuSet.add(new Student("Yasuo", 44));
        stuSet.add(new Student("Teemo", 7));
        stuSet.add(new Student("EZ", 23));
        stuSet.add(stu);

        for (Student stu2 : stuSet) {
            System.out.println(stu2);
        }
    }
}
执行结果：
Student [name=Teemo, age=7]
Student [name=Yasuo, age=43]
Student [name=EZ, age=23]
~~~

### 4.4 LinkedHashSet

`java.util.LinkedHashSet`，链表和哈希表组合的一个数据存储结构，使HashSet有序。

~~~java
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		set.add("bbb");
		set.add("aaa");
		set.add("abc");
		set.add("bbc");
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
结果：
  bbb
  aaa
  abc
  bbc
~~~

### *可变参数*

**JDK1.5**以后。**...** 用在参数上，称之为可变参数（参数类型一致的多个参数）。

```java
public class ChangeArgs {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 62, 431, 2 };
        int sum = getSum(arr);
        System.out.println(sum);
        int sum2 = getSum(6, 7, 2, 12, 2121);
        System.out.println(sum2);
    }

    public static int getSum(int... arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }
}
```

> 注意：可变参数要写在参数列表的末尾位置。

## 五、Collections

### 5.1 常用功能

* `java.utils.Collections`是集合工具类，用来对集合进行操作。部分方法如下：

- `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。
- `public static void shuffle(List<?> list) ` :打乱集合顺序。
- `public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序（升序）。
- `public static <T> void sort(List<T> list, Comparator<? super T> )`:将集合中元素按照指定规则排序。

```java
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 5, 222, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
结果：
[5, 222, 1, 2]
[1, 2, 5, 222]
```

### 5.2 Comparator比较器

`public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序。

不过这次存储的是字符串类型。

```java
public class CollectionsDemo2 {
    public static void main(String[] args) {
        ArrayList<String>  list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        //排序方法
        Collections.sort(list);
        System.out.println(list);
    }
}
```

结果：

```
[aba, cba, nba, sba]
```

我们使用的是默认的规则完成字符串的排序，那么默认规则是怎么定义出来的呢？

说到排序了，简单的说就是两个对象之间比较大小，那么在JAVA中提供了两种比较实现的方式，一种是比较死板的采用`java.lang.Comparable`接口去实现，一种是灵活的当我需要做排序的时候在去选择的`java.util.Comparator`接口完成。

那么我们采用的`public static <T> void sort(List<T> list)`这个方法完成的排序，实际上要求了被排序的类型需要实现Comparable接口完成比较的功能，在String类型上如下：

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
```

String类实现了这个接口，并完成了比较规则的定义，但是这样就把这种规则写死了，那比如我想要字符串按照第一个字符降序排列，那么这样就要修改String的源代码，这是不可能的了，那么这个时候我们可以使用

`public static <T> void sort(List<T> list，Comparator<? super T> )`方法灵活的完成，这个里面就涉及到了Comparator这个接口，位于位于java.util包下，排序是comparator能实现的功能之一,该接口代表一个比较器，比较器具有可比性！顾名思义就是做排序的，通俗地讲需要比较两个对象谁排在前谁排在后，那么比较的方法就是：

* ` public int compare(String o1, String o2)`：比较其两个参数的顺序。

  > 两个对象比较的结果有三种：大于，等于，小于。
  >
  > 如果要按照升序排序，
  > 则o1 小于o2，返回（负数），相等返回0，01大于02返回（正数）
  > 如果要按照降序排序
  > 则o1 小于o2，返回（正数），相等返回0，01大于02返回（负数）

操作如下:

```java
public class CollectionsDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");
        //排序方法  按照第一个单词的降序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println(list);
    }
}
```

结果如下：

```
[sba, nba, cba, aba]
```

### 5.3 简述Comparable和Comparator两个接口的区别。

**Comparable**：强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的compareTo方法被称为它的自然比较方法。只能在类中实现compareTo()一次，不能经常修改类的代码实现自己想要的排序。实现此接口的对象列表（和数组）可以通过Collections.sort（和Arrays.sort）进行自动排序，对象可以用作有序映射中的键或有序集合中的元素，无需指定比较器。

**Comparator**强行对某个对象进行整体排序。可以将Comparator 传递给sort方法（如Collections.sort或 Arrays.sort），从而允许在排序顺序上实现精确控制。还可以使用Comparator来控制某些数据结构（如有序set或有序映射）的顺序，或者为那些没有自然顺序的对象collection提供排序。

### 5.4  练习

创建一个学生类，存储到ArrayList集合中完成指定排序操作。

Student 初始类

~~~java
public class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}
~~~

测试类：

~~~java
public class Demo {
    public static void main(String[] args) {
        // 创建四个学生对象 存储到集合中
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student("rose",18));
        list.add(new Student("jack",16));
        list.add(new Student("abc",16));
        list.add(new Student("ace",17));
        list.add(new Student("mark",16));

        //按照年龄升序排序
		//Collections.sort(list);//出错
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
~~~

> 原因：集合中自定义类型元素排序，必须先实现比较器Comparable接口。
>

~~~java
public class Student implements Comparable<Student>{
    ....
    @Override
    public int compareTo(Student o) {
        return this.age-o.age;//升序
    }
}
~~~

测试：

~~~java
Student{name='jack', age=16}
Student{name='abc', age=16}
Student{name='mark', age=16}
Student{name='ace', age=17}
Student{name='rose', age=18}
~~~

### 5.5 扩展

如果在使用的时候，想要独立的定义规则去使用 可以采用Collections.sort(List list,Comparetor<T> c)方式，自己定义规则：

~~~java
Collections.sort(list, new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge()-o1.getAge();//以学生的年龄降序
    }
});
~~~

效果：

~~~
Student{name='rose', age=18}
Student{name='ace', age=17}
Student{name='jack', age=16}
Student{name='abc', age=16}
Student{name='mark', age=16}
~~~

如果想要规则更多一些，可以参考下面代码：

~~~java
Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 年龄降序
                int result = o2.getAge()-o1.getAge();//年龄降序

                if(result==0){//第一个规则判断完了 下一个规则 姓名的首字母 升序
                    result = o1.getName().charAt(0)-o2.getName().charAt(0);
                }

                return result;
            }
        });
~~~

效果如下：

~~~
Student{name='rose', age=18}
Student{name='ace', age=17}
Student{name='abc', age=16}
Student{name='jack', age=16}
Student{name='mark', age=16}
~~~
