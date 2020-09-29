
/*
========================================
【泛型】
----------------------------------------
【泛型】
一、什么是泛型？
    模板，多种数据类型执行相同的代码，具体类型在使用时指定。
	泛型的本质是参数化类型，即所操作的数据类型被指定为一个参数。
	类型擦除：
		Java的泛型是伪泛型，即Java泛型仅在编译期有效，运行期被擦除。（与C++泛型的区别）

二、泛型的特点
        1.对象存储到集合后被提升成Object类型，当取出对象时，必须进行类型转换。
        3.泛型不支持继承。

三、泛型与类
    创建类的对象的时候确定类型。
    class GenericClass<E>{
        private E name;
        public E getName(){
            return name;
        }
        public void setName(E name){
            this.name = name;
        }
    }

四、泛型与方法
    调用方法时确定数据类型（由传递的参数决定）。
    public static <M> void Method(M m){
        System.out.println(m);
    }

五、泛型与接口
    方式一：实现类时确定类型。
    方式二：创建类的对象时确定类型。

六、泛型通配符：
    ?：代表任意的数据类型。
    使用方式：
        集合作为方法参数并且元素类型未知使用通配符接收方法参数，不能用作创建对象。
    常用的通配符为： T，E，K，V，?
		1. ?：表示不确定的 java 类型
		2. T (type) ：表示具体的一个java类型
		3. K V (key value) ：分别代表java键值中的Key Value
		4. E (element) ：代表Element

七、泛型的上下限
    上限：? extends E  （使用的泛型只能是E的子类和E）
    下限：? super E    （使用的泛型只能是E的父类或E）

----------------------------------------
========================================
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//泛型类
class GenericClass<E>{
    private E name;
    public E getName(){
        return name;
    }
    public void setName(E name){
        this.name = name;
    }
}

//泛型方法
class GenericMethod{
    public static <M> void Method(M m){
        System.out.println(m);
    }
}

//泛型接口
interface GenericInterface<I>{
    public abstract void method(I i);
}
//泛型接口类的实现一：创建类的时候确定类型
class GenericInterfaceImpl1 implements GenericInterface<String>{
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
//泛型接口类的实现二：创建类的对象时确定类型
class GenericInterfaceImpl2<I> implements GenericInterface<I>{
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}

//泛型测试
class GenericTest {

    //测试泛型类
    public static void GenericClassTest(){
        GenericClass gc1 = new GenericClass();
        gc1.setName("Teemo");
        Object obj = gc1.getName();//返回类型为Obj类型

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1);
        Integer in = gc2.getName();//返回类型为Integer
    }

    //测试泛型方法
    public static void GenericMethod(){
        GenericMethod.Method(13);
    }

    //测试泛型接口
    public static void GenericInterface(){
        GenericInterfaceImpl1 GI1 = new GenericInterfaceImpl1();
        GI1.method("Hello Kitty");
        GenericInterfaceImpl2<Integer> GI2 = new GenericInterfaceImpl2<>();
        GI2.method(15);
    }

    //泛型通配符
    public static void GenericDemo() {
        ArrayList<String> list01 = new ArrayList<>();
        list01.add("Hello");
        list01.add("World");

        ArrayList<Integer> list02 = new ArrayList<>();
        list02.add(0);
        list02.add(1);

        printArray(list01);
        printArray(list02);
    }

    //list类型未知，使用通配符接收
    public static void printArray(ArrayList<?> list){
        //使用迭代器遍历
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            //迭代器取出的元素类型为Object
            Object o = it.next();
            System.out.println(o);
        }
    }

    //泛型上下限
    public static void GenericLimit(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement1(list1);
        //getElement1(list2);//报错
        getElement1(list3);
        //getElement1(list4);//报错

        //getElement2(list1);//报错
        //getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);

    }
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}
}
