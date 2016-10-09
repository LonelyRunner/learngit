package HeadFirst.strategyMode.subClass.quack;

import HeadFirst.strategyMode.superClass.QuackBehavior;

/**
 * Created by ZH on 2015/12/11.
 */
public class ZhiZhi implements QuackBehavior{
    public void quack(){
        System.out.println("吱吱叫的鸭子......");
    }
}
