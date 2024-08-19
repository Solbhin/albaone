package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Severance;
import com.springmvc.repository.SeveranceRepositoryImpl;

@Service
public class SeveranceServiceImpl implements SeveranceService
{
	@Autowired
	private SeveranceRepositoryImpl SeveranceRepositoryImpl;

	@Override
	public void create(Severance Severance)
	{
		SeveranceRepositoryImpl.create(Severance);
	}

	@Override
	public List<Severance> findAllBySeverance_alba(String parttimename)
	{
		return SeveranceRepositoryImpl.findAllBySeverance_alba(parttimename);
	}

	@Override
	public List<Severance> findAllBySeverance_comp(String company)
	{
		// TODO Auto-generated method stub
		return SeveranceRepositoryImpl.findAllBySeverance_comp(company);
	}
}
