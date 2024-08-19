package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Severance;

public interface SeveranceRepository
{
	void create(Severance Severance);
	//알바생용 - 알바생명으로 조회
	List<Severance> findAllBySeverance_alba(String parttimename);
	//기업용 - 기업명으로 조회
	List<Severance> findAllBySeverance_comp(String company);
}
