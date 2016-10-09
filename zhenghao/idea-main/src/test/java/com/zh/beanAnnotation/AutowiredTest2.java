package com.zh.beanAnnotation;

import com.zh.base.UnitBaseTest;
import com.zh.beanAnnotation.autowired2.BeanAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/8.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AutowiredTest2 extends UnitBaseTest{

    public AutowiredTest2(){
        super("classpath:spring-autowired.xml");
    }

    //注意@order注解只影响list集合 不会影响map集合中的beanId顺序
    @Test
    public void test2(){
        BeanAware beanAware = getBean("beanAware");
        beanAware.sayList();

        beanAware.sayMap();

        beanAware.sayQualifier();
    }
}
