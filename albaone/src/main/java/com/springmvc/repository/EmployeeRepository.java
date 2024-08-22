package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Employee;

public interface EmployeeRepository {

	List<Employee> getMyCompany(String id);

	List<Employee> getAllEmployee(String businessNumber);

	void addEmployee(String id, String businessNumber);

}
