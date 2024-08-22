package com.springmvc.domain;

public class Employee {
	private String id;
	private String businessNumber;
	private String name;
	
	Employee(){}

	public Employee(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	
	public Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
