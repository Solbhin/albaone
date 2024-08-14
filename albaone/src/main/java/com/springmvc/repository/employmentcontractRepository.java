package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.employmentcontract;

public interface employmentcontractRepository
{
	void create(employmentcontract employmentcontract);
	void update(employmentcontract employmentcontract);
	List<employmentcontract> findAllByPartTimeName(String parttimename);
	int deleteContractsByPartTimeName(String parttimename);
}
