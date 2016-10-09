package java.briup.method;

/**
 * Created by ZH on 2015/12/25.
 * 斐波那契数列
 */
public class Fibonacci {
    public static long fibonacciI(long number){
        if(number == 0 || number == 1){
            return number;
        }else{
            return fibonacciI(number - 2)+fibonacciI(number - 1);
        }
    }
    public static void main(String args[]){
        for(int i=0;i<13;i++){
            System.out.println("fibonacci["+(i+1)+"]="+fibonacciI(i));
        }
    }
}
