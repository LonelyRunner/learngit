package com.zh.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * Created by ZH on 2016/7/12.
 */
public class UnitBaseTest {
    private ClassPathXmlApplicationContext context;

    private String springXmlpath;

    public UnitBaseTest() {}

    public UnitBaseTest(String springXmlpath) {
        this.springXmlpath = springXmlpath;
    }

    @Before
    public void before() {
        if (StringUtils.isEmpty(springXmlpath)) {
            springXmlpath = "classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.destroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T)context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }
}
