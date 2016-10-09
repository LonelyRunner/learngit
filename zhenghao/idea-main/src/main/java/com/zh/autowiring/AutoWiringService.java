package com.zh.autowiring;

/**
 * Created by ZH on 2016/8/3.
 */
public class AutoWiringService {

    private AutoWiringDao autoWiringDao;

    public AutoWiringService(AutoWiringDao autoWiringDao) {
        this.autoWiringDao = autoWiringDao;
    }

    public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
        System.out.println("是否调用了set方法");
        this.autoWiringDao = autoWiringDao;
    }

    public void say(String word){
        this.autoWiringDao.say(word);
    }
}
