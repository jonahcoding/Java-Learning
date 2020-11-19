package Singleton;

public class SingletonByDCL {
    private SingletonByDCL(){}
    private static volatile SingletonByDCL single = null;

    public static SingletonByDCL getInstance(){
        if (null == single){
            synchronized (SingletonByDCL.class){
                if (null == single){
                    single = new SingletonByDCL();
                }
            }
        }
        return single;
    }
}
