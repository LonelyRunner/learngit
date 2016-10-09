package com.zh.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by ZH on 2016/8/4.
 */
public class ResourceBean implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void resource(){
//        Resource resource = applicationContext.getResource("classpath:context.txt");
//        Resource resource = applicationContext.getResource("file:E:\\zhenghao\\idea-main\\src\\main\\resources\\context.txt");
        Resource resource = applicationContext.getResource("context.txt"); //默认为classpath
        try {
            System.out.println(resource.contentLength());
            System.out.println(resource.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
