package com.zh.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void beforeLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("前置通知"+methodName+"~~~"+args);
	 }
	
	public void afterLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("后置通知"+methodName+"~~~"+args);
	 }
	
	public void resultLogging(JoinPoint joinPoint,Object result){
		System.out.println("返回通知:结果为~~~"+result);
	}
	
	public void exceptionLogging(JoinPoint joinPoint,Exception exception){
		System.out.println("异常通知:遇到的异常为~~~"+exception);
	}
	
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
