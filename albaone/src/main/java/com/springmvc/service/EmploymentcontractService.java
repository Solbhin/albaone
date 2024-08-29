package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Employmentcontract;

public interface EmploymentcontractService
{
	void create(Employmentcontract Employmentcontract);
	int deleteContractsByPartTimeName(int num);
	Employmentcontract findByNum(int num);
	List<Employmentcontract> findAllByBusinessNumber(String BusinessNumber);
	public List<Employmentcontract> findAllByParttimeid(String parttimeid);
}
