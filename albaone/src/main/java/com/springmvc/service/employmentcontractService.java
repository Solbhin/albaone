package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.employmentcontract;

public interface employmentcontractService
{
	void create(employmentcontract employmentcontract);
	void update(employmentcontract employmentcontract);
	public List<employmentcontract> findAllByPartTimeName(String parttimename);
	public int deleteContractsByPartTimeName(String parttimename);
}
