package java.briup.method;

/**
 * Created by ZH on 2015/12/25.
 * 递归方法求正整数的阶乘
 */
public class Factorial {
    public static long factorialI(long number){
        if(number<=1l){
            return 1l;
        }else{
            return number*factorialI(number-1);
        }
    }

    public static void main(String args[]){
        System.out.println(factorialI(5));
    }
}
