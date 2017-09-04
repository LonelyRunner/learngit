package com.zh.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void beforeLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("ǰ��֪ͨ"+methodName+"~~~"+args);
	 }
	
	public void afterLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("����֪ͨ"+methodName+"~~~"+args);
	 }
	
	public void resultLogging(JoinPoint joinPoint,Object result){
		System.out.println("����֪ͨ:���Ϊ~~~"+result);
	}
	
	public void exceptionLogging(JoinPoint joinPoint,Exception exception){
		System.out.println("�쳣֪ͨ:�������쳣Ϊ~~~"+exception);
	}
	
	public Object aroundLogging(ProceedingJoinPoint pjp){
		String methodName = pjp.getSignature().getName();
		Object result = null;

		try {
			System.out.println("����֪ͨ-ǰ��֪ͨ:methodName is "+methodName+" args is "+Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			System.out.println("����֪ͨ-����֪ͨ:methodName is "+methodName+" result is "+result);
		} catch (Throwable e) {
			System.out.println("����֪ͨ-�쳣֪ͨ:Exception e is : "+e);
			throw new RuntimeException(e);
		}
		
		System.out.println("����֪ͨ-����֪ͨ:methodName is "+methodName);
		
		return result;
	}
}
