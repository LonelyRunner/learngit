package com.zh.injection;

import com.zh.base.UnitBaseTest;
import com.zh.service.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZH on 2016/7/12.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitBaseTest{

    public TestInjection(){
        super("classpath:spring-injection.xml");
    }

    /**
     * 测试set方法
     */
    @Test
    public void testSetter(){
        InjectionService injectionService = super.getBean("injectionServiceImpl");
        injectionService.sayHello("这是setter方法保存的数据");
    }

    /**
     * 测试构造方法
     */
    @Test
    public void testCon(){
        InjectionService injectionService = super.getBean("injectionService");
        injectionService.sayHello("这是constructor方法保存数据");
    }
}
