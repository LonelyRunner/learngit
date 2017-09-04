package com.zh.aop.basic;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		return i-j;
	}

	@Override
	public int cheng(int i, int j) {
		return i*j;
	}

	@Override
	public int chu(int i, int j) {
		return j==0 ? 0 : i/j;
	}

}
