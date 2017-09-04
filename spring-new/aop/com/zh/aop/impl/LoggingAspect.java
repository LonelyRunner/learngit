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

//������
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	//��@Point�����������
	@Pointcut(value="execution(* com.zh.aop.impl.*.*(..))")
	public void declareExpression(){}
	

	/**
	 * ǰ��֪ͨ
	 * @param joinPoint
	 */
	@Before("declareExpression()")
	public void beforeLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("ǰ��֪ͨ"+methodName+"~~~"+args);
	 }
	
	/**
	 * ����֪ͨ  ���ʲ�������ֵ
	 * �ڷ���ִ��֮��ִ�еĴ��� --���ܸ÷����Ƿ�����쳣
	 * @param joinPoint
	 */
	@After("declareExpression()")
	public void afterLogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("����֪ͨ"+methodName+"~~~"+args);
	 }
	
	/**
	 * ����֪ͨ ���Է��ʵ����صĽ��
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value="declareExpression()",returning="result")
	public void resultLogging(JoinPoint joinPoint,Object result){
		System.out.println("����֪ͨ:���Ϊ~~~"+result);
	}
	
	/**
	 * �쳣֪ͨ  ����ִ�еķ��������쳣ʱ �ɲ�����쳣��Ϣ  �������쳣�׳�;
	 * @param joinPoint
	 * @param exception : �˴�����ָ���쳣���� ��NullPointException�������ʱ  ֻ�����ָ���쳣
	 */
	@AfterThrowing(value="declareExpression()",throwing="exception")
	public void exceptionLogging(JoinPoint joinPoint,Exception exception){
		System.out.println("�쳣֪ͨ:�������쳣Ϊ~~~"+exception);
	}
	
	/**
	 * ����֪ͨ : ������ǿ���֪ͨ  �����ǳ���֪ͨ~~~   �����ڷ��������� 
	 * @param pjp : �˲���Ϊ���� 
	 * @return
	 */
	@Around("declareExpression()")
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
