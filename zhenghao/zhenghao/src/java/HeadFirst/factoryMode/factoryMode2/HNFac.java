package HeadFirst.factoryMode.factoryMode2;

/**
 * Created by ZH on 2016/9/22.
 */
public class HNFac implements DrawPerson{

    public Boy getBoy(){
        return new HNBoy();
    }

    public Girl getGirl(){
        return new HNGirl();
    }
}
