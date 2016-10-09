package HeadFirst.strategyMode.subClass.fly;

import HeadFirst.strategyMode.superClass.FlyBehavior;

/**
 * Created by ZH on 2015/12/11.
 */
public class FlyNoWay implements FlyBehavior{
    public void fly(){
        System.out.println("I am not a flyable strategyMode!");
    }
}
