package com.zh.bean.relations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.bean.autowire.Address;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-relations.xml");
		Address address = (Address)ctx.getBean("address1");
		System.out.println(address);
		
		address=(Address)ctx.getBean("address2");
		System.out.println(address);
	}
}
