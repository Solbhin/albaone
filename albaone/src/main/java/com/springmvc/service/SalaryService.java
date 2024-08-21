package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import com.springmvc.domain.Salary;

public interface SalaryService {

	int getPersonalSalary(String id, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);

	List<Salary> getBusinessSalary(String businessNumber, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);
	
}
