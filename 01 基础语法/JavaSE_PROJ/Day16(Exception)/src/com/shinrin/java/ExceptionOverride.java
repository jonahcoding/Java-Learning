package com.shinrin.java;

/*
--------------------
五、方法重写规则：
        子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型。
--------------------
*/

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionOverride {

    public static void main(String[] args) {
        ExceptionOverride test = new ExceptionOverride();
        test.display(new SubClass());
    }

    public void display(SubClass s){
        try{
            s.method();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class SuperClass{
    public void method() throws IOException{

    }
}

class SubClass{
    public void method() throws FileNotFoundException{

    }
}