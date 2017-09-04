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
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = arithmeticCalculator.getClass().getClassLoader();
		//代理对象的类型 即其中有哪些方法
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//当调用代理对象其中的方法时  执行的相关操作
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy：正在返回的那个代理对象
			 * method: 正在调用的对象方法
			 * args: method中的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("method start with :"+methodName+" 参数为:"+Arrays.asList(args));
				Object result = method.invoke(arithmeticCalculator, args);
				System.out.println("method end with :"+methodName+" 参数为:"+Arrays.asList(args));
				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}

}
