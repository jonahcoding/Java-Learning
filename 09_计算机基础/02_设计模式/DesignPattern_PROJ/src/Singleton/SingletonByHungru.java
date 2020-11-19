package Singleton;

public class SingletonByHungru {

    String name = null;

    public SingletonByHungru() {}

    private static final SingletonByHungru single = new SingletonByHungru();

    public static SingletonByHungru getInstance(){
        return single;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void printInfo(){
        System.out.println("the name is " + name);
    }
}
