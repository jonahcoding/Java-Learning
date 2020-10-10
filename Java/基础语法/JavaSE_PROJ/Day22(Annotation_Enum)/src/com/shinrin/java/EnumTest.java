package com.shinrin.java;
/*
----------------------------------------
枚举类：
一、枚举类
    1.类的对象有限个（确定）。
    2.可用于定义一组常量（相关）。
    3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。

二、如何定义枚举类
    方式一：jdk5.0之前，自定义
    方式二：jdk5.0，使用enum关键字定义

三、Enum类中的常用方法：
    values()方法：遍历枚举值，返回枚举类型的对象数组。
    valueOf(String str)：将一个字符串（枚举类对象名）转为对应的枚举类对象。如非枚举类对象名：IllegalArgumentException。
    toString()：返回当前枚举类对象常量的名称

四、使用enum关键字定义的枚举类实现接口的情况
    情况一：实现接口，在enum类中实现抽象方法
    情况二：让枚举类的对象分别实现接口中的抽象方法

----------------------------------------
自定义枚举类：
    1.声明Season对象的属性
    2.私有化类的构造器,并给对象属性赋值
    3.提供当前枚举类的多个对象
    4.获取枚举类对象的属性
    5.提供toString()
----------------------------------------
enum定义枚举类：
    1.提供当前枚举类的多个对象
    2.声明Season对象的属性
    3.私有化类的构造器,并给对象属性赋值
    4.获取枚举类对象的属性
----------------------------------------
*/

public class EnumTest {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);

        System.out.println("----------");

        Season2 autumn = Season2.AUTUMN;
        //1.调用toString()：
        System.out.println(autumn.toString());//AUTUMN
        //2.调用values()：
        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //3.调用valueOf(String objName)方法：返回对象名是objName的对象。
        //未找到则抛出异常：java.lang.IllegalArgumentException
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);
        //测试接口方法
        winter.show();
    }
}

//自定义枚举类
class Season1 {
    //1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象
    public static final Season1 SPRING = new Season1("春天", "春暖花开");
    public static final Season1 SUMMER = new Season1("夏天", "夏日炎炎");
    public static final Season1 AUTUMN = new Season1("秋天", "秋高气爽");
    public static final Season1 WINTER = new Season1("冬天", "冰天雪地");
    //4.获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }
    public String getSeasonDesc(){
        return seasonDesc;
    }
    //5.提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "sersonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

//枚举类实现接口
enum Season2 implements Info{

    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("OMG Spring!");
        }
    },
    SUMMER ("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("OMG Summer!");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("OMG Autumn!");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("OMG Winter!");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName(){
        return seasonName;
    }
    public String getSeasonDesc(){
        return seasonDesc;
    }

//    //5.提供toString()
//    @Override
//    public String toString() {
//        return "Season{" +
//                "sersonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
//    //实现接口的抽象方法
//    @Override
//    public void show() {
//        System.out.println("A season!");
//    }
}

//接口
interface Info{
    public abstract void show();
}






