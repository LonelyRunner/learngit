package HeadFirst.AdapterMode;

/**
 * Created by ZH on 2016/9/21.
 */
public class TranTwoToThreeExtends extends GBTwoPower implements ThreePower{

    @Override
    public void powerByThree() {
        System.out.println(":::::::::::::::::通过继承和实现接口的方式:::::::::::::::::");
        this.powerByTwo();
    }
}
