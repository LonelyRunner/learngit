package com.zh.bean.autowire;

public class Car {
	
	private String brand;
	private String price;
	
	public Car(){
		System.out.println("Car's Contructor...");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
}
