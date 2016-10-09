package HeadFirst.AdapterMode;

/**
 * Created by ZH on 2016/9/21.
 */
public class TranTwoToThree implements ThreePower{

    private GBTwoPower gbTwoPower;

    public TranTwoToThree(GBTwoPower gbTwoPower){
        this.gbTwoPower = gbTwoPower;
    }

    @Override
    public void powerByThree() {
        System.out.println(":::::::::::::::::组合的方式:::::::::::::::::");
        gbTwoPower.powerByTwo();
    }
}
