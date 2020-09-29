package com.shinrin.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
----------------------------------------
一、Map的实现类的结构：
    |----Map:双列数据，存储key-value对的数据。
        |----HashMap:作为Map的主要实现类；线程不安全，效率高；存储null的key和value
            |----LinkedHashMap:存放无序，遍历有序（添加指针指向前后元素）。频繁的遍历操作，效率高于HashMap。
        |----TreeMap:按照添加的key-value对进行排序(同类型)，实现排序遍历。此时考虑key的自然排序或定制排序，底层使用红黑树。
        |----Hashtable:(Old)线程安全，效率低；不能存储null的key和value
            |----Properties:常用来处理配置文件 。key和value都是String类型
    说明：
    HashMap的底层实现：
        数组+链表       （jdk7及之前）
        数组+链表+红黑树 （jdk 8）

面试题：
    1. HashMap的底层实现原理？
    2. HashMap 和 Hashtable的异同？
    3. CurrentHashMap 与 Hashtable的异同？

二、Map结构的理解：
    Map中的key:无序、不重复，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
    Map中的value:无序、可重复，使用Collection存储所有的value --->value所在的类要重写equals()
    一个键值对（key-value）构成了一个Entry对象（不可重复）。
    Map中的entry:无序的、不可重复的，使用Set存储所有的entry

三、HashMap的底层实现原理（JDK7）：
    HashMap map = new HashMap();    实例化HashMap，底层创建长度默认为16的一维数组Entry[] table。
    map.put(key1,value1);           通过put(key1,value1)方法添加数据（此前已经存入多个数据）：
    添加元素：
        1. 调用key1所在类的hashCode()计算key1哈希值，
        2. 对key1哈希值进行某种算法计算，得到在Entry数组中的存放位置。
            a. 此位置数据为空：添加成功。
            b. 此位置数据不为空（存在一个或多个数据（链表形式））：
                b1. key1的哈希值与已存在的数据的哈希值都不相同，添加成功（链表形式）。
                b2. key1的哈希值与已存在的数据的哈希值相同，调用key1所在类的equals(key2)方法:
                    b21. equals()返回false:此时key1-value1添加成功（链表形式）。
                    b22. 如果equals()返回true:使用value1替换value2。(修改)
   扩容：当超出临界值，扩容为原来容量的2倍，拷贝原有数组。

四、HashMap的底层实现原理（JDK7）：
    1. new HashMap()：底层不再创建一个长度为16的数组（饿汉式）。
    2. 底层的数组更改为是：Node[]，而非Entry[]。
    3. 首次调用put()方法时，底层创建长度为16的数组。
    4. 底层结构：数组+链表+红黑树。
        4.1 形成链表时，JDK7中新的元素指向旧的元素。JDK8中旧的元素指向新的元素。
        4.2 数组某索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此索引位置上的数据改为使用红黑树存储。

五、源码分析
    DEFAULT_INITIAL_CAPACITY：HashMap的默认容量，16
    DEFAULT_LOAD_FACTOR：    HashMap的默认加载因子：0.75
    threshold：              扩容的临界值，=容量*填充因子：16 * 0.75 => 12
    TREEIFY_THRESHOLD：      树化阈值：Bucket中链表长度大于该默认值，转化为红黑树:8
    MIN_TREEIFY_CAPACITY：   最小树化容量：桶中的Node被树化时最小的hash表容量:64

六、LinkedHashMap的底层实现原理（了解）
    源码中：
        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;//能够记录添加的元素的先后顺序
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }

七、Map中定义的方法：
    添加、删除、修改操作：
        Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        void putAll(Map m):将m中的所有key-value对存放到当前map中
        Object remove(Object key)：移除指定key的key-value对，并返回value
        void clear()：清空当前map中的所有数据
    元素查询的操作：
        Object get(Object key)：获取指定key对应的value
        boolean containsKey(Object key)：是否包含指定的key
        boolean containsValue(Object value)：是否包含指定的value
        int size()：返回map中key-value对的个数
        boolean isEmpty()：判断当前map是否为空
        boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    元视图操作的方法：
        Set keySet()：返回所有key构成的Set集合
        Collection values()：返回所有value构成的Collection集合
        Set entrySet()：返回所有key-value对构成的Set集合

    总结：常用方法：
        添加：put(Object key,Object value)
        删除：remove(Object key)
        修改：put(Object key,Object value)
        查询：get(Object key)
        长度：size()
        遍历：keySet() / values() / entrySet()

----------------------------------------
*/
public class MapTest {

    //HashMap
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(1,"A");
        map.put(4, "Hello");
        map.put(2, "World");
        System.out.println(map);
    }

    //LinkedHashMap
    @Test
    public void test2(){
        Map map = new LinkedHashMap();
        map.put(1,"A");
        map.put(4, "Hello");
        map.put(2, "World");
        System.out.println(map);
    }
}
