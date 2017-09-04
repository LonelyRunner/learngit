package com.zh.bean.beanFactory;

import org.springframework.beans.factory.FactoryBean;

import com.zh.bean.factory.Car;

public class CarBeanFactory implements FactoryBean<Car>{

	private String brand;
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	@Override
	public Car getObject() throws Exception {
		Car car = new Car(brand,500000);
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
