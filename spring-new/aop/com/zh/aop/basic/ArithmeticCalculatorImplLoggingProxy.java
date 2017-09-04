package com.zh.aop.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorImplLoggingProxy {
	
	private ArithmeticCalculator arithmeticCalculator;
	
	public ArithmeticCalculatorImplLoggingProxy(ArithmeticCalculator arithmeticCalculator){
		this.arithmeticCalculator = arithmeticCalculator;
	}
	
	public ArithmeticCalculator getArithmeticLogging(){
		ArithmeticCalculator proxy = null;
		
		//�����������һ����������������
		ClassLoader loader = arithmeticCalculator.getClass().getClassLoader();
		//������������ ����������Щ����
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//�����ô���������еķ���ʱ  ִ�е���ز���
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy�����ڷ��ص��Ǹ��������
			 * method: ���ڵ��õĶ��󷽷�
			 * args: method�еĲ���
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("method start with :"+methodName+" ����Ϊ:"+Arrays.asList(args));
				Object result = method.invoke(arithmeticCalculator, args);
				System.out.println("method end with :"+methodName+" ����Ϊ:"+Arrays.asList(args));
				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}

}
