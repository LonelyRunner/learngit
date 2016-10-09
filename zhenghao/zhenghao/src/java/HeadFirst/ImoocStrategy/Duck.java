package HeadFirst.ImoocStrategy;

/**
 * Created by ZH on 2016/9/23.
 */
public abstract class Duck {

    public void quack(){
        System.out.println("嘎嘎叫.....");
    }

    abstract void display();

    private FlyInterface flyInterface;

    public void setFlyInterface(FlyInterface flyInterface) {
        this.flyInterface = flyInterface;
    }

    public void fly(){
        flyInterface.performedFly();
    }
}
