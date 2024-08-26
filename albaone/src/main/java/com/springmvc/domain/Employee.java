package com.springmvc.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
	private String id;
	private String businessNumber;
	private String name;
	private LocalDate hireDate;
	
	Employee(){}

	public Employee(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	
	public Employee(String id, String name, String hireDate){
		this.id = id;
		this.name = name;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(hireDate, formatter);
		this.hireDate = date;
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
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
}
