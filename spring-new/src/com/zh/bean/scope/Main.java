package com.zh.bean.scope;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.bean.autowire.Car;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");
		Car car1 = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		
		System.out.println(car1 == car2);
		
		Car car3 = (Car) ctx.getBean("car1");
		Car car4 = (Car) ctx.getBean("car1");
		
		System.out.println(car3 == car4);
		
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
}
