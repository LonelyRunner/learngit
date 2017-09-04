package com.zh.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
		
		CalculatorInterFace calculatorInterFace = ac.getBean(CalculatorInterFace.class);
		
		System.out.println(calculatorInterFace.getClass());
		
		int result = calculatorInterFace.add(3, 6);
		
		System.out.println("result : "+result);
		
		result = calculatorInterFace.chu(8,2);
		System.out.println("result : "+result);
	}
}
