package com.zh.lifecycle;

import com.zh.base.UnitBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/2.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifecycle extends UnitBaseTest{

    public TestBeanLifecycle(){
        super("classpath:spring-lifecycle.xml");
    }

    @Test
    public void test1(){
        super.getBean("beanLifeCycle");
    }

}
