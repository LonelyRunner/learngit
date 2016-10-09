package java.briup.basic.排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ZH on 2016/1/18.
 */
public class SampleComparator implements Comparator<String>{

    public int compare(String o1,String o2){
        return toInt(o1)-toInt(o2);
    }

    private int toInt(String str){
         str = str.replaceAll("一","1");
         str = str.replaceAll("二","2");
         str = str.replaceAll("三","3");

        return Integer.parseInt(str);
    }

    public static void main(String args[]){
        String[] str = new String[]{"一二","三","二"};

        Arrays.sort(str, new SampleComparator());

        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}
