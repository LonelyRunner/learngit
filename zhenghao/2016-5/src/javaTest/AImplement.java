package javaTest;

/**
 * Created by ZH on 2016/7/11.
 */
public class AImplement implements AInterface{

    public String toDoSomeThing(String str){
        return "Hello world,"+str+"!";
    }

    public static void main(String args[]){
        //spring 面向接口编程
        AInterface ai = new AImplement();
        String str = ai.toDoSomeThing("James");
        System.out.println(str);
    }
}
