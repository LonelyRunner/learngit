package com.zh.beanAnnotation;

import com.zh.base.UnitBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/8.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanAnnotationTest extends UnitBaseTest{

    public BeanAnnotationTest(){
        super("classpath:spring-beanAnnotation.xml");
    }

    @Test
    public void testSay(){
        /**
         *
         * 当类中加注解@Component beanId="beanAnnotation"
         * BeanAnnotation beanAnnotation = super.getBean("beanAnnotation");
         * beanAnnotation.say("hello world!");
         */
        //@Component("bean")  beanId="bean"
        BeanAnnotation bean = getBean("bean");
        bean.say("和仁IT");
    }

    @Test
    public void testScopeByBeanAnnotation(){
        //@scope("prototype")
        //@scope && @scope("singleton")
        BeanAnnotation bean = getBean("beanAnnotation");
        bean.testScopeByBeanAnnotation();

        bean = getBean("beanAnnotation");
        bean.testScopeByBeanAnnotation();
    }
}
