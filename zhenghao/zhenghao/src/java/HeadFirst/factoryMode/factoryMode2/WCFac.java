package HeadFirst.factoryMode.factoryMode2;

/**
 * Created by ZH on 2016/9/22.
 */
public class WCFac implements DrawPerson{

    public Boy getBoy(){
        return new WCBoy();
    }

    public Girl getGirl(){
        return new WCGirl();
    }
}
