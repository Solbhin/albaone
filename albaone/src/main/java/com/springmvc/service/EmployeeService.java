package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import com.springmvc.domain.Employee;

public interface EmployeeService {

	List<Employee> getMyCompany(String id);

	List<Employee> getAllEmployee(String businessNumber);

	void addEmployee(String businessNumber, String employeeId, LocalDate date);

	void resignationEmployee(String id, String businessNumber, LocalDate formattedDate);

	List<Employee> getAllResignee(String businessNumber);

	Employee getOneResignee(String id, String businessNumber);

	List<Employee> getResignationHistory(String id);

}
