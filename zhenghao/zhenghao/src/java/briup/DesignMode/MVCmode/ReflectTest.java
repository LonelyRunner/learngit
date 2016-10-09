package java.briup.DesignMode.MVCmode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ZH on 2016/3/14.
 */
public class ReflectTest {
    public String method1 = "这是方法一";
    public String method2 = "这是方法二";

    public void method1(){
        System.out.println("这是方法1");
    }

    public void method2(){
        System.out.println("这是方法二");
    }

    public static void main(String args[]) throws Exception{
        System.out.println(ReflectTest.class);
        Method[] methods =  ReflectTest.class.getDeclaredMethods();

        for(Method m : methods){
            System.out.println(m.getName());
        }

//        Field[] fields = ReflectTest.class.getDeclaredFields();

//        for(Field field : fields){
////            System.out.println(field.get(field.getName()));
//            System.out.println(field.getName());
//        }

        Field[] fields = ReflectTest.class.getFields();
        for(int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            System.out.println(name);
            //ReflectTest a = new ReflectTest();
            System.out.println(fields[i].get(null));
        }

        }
}
