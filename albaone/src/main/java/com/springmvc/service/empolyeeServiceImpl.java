package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Empolyee;
import com.springmvc.repository.empolyeeRepositoryImpl;

@Service
public class empolyeeServiceImpl implements empolyeeService {
	@Autowired
	private empolyeeRepositoryImpl empolyeeRepository;
	
	@Override
	public List<Empolyee> getAllEmpolyee(String businessNumber) {
		return empolyeeRepository.getAllEmpolyee(businessNumber);
	}

	@Override
	public List<Empolyee> getMyCompany(String id) {
		return empolyeeRepository.getMyCompany(id);
	}

}
