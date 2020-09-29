package com.shinrin.java;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/*
----------------------------------------
【集合框架】
一、集合框架概述
    Java容器：对多个数据进行存储操作的结构（集合、数组）。
    数组特点：
        1.定义时确定元素类型，初始化时确定容量大小。
        2.操作方法有限，无增删改查等。
        3.有序、可重复（不能实现无序、不重复）。
    集合与数组的区别是什么？
        1. 集合长度可变，数组长度固定。
        2. 集合只存储对象（不同类型），数组可存储基本数据类型和引用数据类型（同一类型）。
二、集合框架
      |----Collection接口：单列集合对象，元素为一个对象。java.util.Collection
          |----List接口：存储有序的、可重复的数据。
              |----ArrayList、LinkedList、Vector
          |----Set接口：存储无序的、不可重复的数据。
              |----HashSet、LinkedHashSet、TreeSet
      |----Map接口：双列集合，元素为一对(key - value)数据。java.util.Map
              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties

三、集合接口的方法
    注：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()。
    boolean add(Object o)：向集合中加入一个对象的引用
    boolean contains(Object o)：判断集合中是否持有特定对象的引用
    boolean addAll(Collection col)：向当前集合中加入集合col
    boolean containsAll(Collection col)：判断集合中是否包含col的所有元素
    retainAll(Collection coll1):交集：获取当前集合和col集合的交集，并返回给当前集合
    boolean remove(Object o)：从集合中删除一个对象的引用
    removeAll(Collection col)：从当前集合中移除col中所有的元素。
    void clear()：删除集合中所有的对象，即不再持有这些对象的引用
    int size()：返回集合中元素的数目
    boolean isEmpty()：判断集合是否为空
    equals(Collection col)：
    hashCode():返回当前对象的哈希值
    Object[] toArray()：返回一个数组，该数组中包括集合中的所有元素
    Iterator iterator()：返回一个Iterator对象，可以用来遍历集合中的元素

    关于：Iterator() 和toArray() 方法都用于集合的所有的元素，前者返回一个Iterator对象，后者返回一个包含集合中所有元素的数组。
----------------------------------------
【Iterator迭代器】
一、什么是迭代器
    迭代访问（遍历）集合元素，接口java.util.Iterator。

二、迭代器的原理
    迭代实现：
        1.调用集合的iterator()方法获得迭代器对象。
        2.使用hashNext()方法判断当前元素的下一个位置是否存在元素。
        3.如果存在，调用next()取出元素。如果不存在，则已到达集合末尾，停止遍历。
    迭代原理（内部指针跟踪集合元素）：
        1.首次调用next()前，迭代器索引位于第一个元素之前，不指向任何元素。
        2.第一次调用next()方法后，迭代器索引后移一位，指向第一个元素并将其返回。
        3.依此类推，直到hasNext()返回false，表示已到达集合的末尾，终止对元素的遍历。

三、迭代器的方法
      public E next():返回迭代的下一个元素。
      public boolean hasNext():如果仍有元素可以迭代，则返回 true。

四、迭代器的使用
    IteratorTest.IteratorDemo();
----------------------------------------
【for_each】
一、for_each循环
    JDK1.5加入，遍历数组和集合。

二、原理
    Iterator迭代器。
    注：遍历过程中，无法增删元素。

三、for_each使用
    EachForTest.EachForDemo();
----------------------------------------
----------------------------------------
*/
public class CollectionTest {
    public static void main(String[] args) {

    }

    @Test
    public void test2(){
//        Collection<String> collAL = new ArrayList<String>();
        Collection collAL = new ArrayList();
        collAL.add("Teemo");
        collAL.add("Yasuo");
        collAL.add("ZOE");
        collAL.add(new Date());//不指定类型时
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

//Iterator迭代器
class IteratorTest {
    public static void IteratorDemo() {
        Collection<String> coll = new ArrayList<>();
        coll.add("Teemo");
        coll.add("Yasuo");
        coll.add("ZOE");
        Iterator<String> it = coll.iterator();
        while (it.hasNext()){
            //System.out.println(it.next());
            String s = it.next();
            System.out.println(s);
        }
    }
}

//for_each 循环
class EachForTest {
    public static void EachForDemo() {
        Collection<String> coll = new ArrayList<>();
        coll.add("Teemo");
        coll.add("Yasuo");
        coll.add("ZOE");
        for (String i : coll){
            System.out.println(i);
        }
    }
}