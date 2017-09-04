package com.zh.bean.test;

/**
 * 要问大多数90后的青春篮球回忆是什么？
 * 我想，大多数人会说出一个答案：热火，
 * 是啊，这支球队承载了我们太多太多的回忆
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zh.bean.beans.Car;
import com.zh.bean.beans.HelloWorld;
import com.zh.bean.beans.People;
import com.zh.bean.beans.PeopleMap;
import com.zh.bean.beans.PeopleProperty;
import com.zh.bean.beans.Person;

public class Main {
	
	public static void main(String[] args) {
		
		//Spring IOC容器
		/**
		 * ApplicationContext 代表IOC容器
		 * ClassPathXmlApplicationContext:是ApplicationContext的实现类
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//当Bean配置中只有一个类对象时
		//HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		helloWorld.sayHello();
		
		Car car = (Car) applicationContext.getBean("car1");
		System.out.println(car.toString());
		
		car = (Car)applicationContext.getBean("car2");
		System.out.println(car);
		
		Person person = (Person)applicationContext.getBean("person");
		System.out.println(person);
		
		People people = (People)applicationContext.getBean("people");
		System.out.println(people);
		
		People people2 = (People)applicationContext.getBean("people2");
		System.out.println(people2);
		
		PeopleMap peopleMap = (PeopleMap)applicationContext.getBean("peopleMap");
		System.out.println(peopleMap);
		
		PeopleProperty peopleProperties = (PeopleProperty)applicationContext.getBean("dataSource");
		System.out.println(peopleProperties);
		
		//验证P标签
		People p = (People)applicationContext.getBean("peoplex");
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(p);
	}
	
}
