package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.employmentcontract;

public interface employmentcontractService
{
	void create(employmentcontract employmentcontract);
	List<employmentcontract> findAllByPartTimeName(String parttimename);
	List<employmentcontract> findAllByPartTimeNameownername(String ownername);
	int deleteContractsByPartTimeName(int num);
}
