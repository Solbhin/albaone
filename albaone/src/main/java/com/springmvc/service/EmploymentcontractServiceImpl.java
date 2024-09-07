package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Employmentcontract;
import com.springmvc.repository.EmploymentcontractRepositoryImpl;


@Service
public class EmploymentcontractServiceImpl implements EmploymentcontractService
{
	@Autowired
	private EmploymentcontractRepositoryImpl employmentcontractRepository;
	
	@Override
	public void create(Employmentcontract employmentcontract)
	{
		employmentcontractRepository.create(employmentcontract);
		
	}

	@Override
	public List<Employmentcontract> findAllByBusinessNumber(String BusinessNumber)
	{
		return employmentcontractRepository.findAllByBusinessNumber(BusinessNumber);
	}

	@Override
	public int deleteContractsByPartTimeName(int num)
	{
		return employmentcontractRepository.deleteContractsByPartTimeName(num);
	}

	@Override
	public Employmentcontract findByNum(int num)
	{
		return employmentcontractRepository.findByNum(num);
	}

	@Override
	public List<Employmentcontract> findAllByParttimeid(String parttimeid)
	{
		return employmentcontractRepository.findAllByParttimeid(parttimeid);
	}

}
