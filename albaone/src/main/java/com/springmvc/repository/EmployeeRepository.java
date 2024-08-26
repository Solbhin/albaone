package com.springmvc.repository;

import java.time.LocalDate;
import java.util.List;

import com.springmvc.domain.Employee;

public interface EmployeeRepository {

	List<Employee> getMyCompany(String id);

	List<Employee> getAllEmployee(String businessNumber);

	void addEmployee(String employeeId, String businessNumber, LocalDate date);

	void resignationEmployee(String id, String businessNumber, LocalDate formattedDate);

}
