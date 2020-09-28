package com.shinrin.java;

import org.junit.Test;

import java.util.*;

/*
----------------------------------------
一、List接口框架
    |----Collection接口：单列集合，元素为单个对象。
        |----List接口：存储有序、元素可重复。（以下为实现类）
            |----ArrayList：查找快，增删慢，线程不安全的，应用于查询数据；底层使用Object[] elementData存储（数组）
            |----LinkedList：查找慢，增删快，应用于首尾增删数据；底层使用双向链表存储
            |----Vector：线程安全，效率低；底层使用Object[] elementData存储（数组）

二、ArrayList的源码分析：
    JDK7：
        1.无参构造时创建容量为10的数组。(懒汉式)
        2.容量不足时，扩容为原容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
        结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
    JDK8：
        1.无参构造时初始化为{}，第一次调用add()时再创建容量为10的数组。
    总结：
        JDK7中的ArrayList的对象的创建类似于单例的饿汉式。
        JDK8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。

三、LinkedList的源码分析：
    LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
    list.add(123);//将123封装到Node中，创建了Node对象。
    其中，Node定义为（双向链表）：
        private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }

四、Vector的源码分析：
    JDK7和JDK8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
    在扩容方面，默认扩容为原来的数组长度的2倍。

面试题：ArrayList、LinkedList、Vector三者的异同？
    相同点：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
    不同点：ArrayList（查找快，增删慢，线程不安全）和Vector（线程安全）底层由数组实现，LinkedList（查找慢，增删快）底层由链表实现。

五、List的方法
    增删改查：
        void add(Object ele):
        void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
    长度：size()
    遍历：① Iterator迭代器方式
         ② 增强for循环
         ③ 普通的循环

六、LinkedList的方法
    首尾增删相关操作：
        public void addFirst(E e):将指定元素插入此列表的开头。
        public void addLast(E e):将指定元素添加到此列表的结尾。
        public E getFirst():返回此列表的第一个元素。
        public E getLast():返回此列表的最后一个元素。
        public E removeFirst():移除并返回此列表的第一个元素。
        public E removeLast():移除并返回此列表的最后一个元素。
        public E pop():从此列表所表示的堆栈处弹出一个元素。
        public void push(E e):将元素推入此列表所表示的堆栈。
        public boolean isEmpty()：如果列表不包含元素，则返回true。

----------------------------------------
 */
public class ListTest {

    @Test
    public void test4() {
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

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***************");
        //方式二：增强for循环
        for(Object obj : list){
            System.out.println(obj);
        }
        System.out.println("***************");
        //方式三：普通for循环
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        int index = list.indexOf(4567);
        System.out.println(index);
        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
        System.out.println(list.lastIndexOf(456));
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);
        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);
    }

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        System.out.println(list);
        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
//        list.add(list1);
        System.out.println(list.size());//9
        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));
    }
}
