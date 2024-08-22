package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Employee;

public interface EmployeeService {

	List<Employee> getMyCompany(String id);

	void addEmployee(String id, String businessNumber);

	List<Employee> getAllEmployee(String businessNumber);

}
