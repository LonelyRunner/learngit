package com.zh.beanAnnotation.testConfig;

/**
 * Created by ZH on 2016/8/9.
 */
public class MyDriverManager {

    public MyDriverManager(String url,String username,String password){
        System.out.println("url:"+url);
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
