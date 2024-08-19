package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.employmentcontract;

public interface employmentcontractRepository
{
	void create(employmentcontract employmentcontract);
	List<employmentcontract> findAllByPartTimeName(String parttimename);
	List<employmentcontract> findAllByPartTimeNameownername(String ownername);
	int deleteContractsByPartTimeName(int num);
}
