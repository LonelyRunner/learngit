package com.zh.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.bean.annotation.controller.UserController;
import com.zh.bean.annotation.repository.UserRepository;
import com.zh.bean.annotation.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		
		TestObject to = (TestObject) ctx.getBean("testObject");
		
		UserController uc = (UserController) ctx.getBean("userController");
		
		UserService us = (UserService) ctx.getBean("userService");
		
		UserRepository ur = (UserRepository) ctx.getBean("userRepositoryImpl");
		
		System.out.println(to);
		System.out.println(uc);
		System.out.println(us);
		System.out.println(ur);
		
		uc.uc();
	}
}
