package com.shinrin.java;

import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
----------------------------------------
TreeSet：
    红黑树实现。
    向TreeSet中添加的数据，要求是相同类的对象（否则无法排序）。

排序：
    1.自然排序（实现Comparable接口）：
        比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    2.定制排序（Comparator）：
        比较两个对象是否相同的标准为：compare()返回0.不再是equals().
----------------------------------------
*/

public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //按升序输出（自然排序）
//        set.add(123);
//        set.add(456);
//        set.add(254);
//        //set.add(new User("Tom",12));//不能添加不同类的对象

        //自然排序：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //自定义排序
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    int compare = -u1.getName().compareTo(u2.getName());
                    if (compare != 0){
                        return compare;
                    }else {
                        return Integer.compare(u1.getAge(),u2.getAge());
                    }
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
