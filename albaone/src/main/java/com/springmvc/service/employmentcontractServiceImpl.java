package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.employmentcontract;
import com.springmvc.repository.employmentcontractRepositoryImpl;


@Service
public class employmentcontractServiceImpl implements employmentcontractService
{
	@Autowired
	private employmentcontractRepositoryImpl employmentcontractRepository;
	
	@Override
	public void create(employmentcontract employmentcontract)
	{
		employmentcontractRepository.create(employmentcontract);
		
	}

	@Override
	public void update(employmentcontract employmentcontract)
	{
		employmentcontractRepository.update(employmentcontract);
	}

}
