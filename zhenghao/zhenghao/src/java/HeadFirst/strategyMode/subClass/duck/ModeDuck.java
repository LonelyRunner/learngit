package HeadFirst.strategyMode.subClass.duck;

import HeadFirst.strategyMode.subClass.fly.FlyNoWay;
import HeadFirst.strategyMode.subClass.quack.ZhiZhi;
import HeadFirst.strategyMode.superClass.Duck;

/**
 * Created by ZH on 2015/12/11.
 */
public class ModeDuck extends Duck {

    public ModeDuck(){
        quackBehavior = new ZhiZhi();
        flyBehavior = new FlyNoWay();
    }
    public void display(){
        System.out.println("突然下的一场雪，飘的那么纯洁......");
    }
}
