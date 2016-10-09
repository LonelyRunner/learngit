package com.zh.beanAnnotation.testConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by ZH on 2016/8/9.
 * 相当于配置文件
 */

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {

    @Value("${url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean(name="stringStore",initMethod = "init",destroyMethod = "destroy")
    public Store getStringStore(){
        return new StringStore();
    }
    /**
     * 如果@Bean没有指定name的话 方法名将作为beanId名
     * 相当于配置文件中的<bean id="getStringStore" class="com.zh.beanAnnotation.testConfig.StringStore"></bean>
     */


    @Bean
    public MyDriverManager getMyDriverManager(){
        return new MyDriverManager(url,username,password);
    }
}
