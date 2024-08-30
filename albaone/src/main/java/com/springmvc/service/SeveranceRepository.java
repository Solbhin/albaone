package com.springmvc.service;

import java.time.LocalDate;

public interface SeveranceRepository {

	void createSeverance(String id, String businessNumber, LocalDate hireDate, LocalDate formattedDate, long periodAll,
			String total, String average, String severance);

}
