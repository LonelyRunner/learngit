package com.zh.beanAnnotation.autowired2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by ZH on 2016/8/8.
 */
@Order(2)
@Component
public class BeanAutowiredOne implements BeanAutowired{
}
