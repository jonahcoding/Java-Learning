package Singleton;

public class Test {
    public static void main(String[] args){
        SingletonByHungru ts1 = SingletonByHungru.getInstance();
        ts1.setName("jason");
        SingletonByHungru ts2 = SingletonByHungru.getInstance();
        ts2.setName("0539");

        ts1.printInfo();
        ts2.printInfo();

        if(ts1.equals(ts2)){
            System.out.println("创建的是同一个实例");
        }else{
            System.out.println("创建的不是同一个实例");
        }
    }
}
