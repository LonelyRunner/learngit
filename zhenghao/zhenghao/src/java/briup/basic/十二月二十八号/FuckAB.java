package java.briup.basic.十二月二十八号;

/**
 * Created by ZH on 2015/12/28.
 */
public class FuckAB extends FuckA{
    public FuckAB(){}
    {
        System.out.println("FuckAB is ABFuck!");
    }
    static {
        System.out.println("---------FuckAB--------------");
    }

    public void fun(int i){
        i++;
    }
    public static void main(String args[]){
        FuckAB fuckAB = new FuckAB();

        /** i++ 真他妈的烦人  */
        int i = 0;
//        fuckAB.fun(i);
        i = i++;
        System.out.println(i);
    }
}
class FuckA{
    public FuckA(){}
    {
        System.out.println("FuckA is A Fuck!");
    }

    static {
        System.out.println("------------FuckA----------");
    }

}
