package com.zh.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-autowire.xml");
		Person person = (Person)ctx.getBean("person1");
		System.out.println(person);
		
		Person autowirePersonByName = (Person)ctx.getBean("autowirePersonByName");
		System.out.println(autowirePersonByName);
		
		Person autowirePersonByType = (Person)ctx.getBean("autowirePersonByType");
		System.out.println(autowirePersonByType);
	}
}
