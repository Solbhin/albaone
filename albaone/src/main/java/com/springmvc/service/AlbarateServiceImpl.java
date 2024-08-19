package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Albarate;
import com.springmvc.repository.AlbarateRepositoryImpl;

@Service
public class AlbarateServiceImpl implements AlbarateService
{
	@Autowired
	private AlbarateRepositoryImpl AlbarateRepositoryImpl;

	@Override
	public void insert(String id)
	{
		AlbarateRepositoryImpl.insert(id);
	}

	@Override
	public void update(Albarate albarate)
	{
		AlbarateRepositoryImpl.update(albarate);
	}

	@Override
	public Albarate read(String id)
	{
		AlbarateRepositoryImpl.read(id);
		return AlbarateRepositoryImpl.read(id);
	}
}
