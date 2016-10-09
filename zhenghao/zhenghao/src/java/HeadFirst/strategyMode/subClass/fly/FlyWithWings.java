package HeadFirst.strategyMode.subClass.fly;

import HeadFirst.strategyMode.superClass.FlyBehavior;

/**
 * Created by ZH on 2015/12/11.
 */
public class FlyWithWings implements FlyBehavior{
    public void fly(){
        System.out.println("I'm a flyable strategyMode!");
    }
}
