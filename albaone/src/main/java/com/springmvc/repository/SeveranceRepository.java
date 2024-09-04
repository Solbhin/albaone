package com.springmvc.repository;

import java.time.LocalDate;

import com.springmvc.domain.Severance;

public interface SeveranceRepository {

	void createSeverance(String id, String businessNumber, LocalDate hireDate, LocalDate formattedDate, long periodAll,
			String total, String average, String severance);

	Severance getSeverance(String id, String businessNumber);

}
