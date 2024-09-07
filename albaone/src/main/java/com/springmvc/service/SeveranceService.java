package com.springmvc.service;

import java.time.LocalDate;

import com.springmvc.domain.Severance;

public interface SeveranceService {

	void createSeverance(String id, String businessNumber, LocalDate hireDate, LocalDate formattedDate, long periodAll,
			String total, String average, String severance);

	Severance getSeverance(String id, String businessNumber);

}
