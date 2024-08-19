package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Employmentcontract;

public interface EmploymentcontractService
{
	void create(Employmentcontract Employmentcontract);
	List<Employmentcontract> findAllByPartTimeName(String parttimename);
	int deleteContractsByPartTimeName(int num);
	Employmentcontract findByNum(int num);
}
