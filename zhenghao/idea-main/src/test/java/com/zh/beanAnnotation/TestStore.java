package com.zh.beanAnnotation;

import com.zh.base.UnitBaseTest;
import com.zh.beanAnnotation.testConfig.MyDriverManager;
import com.zh.beanAnnotation.testConfig.Store;
import org.junit.Test;

/**
 * Created by ZH on 2016/8/9.
 */
public class TestStore extends UnitBaseTest{

    public TestStore(){
        super("classpath:spring-beanAnnotation.xml");
    }

    @Test
    public void testStringStore(){
        Store store = super.getBean("stringStore");
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testMyDriverManager(){
        MyDriverManager myDriverManager = super.getBean("getMyDriverManager");
        System.out.println(myDriverManager.getClass().getName());
    }
}
