package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Employmentcontract;

public interface EmploymentcontractRepository
{
	void create(Employmentcontract Employmentcontract);
	List<Employmentcontract> findAllByPartTimeName(String parttimename);
	int deleteContractsByPartTimeName(int num);
	Employmentcontract findByNum(int num);
}
