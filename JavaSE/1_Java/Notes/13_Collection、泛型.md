# 13_Collection、泛型

## 相关问题

1. 集合与数组的区别
2. Collection集合的常用功能
3. 迭代器原理
4. 泛型通配符
5. 泛型上下限
## 一、Collection集合

### 1.1 集合概述

**集合**：容器，存储多个数据。

> <u>***【集合与数组的区别是什么？】***</u>
>
> 1. 数组长度固定，集合长度可变。
> 2. 数组中存储的是同一类型的元素（基本数据类型+对象）。集合存储仅对象（可不同类型）。
>

### 1.2  Collection集合框架

集合分类（按照存储结构）：

- 单列集合`java.util.Collection`
- 双列集合`java.util.Map`

**Collection接口**：单列集合类的根接口（存放在java.util包中），定义单列集合框架共性内容。

**Collection的子接口及其实现类**：

- `java.util.List` （元素有序、可重复、有索引（for遍历））
  - `java.util.ArrayList`（底层数组实现：查询快，增删满。）
  - `java.util.LinkedList`（底层链表实现：查询慢，增删快。）

- `java.util.Set` （元素无序、不重复、无索引）
  - `java.util.HashSet`（底层哈希表（+红黑树））
  - `java.util.LinkedHashSet`（底层哈希表+链表：存取有序）
  - `java.util.TreeSet`（底层二叉树：用于排序）

### 1.3 Collection集合常用方法

* `public boolean add(E e)`：  添加元素 。
* `public boolean remove(E e)`: 删除元素。
* `public boolean contains(E e)`: 是否包含指定元素。
* `public void clear()` :清空集合。
* `public boolean isEmpty()`: 当前集合是否为空。
* `public int size()`: 集合元素个数。
* `public Object[] toArray()`: 把集合中的元素存储到数组。

测试（ArrayList）：

~~~java
import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {

        Collection<String> collAL = new ArrayList<String>();
        collAL.add("Teemo");
        collAL.add("Yasuo");
        collAL.add("ZOE");
        System.out.println("Print ArrayList: "+collAL);
        System.out.println("Yasuo in the ArrayList? "+collAL.contains("Yasuo"));
        System.out.println("Remove Yasuo："+collAL.remove("Yasuo"));
        System.out.println("Print ArrayList: "+collAL);
        System.out.println("Size of ArrayList: "+collAL.size());
        Object[] objects = collAL.toArray();
        System.out.println("ArrayList to Arrray: ");
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        collAL.clear();
        System.out.println("Print ArrayList: "+collAL);
        System.out.println("Is Empty? "+collAL.isEmpty());
    }
}
~~~

## 二、Iterator迭代器

### 2.1 Iterator接口

**迭代器**：迭代访问（遍历）集合元素，接口`java.util.Iterator`。

获取集合迭代器：

* `public Iterator iterator()`

**迭代**：即Collection集合元素的通用获取方式。判断集合中下一位置不为空，继续取出下一个元素。

### 2.2 Iterator接口的常用方法

* `public E next()`:返回迭代的下一个元素。
* `public boolean hasNext()`:如果仍有元素可以迭代，则返回 true。

接下来我们通过案例学习如何使用Iterator迭代集合中元素：

~~~java
public class IteratorTest {
  	public static void main(String[] args) {
        
        Collection<String> collAL = new ArrayList<String>();
        collAL.add("Teemo");
        collAL.add("Yasuo");
        collAL.add("ZOE");
        //使用迭代器遍历，每个集合对象都有自己的迭代器
        Iterator<String> it = collAL.iterator();
        while(it.hasNext()){ 		//判断是否有迭代元素
            String s = it.next();	//获取迭代出的元素
            System.out.println(s);
        }
  	}
}
~~~

> 注：越界迭代将产生异常：java.util.NoSuchElementException。

### 2.2 迭代器的实现原理

> ***【<u>迭代器的实现原理</u>？】***
>
> > 迭代实现：
> >
> > 1. 调用集合的iterator()方法获得迭代器对象。
> > 2. 使用hashNext()方法判断当前元素的下一个位置是否存在元素。
> > 3. 如果存在，调用next()取出元素。如果不存在，则已到达集合末尾，停止遍历。
>
> > 迭代原理（内部指针跟踪集合元素）：
> >
> > 1. 首次调用next()前，迭代器索引位于第一个元素之前，不指向任何元素。
> > 2. 第一次调用next()方法后，迭代器索引后移一位，指向第一个元素并将其返回。
> > 3. 依此类推，直到hasNext()返回false，表示已到达集合的末尾，终止对元素的遍历。

### 2.3 增强for

**for each循环**：JDK1.5加入，遍历数组和集合。内部原理为Iterator迭代器，**遍历过程中，无法增删元素**。

###### 练习1：遍历数组

~~~java
public class EachForArr {
    public static void main(String[] args) {
		int[] arr = {3,5,6,87};
		for(int a : arr){
			System.out.println(a);
		}
	}
}
~~~

###### 练习2 : 遍历集合

~~~java
public class EachForArrayList {
    public static void main(String[] args) {        
    	Collection<String> collAL = new ArrayList<String>();
        collAL.add("Teemo");
        collAL.add("Yasuo");
        collAL.add("ZOE");
    	for(String s :collAL){
    		System.out.println(s);
    	}
	}
}
~~~

> 注: for each仅用作遍历Collection或数组，不支持增删元素。

## 三、泛型

### 3.1  泛型概述

集合中可以存放任意对象，对象存储到集合后被提升成Object类型，当取出对象时，必须进行类型转换。

~~~java
public class GenericTest1 {
	public static void main(String[] args) {
		Collection collAL = new ArrayList();
		collAL.add("Hello");
		collAL.add("Kitty");
		collAL.add(5);//集合未做类型限定，可存入任意类型。
		Iterator it = collAL.iterator();
		while(it.hasNext()){
			String str = (String) it.next();//迭代出来的对象转成String类型。
			System.out.println(str.length());
		}
	}
}
~~~

> 注：强转引发类型转换异常：**java.lang.ClassCastException**。     

​                                                                                                                                                                                                                                   Collection可以存储各种对象，但实际使用中通常只用来存储同一类型对象。JDK5引入**泛型**(**Generic**)语法，在设计API时可以指定类或方法支持泛型，在编译时期进行语法检查。

**泛型**：在类或方法中使用未知的类型。

> 注 : 一般在创建对象时，将未知的类型确定为具体的类型。若未指定，默认类型为Object类型。

### 3.2  泛型的优势

* 将运行时期的ClassCastException，转移到编译期。
* 避免了取出元素时类型强制转换。

~~~java
public class GenericTest2 {
	public static void main(String[] args) {
        Collection<String> collAL = new ArrayList<String>();
        collAL.add("Hello");
		collAL.add("Kitty");
        // collAL.add(5);//集合类型明确为String类型，存放int类型将编译报错。
        Iterator<String> it = collAL.iterator();
        while(it.hasNext()){
            String str = it.next();//迭代出来的对象为String类型。
            System.out.println(str.length());
        }
	}
}
~~~

> 注：泛型是数据类型的一部分，我们将类名与泛型合并一起看做数据类型。

### 3.3  泛型的定义与使用

**定义格式**：

~~~
修饰符 class 类名<代表泛型的变量> {  }
~~~

如下，API中的ArrayList集合：

```
class ArrayList<E>{ 
    public boolean add(E e){ }
    public E get(int index){ }
   	....
}
```

**在创建对象的时候确定泛型**：

`ArrayList<Integer> list = new ArrayList<Integer>();`

如下，变量E的值为Integer类型：

~~~java
class ArrayList<Integer> { 
     public boolean add(Integer e) { }
     public Integer get(int index) {  }
     ...
}
~~~

自定义泛型类：

~~~java
public class MyGenericClass<M> {
	//M为自定义未知数据类型。
	private M m;
     
    public void setMVP(M m) {
        this.m = m;
    }
     
    public M getM() {
        return m;
    }
}
~~~

使用:

~~~java
public class GenericClass {
  	public static void main(String[] args) {		 
         // 创建一个泛型为String的类
         MyGenericClass<String> my = new MyGenericClass<String>();    	
         my1.setM("Lux");
         String m1 = my1.getM();
         System.out.println(m1);
         //创建一个泛型为Integer的类
         MyGenericClass<Integer> my2 = new MyGenericClass<Integer>(); 
         my2.setM(123);   	  
         Integer m2 = my2.getM();
    }
}
~~~

####  3.1.1 含有泛型的方法

**定义格式**：

~~~
修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
~~~

例如，

~~~java
public class MyGenericMethod {	  
    public <M> void show1(M m) {
    	System.out.println(m.getClass());
    }
    
    public <M> M show2(M m) {	
    	return m;
    }
}
~~~

使用格式：**调用方法时，确定泛型的类型**

~~~java
public class GenericMethodTest {
    public static void main(String[] args) {
        // 创建对象
        MyGenericMethod mm = new MyGenericMethod();
        // 演示看方法提示
        mm.show1("aaa");
        mm.show1(123);
        mm.show2(12.45);
    }
}
~~~

### 3.1.2 含有泛型的接口

定义格式：

~~~
修饰符 interface接口名<代表泛型的变量> {  }
~~~

例如，

~~~java
public interface MyGenericInterface<E>{
	public abstract void add(E e);
	
	public abstract E getE();  
}
~~~

使用格式：

**1、定义类时确定泛型的类型**

例如

~~~java
public class MyImp1 implements MyGenericInterface<String> {
	@Override
    public void add(String e) {
        // 省略...
    }

	@Override
	public String getE() {
		return null;
	}
}
~~~

此时，泛型E的值就是String类型。

 **2、始终不确定泛型的类型，直到创建对象时，确定泛型的类型**

 例如

~~~java
public class MyImp2<E> implements MyGenericInterface<E> {
	@Override
	public void add(E e) {
       	 // 省略...
	}

	@Override
	public E getE() {
		return null;
	}
}
~~~

确定泛型：

~~~java
/*
 * 使用
 */
public class GenericInterface {
    public static void main(String[] args) {
        MyImp2<String>  my = new MyImp2<String>();  
        my.add("aa");
    }
}
~~~

### 3.4  泛型通配符

当使用泛型类或者接口时，传递的数据类型未知，可以通过通配符<?>表示。**一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用。**

#### 3.4.1 通配符基本使用

此时只能接受数据，不能往该集合中存储数据。

~~~java
public static void main(String[] args) {
    Collection<Intger> list1 = new ArrayList<Integer>();
    getElement(list1);
    Collection<String> list2 = new ArrayList<String>();
    getElement(list2);
}
public static void getElement(Collection<?> coll){}
//？代表可以接收任意类型
~~~

> 注：**泛型不存在继承关系** ：Collection<Object> list = new ArrayList<String>();（错误）



#### 3.4.2 受限泛型

**受限泛型 :**  指定一个泛型的**上限**和**下限**。

**泛型的上限**：

* **格式**： `类型名称 <? extends 类 > 对象名称`
* **意义**： `只能接收该类型及其子类`

**泛型的下限**：

- **格式**： `类型名称 <? super 类 > 对象名称`
- **意义**： `只能接收该类型及其父类型`

比如：现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类

~~~java
public static void main(String[] args) {
    Collection<Integer> list1 = new ArrayList<Integer>();
    Collection<String> list2 = new ArrayList<String>();
    Collection<Number> list3 = new ArrayList<Number>();
    Collection<Object> list4 = new ArrayList<Object>();
    
    getElement(list1);
    getElement(list2);//报错
    getElement(list3);
    getElement(list4);//报错
  
    getElement2(list1);//报错
    getElement2(list2);//报错
    getElement2(list3);
    getElement2(list4);
  
}
// 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
public static void getElement1(Collection<? extends Number> coll){}
// 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
public static void getElement2(Collection<? super Number> coll){}
~~~

## 四、 集合综合案例

### 4.1 需求分析

- 玩家三人
- 底牌三张

### 4.2 代码实现

~~~java
package com.shinrin.collection;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {

        ArrayList<String> pokerBox = new ArrayList<String>();//扑克牌集合
        ArrayList<String> colors = new ArrayList<String>();//花色集合
        ArrayList<String> numbers = new ArrayList<String>();//数字集合
        //填充花色集合
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");
        //填充数字集合
        for(int i = 2;i<=10;i++){
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        //创建牌（花色+数字）
        for (String color : colors) {
            for(String number : numbers){
                String card = color+number;
                pokerBox.add(card);
            }
        }
        pokerBox.add("大王");
        pokerBox.add("小王");
        // System.out.println(pokerBox);
        // Collections类（工具类）的成员方法都为静态方法，如shuffer()
        //洗牌
        Collections.shuffle(pokerBox);
        //发牌
        //创建玩家集合与底牌集合
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> dipai = new ArrayList<String>();
        //遍历 牌盒  必须知道索引
        for(int i = 0;i<pokerBox.size();i++){
            //获取牌面
            String card = pokerBox.get(i);
            if(i>=51){//底牌
                dipai.add(card);
            } else {
                //玩家1：%3==0
                if(i%3==0){
                    player1.add(card);
                }else if(i%3==1){//玩家2
                    player2.add(card);
                }else{//玩家3
                    player3.add(card);
                }
            }
        }
        System.out.println("赵信："+player1);
        System.out.println("盖伦："+player2);
        System.out.println("嘉文四世："+player3);
        System.out.println("底牌："+dipai);
    }
}
~~~

