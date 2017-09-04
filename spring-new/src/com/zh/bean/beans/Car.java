package com.zh.bean.beans;

public class Car {
	
	private String carName;
	private String maker;
	private double price;
	private int maxSpeed;
	
	public Car(String carName,String maker,double price){
		this.carName = carName;
		this.maker = maker;
		this.price = price;
	}
	
	public Car(String carName,String maker,int maxSpeed){
		this.carName = carName;
		this.maker = maker;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", maker=" + maker + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
