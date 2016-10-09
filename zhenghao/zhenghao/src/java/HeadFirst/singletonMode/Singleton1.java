package HeadFirst.singletonMode;

/**
 * Created by ZH on 2016/9/20.
 */
//懒汉模式
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(singleton1==null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
