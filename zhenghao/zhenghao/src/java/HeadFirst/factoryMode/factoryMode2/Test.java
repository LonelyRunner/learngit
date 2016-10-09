package HeadFirst.factoryMode.factoryMode2;

/**
 * Created by ZH on 2016/9/22.
 */
public class Test {
    public static void main(String args[]){
        Boy boy = new HNFac().getBoy();
        boy.drawB();

        Boy boy1 = new WCFac().getBoy();
        boy1.drawB();

        Girl girl = new HNFac().getGirl();
        girl.drawG();

        Girl girl1 = new WCFac().getGirl();
        girl1.drawG();
    }
}
