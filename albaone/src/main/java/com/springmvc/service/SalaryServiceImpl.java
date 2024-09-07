package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Salary;
import com.springmvc.repository.SalaryRepositoryImpl;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryRepositoryImpl salaryRepository;
	
	@Override
	public int getPersonalSalary(String id, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth) {
		return salaryRepository.getPersonalSalary(id, firstDayOfMonth, lastDayOfMonth);
	}

	@Override
	public List<Salary> getBusinessSalary(String businessNumber, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth) {
		return salaryRepository.getBusinessSalary(businessNumber, firstDayOfMonth, lastDayOfMonth);
	}
	
}
