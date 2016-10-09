package HeadFirst.strategyMode.subClass.duck;

import HeadFirst.strategyMode.subClass.fly.FlyWithWings;
import HeadFirst.strategyMode.subClass.quack.ZhiZhi;
import HeadFirst.strategyMode.superClass.Duck;

/**
 * Created by ZH on 2015/12/11.
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        quackBehavior = new ZhiZhi();
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("我是一只绿头鸭!!!!!!!!");
    }
}
