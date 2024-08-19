package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Empolyee;

public interface empolyeeService {

	List<Empolyee> getAllEmpolyee(String businessNumber);

	List<Empolyee> getMyCompany(String id);

}
