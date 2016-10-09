package HeadFirst.strategyMode.subClass.quack;

import HeadFirst.strategyMode.superClass.QuackBehavior;

/**
 * Created by ZH on 2015/12/11.
 */
public class NoQuack  implements QuackBehavior{
    public void quack(){
        System.out.println("不会叫的鸭子......");
    }
}
