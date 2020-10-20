package com.shinrin.java;


import org.junit.Test;

import java.util.*;


public class TreeMapTest {

    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Yasuo", 27);
        User u2 = new User("Teemo", 7);
        User u3 = new User("ZOE", 9999);
        map.put(u1,500);
        map.put(u2,50);
        map.put(u3,1000);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }


    //自定义排序
    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int compare = -u1.getName().compareTo(u2.getName());
                    if (compare != 0) {
                        return compare;
                    } else {
                        return Integer.compare(u1.getAge(), u2.getAge());
                    }
                } else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeMap map = new TreeMap();
        User u1 = new User("Yasuo", 27);
        User u2 = new User("Teemo", 7);
        User u3 = new User("ZOE", 9999);
        map.put(u1,500);
        map.put(u2,50);
        map.put(u3,1000);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
