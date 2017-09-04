package com.zh.aop.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidateAspect {

	@Before("com.zh.aop.impl.LoggingAspect.declareExpression()")
	public void beforeLogging1(){
		System.out.println("为了测试通知的优先级~~~");
	}
}
