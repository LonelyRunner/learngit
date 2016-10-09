package HeadFirst.ImoocStrategy;

import HeadFirst.ImoocStrategy.Impl.FlyWithWings;

/**
 * Created by ZH on 2016/9/23.
 */
public class DuckTest {

    public static void main(String[] args){
        Duck redDuck = new RedDuck();
        redDuck.setFlyInterface(new FlyWithWings());

        System.out.println("测试红头鸭开始......");
        redDuck.quack();
        redDuck.fly();
        redDuck.display();
        System.out.println("测试红头鸭结束......");


        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");


        Duck greenDuck = new GreenDuck();
        greenDuck.setFlyInterface(new FlyWithWings());

        System.out.println("测试绿头鸭开始......");
        greenDuck.quack();
        greenDuck.fly();
        greenDuck.display();
        System.out.println("测试绿头鸭结束......");
    }
}
