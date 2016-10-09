package com.zh.beanAnnotation;

import com.zh.base.UnitBaseTest;
import com.zh.beanAnnotation.service.BeanService;
import org.junit.Test;

/**
 * Created by ZH on 2016/8/8.
 */
public class AutowiredTest extends UnitBaseTest{

    public AutowiredTest(){
        super("classpath:spring-autowired.xml");
    }

    @Test
    public void testAutoWired(){
        BeanService beanService = super.getBean("beanServiceImpl");
        beanService.save("this is template!");
    }
}
