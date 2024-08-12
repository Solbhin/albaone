package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Severance;

public interface SeveranceService
{
	void create(Severance Severance);
	List<Severance> findAllBySeverance_alba(String parttimename);
	List<Severance> findAllBySeverance_comp(String company);
}
