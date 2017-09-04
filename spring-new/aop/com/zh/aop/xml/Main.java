package com.zh.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		CalculatorInterFace calculatorInterFace = (CalculatorInterFace) ac.getBean("calculatorImpl");
		
		System.out.println(calculatorInterFace.getClass());
		
		int result = calculatorInterFace.add(3, 6);
		
		System.out.println("result : "+result);
		
		result = calculatorInterFace.chu(8,2);
		System.out.println("result : "+result);
	}
}
