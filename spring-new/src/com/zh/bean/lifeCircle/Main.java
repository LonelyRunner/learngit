package com.zh.bean.lifeCircle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-lifeCircle.xml");
		
		Car car = (Car) ctx.getBean("car");
		
		System.out.println(car);
		
		ctx.close();
	}
}
