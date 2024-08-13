package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Empolyee;

public interface empolyeeRepository {

	List<Empolyee> getAllEmpolyee(String businessNumber);

}
