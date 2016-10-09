package com.zh.beanAnnotation;

import com.zh.base.UnitBaseTest;
import com.zh.beanAnnotation.generatic.StringStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/11.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestGenerator extends UnitBaseTest{

    public TestGenerator(){
        super("classpath:spring-beanAnnotation.xml");
    }

    @Test
    public void testG(){
        StringStore store = getBean("storeTest");
    }
}
