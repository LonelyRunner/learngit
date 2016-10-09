package com.immoc.zh;

import static java.lang.Thread.sleep;

/**
 * Created by ZH on 2016/9/5.
 */
public class Actor extends Thread{

    public void run(){
        System.out.println(getName()+"演出开始了...");

        boolean keepRunning = true;
        int count=0;
        while(keepRunning){
            System.out.println(getName()+"-"+(++count)+"演出开始...");
            if(count%10==0){
                try{
                    sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(count==100){
                keepRunning = false;
            }
        }

        System.out.println(getName()+"演出结束了...");
    }

    public static void main(String args[]){
        Thread actor = new Actor();
        actor.setName("actor1");
        actor.start();

        Thread actress = new Thread(new Actress(),"Miss.actress1");
        actress.start();
    }
}

class Actress implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+"演出开始了...");

        boolean keepRunning = true;
        int count=0;
        while(keepRunning){
            System.out.println(Thread.currentThread().getName()+"-"+(++count)+"演出开始...");
            if(count%10==0){
                try{
                    sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(count==100){
                keepRunning = false;
            }
        }

        System.out.println(Thread.currentThread().getName()+"演出结束了...");
    }
}