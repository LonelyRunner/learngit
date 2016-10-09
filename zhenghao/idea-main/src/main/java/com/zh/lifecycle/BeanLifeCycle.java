package com.zh.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by ZH on 2016/8/2.
 */
public class BeanLifeCycle  implements InitializingBean,DisposableBean {

    /**
     * implements InitializingBean method
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean implements InitializingBean method : start");
    }

    /**
     * implements DisposableBean method
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean implements DisposableBean method : end ");
    }

    /**
     * 默认初始化方法
     */
    public void defaultInitMethod(){
        System.out.println("Default init method : init_begin");
    }

    /**
     * 默认销毁方法
     */
    public void defaultDestroyMethod(){
        System.out.println("Default destroy method : destroy_end");
    }

    /**
     * Bean自带的初始化方法
     */
    public void start(){
        System.out.println("Bean -- start -- init");
    }

    /**
     * Bean自带的销毁方法
     */
    public void stop(){
        System.out.println("Bean -- stop -- destroy");
    }
}
