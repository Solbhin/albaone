package com.springmvc.service;

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
	public void addEmployee(String id, String businessNumber) {
		employeeRepository.addEmployee(id, businessNumber);
	}

}
