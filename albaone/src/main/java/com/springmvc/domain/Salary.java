package com.springmvc.domain;

import java.text.NumberFormat;

public class Salary {
	private String id;
	private String name;
	private String workHours;
	private String workMinutes;
	private String salary;
	private String benefit;
	private String totalSalary;


	public Salary(String id, String name, int totalWorkMinutes) {
		NumberFormat numberFormat = NumberFormat.getInstance();
		int workHours = totalWorkMinutes / 60;
		int workMinutes = totalWorkMinutes % 60;
		int salary = (int) ((float) totalWorkMinutes / 60 * 9860);
		int benefit = (int) ((float) totalWorkMinutes / 60 / 40 * 8 * 9860);
		int totalSalary = salary + benefit;

		this.id = id;
		this.name = name;
		this.workHours = numberFormat.format(workHours);
		this.workMinutes = numberFormat.format(workMinutes);
		this.salary = numberFormat.format(salary);
		this.benefit = numberFormat.format(benefit);
		this.totalSalary = numberFormat.format(totalSalary);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getWorkMinutes() {
		return workMinutes;
	}

	public void setWorkMinutes(String workMinutes) {
		this.workMinutes = workMinutes;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}

}
