package com.zh.bean.beanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.bean.factory.Car;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-beanFactory.xml");
		Car car = (Car)applicationContext.getBean("car");
		System.out.println(car);
	}
}
