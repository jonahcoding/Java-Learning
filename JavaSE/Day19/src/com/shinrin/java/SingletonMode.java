package com.shinrin.java;
//懒汉式，线程安全
public class SingletonMode {

}

class Singleton{
    private Singleton(){};
    private static Singleton instance = null;
    private static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
