package com.zh.autowiring;

import com.zh.base.UnitBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/8/3.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring extends UnitBaseTest{

    public TestAutoWiring(){
        super("classpath:spring-autowiring.xml");
    }

    @Test
    public void testA(){
        AutoWiringService autoWiringService = super.getBean("autoWiringService");
        autoWiringService.say("constructor method : hello!");
    }
}
