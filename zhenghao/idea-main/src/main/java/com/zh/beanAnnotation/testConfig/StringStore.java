package com.zh.beanAnnotation.testConfig;

/**
 * Created by ZH on 2016/8/9.
 */
public class StringStore implements Store{

    public void init(){
        System.out.println("This is init method!");
    }

    public void destroy(){
        System.out.println("This is destroy method!");
    }
}
