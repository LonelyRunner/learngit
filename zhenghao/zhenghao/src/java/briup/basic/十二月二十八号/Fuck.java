package java.briup.basic.十二月二十八号;

import java.util.List;

/**
 * Created by ZH on 2015/12/28.
 */
public class Fuck {
    public void printYou(){
        System.out.println("Fuck you !");
    }

    public int getSize(List list){
        return list.size();
    }

    public int getArrayLength(String[] str){
        return str.length;
    }

    public int getStringLength(String str){
        return str.length();
    }

    public static void main(String args[]){
        Integer i1 = new Integer(47);
        Integer i2 = new Integer(47);
        System.out.println("i1 == i2 ? "+(i1 == i2));
        System.out.println("i1 != i2 ? "+(i1 != i2));
        System.out.println("i1.equals(i2) ? "+(i1.equals(i2)));
    }
}
