package com.zh.beanAnnotation.generatic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZH on 2016/8/11.
 */
@Configuration
public class StoreConfig1 {

    @Autowired
    private StringStore s1;

    @Autowired
    private IntegerStore s2;

    @Bean
    public StringStore getStringStore(){
        return new StringStore();
    }

    @Bean
    public IntegerStore getIntegerStore(){
        return new IntegerStore();
    }

    @Bean(name="storeTest")
    public Store storeTest(){
        System.out.println("string store : "+s1.getClass().getName());
        System.out.println("integer store : "+s2.getClass().getName());
        return new StringStore();
    }
}
