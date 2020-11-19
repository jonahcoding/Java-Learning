package Singleton;

public class SingletonByInternalStaticClass {
    private static class LazyHolder{
        private static final SingletonByInternalStaticClass INSTANCE = new SingletonByInternalStaticClass();
    }

    public SingletonByInternalStaticClass() {}

    public static SingletonByInternalStaticClass getInstance(){
        return LazyHolder.INSTANCE;
    }
}
