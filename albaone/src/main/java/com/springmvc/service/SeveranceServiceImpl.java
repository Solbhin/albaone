package com.springmvc.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Severance;

@Service
public class SeveranceServiceImpl implements SeveranceService {
	@Autowired
	private SeveranceRepositoryImpl severanceRepository;
	
	@Override
	public void createSeverance(String id, String businessNumber, LocalDate hireDate, LocalDate formattedDate, long periodAll, String total,
			String average, String severance) {
		severanceRepository.createSeverance(id, businessNumber, hireDate, formattedDate, periodAll, total, average, severance);
	}

	@Override
	public Severance getSeverance(String id, String businessNumber) {
		return severanceRepository.getSeverance(id, businessNumber);
	}

}
