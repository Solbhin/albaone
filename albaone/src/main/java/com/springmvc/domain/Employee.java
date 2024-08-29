package com.springmvc.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee {
	private String id;
	private String businessNumber;
	private String name;
	private LocalDate hireDate;
	private LocalDate resignationDate;
	private long employmentPeriod;
	
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
	
	public Employee(String id, String name, String hireDate, String resignationDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formattedHire = LocalDate.parse(hireDate, formatter);
		LocalDate formattedResign = LocalDate.parse(resignationDate, formatter);
		this.id = id;
		this.name = name;
		this.hireDate = formattedHire;
		this.resignationDate = formattedResign;
		this.employmentPeriod = ChronoUnit.DAYS.between(formattedHire, formattedResign);
	}
	
	public Employee(String id, String name, String hireDate, String resignationDate, String businessNumber){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formattedHire = LocalDate.parse(hireDate, formatter);
		LocalDate formattedResign = LocalDate.parse(resignationDate, formatter);
		this.id = id;
		this.name = name;
		this.hireDate = formattedHire;
		this.resignationDate = formattedResign;
		this.employmentPeriod = ChronoUnit.DAYS.between(formattedHire, formattedResign);
		this.businessNumber = businessNumber;
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

	public LocalDate getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(LocalDate resignationDate) {
		this.resignationDate = resignationDate;
	}

	public long getEmploymentPeriod() {
		return employmentPeriod;
	}

	public void setEmploymentPeriod(long employmentPeriod) {
		this.employmentPeriod = employmentPeriod;
	}
	
}
