package com.imooc.sui;

/**
 * Created by ZH on 2016/9/5.
 */
public class ArmyRunnable implements Runnable {
    //保证了线程可以正确的读取其他线程写入的值
    //可见性  ref-jmm  happens-before原则
    volatile boolean keepRunning = true;

    public void run() {

        System.out.println(Thread.currentThread().getName()+"准备出击");

        while (keepRunning){
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻军队["+i+"]");
                //该线程让出处理器,保证下次进攻的公平性(下次进攻双方的不确定性)
                Thread.yield();
            }
        }
    }
}
