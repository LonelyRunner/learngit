package com.zh.beanAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ZH on 2016/8/8.
 */

@Scope
//@Scope("prototype")
@Component
//@Component("bean")
public class BeanAnnotation {

    public void say(String arg){
        System.out.println("BeanAnnotation : "+arg);
    }

    public void testScopeByBeanAnnotation(){
        System.out.println("BeanAnnotation : "+this.hashCode());
    }
}

