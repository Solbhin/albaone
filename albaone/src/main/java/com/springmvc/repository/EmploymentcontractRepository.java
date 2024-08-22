package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Employmentcontract;

public interface EmploymentcontractRepository
{
	void create(Employmentcontract Employmentcontract);
	int deleteContractsByPartTimeName(int num);
	Employmentcontract findByNum(int num);
	List<Employmentcontract> findAllByBusinessNumber(String BusinessNumber);
}
