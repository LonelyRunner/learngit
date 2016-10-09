package javaTest;

import java.math.BigDecimal;

/**
 * Created by ZH on 2016/7/5.
 */
public class NewTest {
    public static void main(String args[]){
        double money1 = 2.0;
        double money2 = 1.1;
        double result = money1-money2;
        System.out.println(result);

        BigDecimal bMoney1 = new BigDecimal("2");
        BigDecimal bMoney2 = new BigDecimal("1.1");
        System.out.println(bMoney1.subtract(bMoney2));
    }
}
