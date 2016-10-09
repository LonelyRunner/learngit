package HeadFirst.strategyMode.Test;

import HeadFirst.strategyMode.subClass.duck.MallardDuck;
import HeadFirst.strategyMode.subClass.duck.ModeDuck;
import HeadFirst.strategyMode.subClass.fly.FlyWithWings;
import HeadFirst.strategyMode.superClass.Duck;

/**
 * Created by ZH on 2015/12/11.
 */
public class DuckTest {
    public static void main(String args[]){
        Duck mallardDuck = new MallardDuck();

        System.out.println("绿头鸭...............................................");
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.swim();
        mallardDuck.display();
        System.out.println("绿头鸭...............................................");

        Duck modeDuck = new ModeDuck();
        System.out.println("模型鸭-----------------------------------------------");
        modeDuck.performFly();
        modeDuck.setFlyBehavior(new FlyWithWings());
        modeDuck.performFly();
        System.out.println("模型鸭-----------------------------------------------");
    }
}
