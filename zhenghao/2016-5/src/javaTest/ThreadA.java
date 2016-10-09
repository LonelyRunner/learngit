package javaTest;

/**
 * Created by ZH on 2016/5/25.
 */
public class ThreadA extends Thread{

    public void run(){
        System.out.println("ThreadA run...");
    }

    public static void main(String args[]){
        ThreadA threadA = new ThreadA();
        try{
//            threadA.wait(1000);
            Thread.sleep(2000);
            threadA.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
