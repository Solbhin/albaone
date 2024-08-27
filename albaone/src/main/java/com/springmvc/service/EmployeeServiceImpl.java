package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Employee;
import com.springmvc.repository.EmployeeRepositoryImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepositoryImpl employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee(String businessNumber) {
		return employeeRepository.getAllEmployee(businessNumber);
	}

	@Override
	public List<Employee> getMyCompany(String id) {
		return employeeRepository.getMyCompany(id);
	}

	@Override
	public void addEmployee(String businessNumber, String employeeId, LocalDate date) {
		employeeRepository.addEmployee(employeeId, businessNumber, date);
	}

	@Override
	public void resignationEmployee(String id, String businessNumber, LocalDate formattedDate) {
		employeeRepository.resignationEmployee(id, businessNumber, formattedDate);
	}

	@Override
	public List<Employee> getAllResignee(String businessNumber) {
		return employeeRepository.getAllResignee(businessNumber);
	}

	@Override
	public Employee getOneResignee(String id, String businessNumber) {
		return employeeRepository.getOneResignee(id, businessNumber);
	}

}
