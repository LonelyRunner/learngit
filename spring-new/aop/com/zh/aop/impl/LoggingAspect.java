package com.zh.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面类
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	//用@Point来声明切入点
	@Pointcut(value="execution(* com.zh.aop.impl.*.*(..))")
	public void declareExpression(){}
	

	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("declareExpression()")
	public void beforeLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("前置通知"+methodName+"~~~"+args);
	 }
	
	/**
	 * 后置通知  访问不到返回值
	 * 在方法执行之后执行的代码 --不管该方法是否出现异常
	 * @param joinPoint
	 */
	@After("declareExpression()")
	public void afterLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("后置通知"+methodName+"~~~"+args);
	 }
	
	/**
	 * 返回通知 可以访问到返回的结果
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value="declareExpression()",returning="result")
	public void resultLogging(JoinPoint joinPoint,Object result){
		System.out.println("返回通知:结果为~~~"+result);
	}
	
	/**
	 * 异常通知  当所执行的方法出现异常时 可捕获该异常信息  并将该异常抛出;
	 * @param joinPoint
	 * @param exception : 此处可以指定异常类型 如NullPointException这个类型时  只捕获空指针异常
	 */
	@AfterThrowing(value="declareExpression()",throwing="exception")
	public void exceptionLogging(JoinPoint joinPoint,Exception exception){
		System.out.println("异常通知:遇到的异常为~~~"+exception);
	}
	
	/**
	 * 环绕通知 : 功能最强大的通知  但并非常用通知~~~   类似于反射代理机制 
	 * @param pjp : 此参数为必须 
	 * @return
	 */
	@Around("declareExpression()")
	public Object aroundLogging(ProceedingJoinPoint pjp){
		String methodName = pjp.getSignature().getName();
		Object result = null;

		try {
			System.out.println("环绕通知-前置通知:methodName is "+methodName+" args is "+Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			System.out.println("环绕通知-返回通知:methodName is "+methodName+" result is "+result);
		} catch (Throwable e) {
			System.out.println("环绕通知-异常通知:Exception e is : "+e);
			throw new RuntimeException(e);
		}
		
		System.out.println("环绕通知-后置通知:methodName is "+methodName);
		
		return result;
	}
}
