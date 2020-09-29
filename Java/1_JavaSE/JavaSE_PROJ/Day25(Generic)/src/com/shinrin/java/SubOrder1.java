package com.shinrin.java;

import java.util.ArrayList;
import java.util.List;

//泛型类的非泛型子类
public class SubOrder1 extends Order<Integer> {

    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}