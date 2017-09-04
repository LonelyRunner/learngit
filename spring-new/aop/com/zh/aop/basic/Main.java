package com.zh.aop.basic;

public class Main {
	
	public static void main(String[] args) {
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorImplLoggingProxy(target).getArithmeticLogging();
		
		int result = proxy.add(1, 3);
		System.out.println(result);
		
		result = proxy.sub(5,7);
		System.out.println(result);
	}
}
