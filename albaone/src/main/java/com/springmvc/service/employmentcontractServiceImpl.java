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
	
	// 알바생명으로 계약서 조회
	public List<employmentcontract> findAllByPartTimeName(String parttimename)
	{
		return employmentcontractRepository.findAllByPartTimeName(parttimename);
	}
}
