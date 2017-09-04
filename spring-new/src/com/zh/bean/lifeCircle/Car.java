package com.zh.bean.lifeCircle;

public class Car {
	
	private String brand;
	
	public Car(){
		System.out.println("Car's Contructor...");
	}
	
	public String getBeand(){
		return brand;
	}
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	public void initMethod(){
		System.out.println("Car's init method...");
	}
	
	public void destroyMethod(){
		System.out.println("Car's destroy method...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
}
