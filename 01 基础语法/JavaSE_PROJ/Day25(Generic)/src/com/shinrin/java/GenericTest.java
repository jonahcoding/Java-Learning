package com.shinrin.java;

/*
----------------------------------------
一、Generic（泛型）
    JDK5引入。

二、集合与泛型
    集合无泛型：
        1.无法在编译器进行类型检查，数据不安全。
        2.获取元素时，需要强制转换（默认类型为java.lang.Object类型），可能出现ClassCastException
    集合使用泛型（在编译器进行类型检查，数据安全。）：
        1.集合接口或集合类在jdk5.0时修改为带泛型的结构。
        2.实例化集合类时可以指明具体的泛型类型，内部结构（方法、构造器、属性等）也应更改为指定的泛型类型。add(E e) --->实add(Integer e)
        3.注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
        4.如果实例化时未指明泛型的类型。默认类型为java.lang.Object类型。

三、自定义泛型结构：
    泛型类，泛型接口，泛型方法：
        1.泛型类型在实例化泛型类（或接口）时指定。
        2.泛型类的对象在调用方法时才确定具体的泛型类型。
        3.静态方法中不能使用类的泛型类型。
        4.静态方法可以使用自身的泛型类型（泛型方法），即泛型方法与所属类是否为泛型类无关。
        5.不能抛出或捕获泛型类的实例，并且泛型类扩展 Throwable 不合法。
        6.异常类不能声明为泛型类：public class MyException<T> extends Exception{}
    注：
        public Order(){
            //编译不通过
            //T[] arr = new T[10];
            //编译通过
            T[] arr = (T[]) new Object[10];
        }

四、类型通配符
    1.通配符：?
        注：如果类A是类B的父类，则G<A>与G<B>无关，二者共同父类是G<?>
        添加（写入）：对于List<?>无法添加内容（除null之外）。
        获取（读取）：读取的数据类型为Object类型。
    2.有限制条件的通配符：
        ? extends A
            G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类。
        ? super A
            G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类。
        可以写入或读取数据。


五、类型推断
    ArrayList<Integer> list = new ArrayList<Integer>();
    替换为：
    ArrayList<Integer> list= new ArrayList();//类型推断

----------------------------------------
*/


import org.junit.Test;
import java.util.*;

public class GenericTest {

    //集合使用泛型之前：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        ArrayList<Integer> list= new ArrayList();//类型推断
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");
        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //集合使用泛型（ArrayList）
    @Test
    public void test2(){
        ArrayList<Integer> list =  new ArrayList<Integer>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");
        //for_each遍历：
//        for(Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        //迭代器遍历：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //集合使用泛型（HashMap）
    @Test
    public void test3(){
//        Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性：类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);
//        map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }
    }

    //通配符
    @Test
    public void test4(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

//        list = list1;
//        list = list2;
//        print(list1);
//        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加（写入）：对于List<?>无法添加内容（除null之外）
        //list.add("DD");
        list.add(null);
        //获取（读取）：读取的数据类型为Object类型。
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
    }

    //限制通配符
    public void test5(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Person> list3 = null;
        List<Object> list4 = null;



    }
}
