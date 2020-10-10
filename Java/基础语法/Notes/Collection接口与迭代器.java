import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
========================================
【Collection集合】
----------------------------------------
一、什么是集合
    Java容器，存储多个数据。

二、集合与数组的区别是什么
    1. 集合长度可变，数组长度固定。
    2. 集合只存储对象（不同类型），数组可存储基本数据类型和引用数据类型（同一类型）。

三、集合接口框架
    3.1 集合分类（存储结构）：
        单列集合：java.util.Collection
        双列集合：java.util.Map
        注：

    3.2 Collection接口
        单列集合类的根接口（java.util），定义单列集合框架共性内容。

    3.3 Collection的子接口
        List接口：java.util.List （元素有序、可重复、有索引（for遍历））
        Set接口：java.util.Set （元素无序、不重复、无索引）

四、Collection集合常用方法
    public boolean add(E e)： 添加元素 。
    public boolean remove(E e): 删除元素。
    public boolean contains(E e): 是否包含指定元素。
    public void clear() :清空集合。
    public boolean isEmpty(): 当前集合是否为空。
    public int size(): 集合元素个数。
    public Object[] toArray(): 把集合中的元素存储到数组。

五、示例（Collection接收ArrayList）
    CollectionTest.CollectionDemo();
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
========================================
*/

/**
 * Collection接口
 */
class CollectionTest{
    public static void CollectionDemo() {

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

/**
 * Iterator迭代器
 */
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

/**
 * for_each 循环
 */
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