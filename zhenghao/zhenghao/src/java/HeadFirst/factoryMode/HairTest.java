package HeadFirst.factoryMode;

/**
 * Created by ZH on 2016/9/22.
 */
public class HairTest {

    public static void main(String args[]){
        Hair left = new LeftHair();
        left.draw();

        Hair right = HairFactory.makeHairByKey("right");
        right.draw();

        try{
            Hair leftByClassName = HairFactory.makeHairByClassName("HeadFirst.factoryMode.LeftHair");
            leftByClassName.draw();
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            Hair leftByClassName = HairFactory.makeLeftHairByPrps();
            leftByClassName.draw();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
