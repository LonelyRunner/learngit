package HeadFirst.strategyMode.subClass.quack;

import HeadFirst.strategyMode.superClass.QuackBehavior;

/**
 * Created by ZH on 2015/12/11.
 */
public class GuaGua implements QuackBehavior{
    public void quack(){
        System.out.println("呱呱叫的鸭子......");
    }
}
