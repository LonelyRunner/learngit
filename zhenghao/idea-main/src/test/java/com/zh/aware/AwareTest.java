package com.zh.aware;

import com.zh.base.UnitBaseTest;
import org.junit.Test;

/**
 * Created by ZH on 2016/8/2.
 */
public class AwareTest extends UnitBaseTest{

    public AwareTest(){
        super("classpath:spring-aware.xml");
    }

    @Test
    public void testOne(){
        System.out.println("testImoocBeanName : "+super.getBean("imoocBeanName").hashCode());
    }
}
