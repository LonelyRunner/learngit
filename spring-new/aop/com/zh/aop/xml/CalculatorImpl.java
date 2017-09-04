package com.zh.aop.xml;

public class CalculatorImpl implements CalculatorInterFace{

	@Override
	public int add(int i, int j) {
		
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}

	@Override
	public int cheng(int i, int j) {
		// TODO Auto-generated method stub
		return i*j;
	}

	@Override
	public int chu(int i, int j) {
		// TODO Auto-generated method stub
		return i/j;
	}

}
