package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Employmentcontract;

public interface EmploymentcontractService
{
	void create(Employmentcontract employmentcontract);
	List<Employmentcontract> findAllByPartTimeName(String parttimename);
	List<Employmentcontract> findAllByPartTimeNameownername(String ownername);
	int deleteContractsByPartTimeName(int num);
}
