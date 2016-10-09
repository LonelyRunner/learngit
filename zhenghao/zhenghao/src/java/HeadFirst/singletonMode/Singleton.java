package HeadFirst.singletonMode;

/**
 * Created by ZH on 2016/9/20.
 */

//饿汉模式
public class Singleton {
    //私有的类成员变量
    private static Singleton singleton = new Singleton();
    //私有的构造器
    private Singleton(){}
    //共有的类get方法
    public static Singleton getInstance(){
        return singleton;
    }
}
