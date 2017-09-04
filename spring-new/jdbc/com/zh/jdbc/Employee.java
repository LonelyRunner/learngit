package com.zh.jdbc;

public class Employee {
	
	private int employeeId;
	
	private String employeeName;
	
	private double employeeSalary;
	
	private int employeeDeptId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeDeptId() {
		return employeeDeptId;
	}

	public void setEmployeeDeptId(int employeeDeptId) {
		this.employeeDeptId = employeeDeptId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeDeptId=" + employeeDeptId + "]";
	}
	
}
