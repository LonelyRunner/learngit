package com.zh.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by ZH on 2016/8/2.
 */
public class ImoocBeanName implements BeanNameAware,ApplicationContextAware{

    private String beanName;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("ImoocBeanName : "+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:"+applicationContext.getBean(this.beanName).hashCode());
    }
}
