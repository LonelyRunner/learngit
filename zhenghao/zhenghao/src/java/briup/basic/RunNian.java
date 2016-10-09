package java.briup.basic;

import java.util.Scanner;

/**
 * Created by ZH on 2016/2/4.
 */
public class RunNian {
    /** 四年一闰；百年不闰,四百年再闰 */
    public static void main(String args[]){
        int year = new Scanner(System.in).nextInt();

        if(year%4==0 && year%100!=0 || year%400==0){
            System.out.println(year+"年是闰年！");
        }else {
            System.out.println(year + "年不是闰年！");
        }
    }
}
