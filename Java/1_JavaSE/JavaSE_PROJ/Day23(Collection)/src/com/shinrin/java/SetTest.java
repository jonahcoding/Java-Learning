package com.shinrin.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
----------------------------------------
一、Set接口框架
    |----Collection接口：单列集合，用来存储一个一个的对象
        |----Set接口：存储无序、元素不可重复（以下为实现类）
            |----HashSet：线程不安全；可以存储null值
                |----LinkedHashSet：HashSet的子类；内部存储无序，遍历（有序，通过链表）性能优于HashSet。
            |----TreeSet：可按元素对象的指定属性，进行排序。

二、Set说明
    1.Set接口的方法全部继承自Collection，无新增。
    2.向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类必须重写hashCode()和equals()。
    注：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
    重写小技巧：对象中用作 equals()方法比较的 Field，都应该用来计算 hashCode 值。

三、特性说明（）
    1.存储无序，元素不可重复（以HashSet为例）
        1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
        2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。

    2.添加元素的过程（以HashSet为例）：
        1.（添加元素m）首先调用元素a所在类的hashCode()方法，计算元素m的哈希值。
        2.依据哈希值计算出在HashSet底层数组中的存放位置（索引）。
        3.判断索引处是否已有元素：
            a.此位置上没有其他元素，则元素m添加成功。
            b.此位置上有其他元素n(或以链表形式存在的多个元素），比较m与n的hash值：
                b1.如果hash值不相同，则元素a添加成功。
                b2.如果hash值相同，进而需要调用元素a所在类的equals()方法：
                    equals()返回true,元素a添加失败。
                    equals()返回false,则元素a添加成功。
        【成功添加的元素 m 与已经存在指定索引位置上的数据以链表的方式存储。】

    3.HashSet底层：数组+链表的结构。

四、HashSet原理：
    1.是基于HashMap实现的，默认构造函数是构建一个初始容量为16，负载因子为0.75 的HashMap对象。
    2.HashSet中的集合元素由 HashMap 的 key 保存，而 HashMap 的 value 存储了一个 PRESENT（静态的 Object 对象）。
----------------------------------------
*/
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据（无序）的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据（遍历有序）。
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
