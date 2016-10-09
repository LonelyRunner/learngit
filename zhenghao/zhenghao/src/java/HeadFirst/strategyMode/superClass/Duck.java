package HeadFirst.strategyMode.superClass;

/**
 * Created by ZH on 2015/12/11.
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public abstract void display();

    public void swim(){
        System.out.println("会游泳的旱鸭子？");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    /** 动态的设定行为 */
    /** 我们可以随时调用这两个方法改变鸭子的行为 */
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}
