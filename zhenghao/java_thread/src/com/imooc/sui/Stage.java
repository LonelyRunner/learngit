package com.imooc.sui;

/**
 * Created by ZH on 2016/9/5.
 */
public class Stage  extends Thread {

    public void run(){
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread suiDynasty = new Thread(armyTaskOfSuiDynasty,"随军");
        Thread revolt = new Thread(armyTaskOfRevolt,"起义军");

        suiDynasty.start();
        revolt.start();

        try{
            Thread.sleep(50);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            revolt.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String args[]){
        new Stage().start();
    }
}
