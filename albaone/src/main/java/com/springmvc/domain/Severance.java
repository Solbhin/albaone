package com.springmvc.domain;

public class Severance {
	private String name;
	private String total3MonthSalary;
	private String averageWage;
	private String severance;

	public Severance(String string, String string2, String string3, String string4) {
		this.name = string;
		this.total3MonthSalary = string2;
		this.averageWage = string3;
		this.severance = string4;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotal3MonthSalary() {
		return total3MonthSalary;
	}

	public void setTotal3MonthSalary(String total3MonthSalary) {
		this.total3MonthSalary = total3MonthSalary;
	}

	public String getAverageWage() {
		return averageWage;
	}

	public void setAverageWage(String averageWage) {
		this.averageWage = averageWage;
	}

	public String getSeverance() {
		return severance;
	}

	public void setSeverance(String severance) {
		this.severance = severance;
	}

}
