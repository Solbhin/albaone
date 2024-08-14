package com.springmvc.service;

import java.util.List;

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

	@Override
	public List<employmentcontract> findAllByPartTimeName(String parttimename)
	{
		return employmentcontractRepository.findAllByPartTimeName(parttimename);
	}

	@Override
	public int deleteContractsByPartTimeName(String parttimename)
	{
		return employmentcontractRepository.deleteContractsByPartTimeName(parttimename);
	}

}
