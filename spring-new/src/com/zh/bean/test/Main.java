package com.zh.bean.test;

/**
 * Ҫ�ʴ����90����ഺ���������ʲô��
 * ���룬������˻�˵��һ���𰸣��Ȼ�
 * �ǰ�����֧��ӳ���������̫��̫��Ļ���
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
		
		//Spring IOC����
		/**
		 * ApplicationContext ����IOC����
		 * ClassPathXmlApplicationContext:��ApplicationContext��ʵ����
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��Bean������ֻ��һ�������ʱ
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
		
		//��֤P��ǩ
		People p = (People)applicationContext.getBean("peoplex");
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(p);
	}
	
}
