package com.zh.resource;

import com.zh.base.UnitBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/4.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ResourceBeanTest extends UnitBaseTest{

    public ResourceBeanTest(){
        super("classpath:spring-resource.xml");
    }

    @Test
    public void testResource(){
        ResourceBean resourceBean = super.getBean("resourceBean");
        resourceBean.resource();
    }
}
