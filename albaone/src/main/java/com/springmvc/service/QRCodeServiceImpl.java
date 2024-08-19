package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Attendance;
import com.springmvc.repository.QRcodeRepositoryImpl;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	@Autowired
	private QRcodeRepositoryImpl QRCodeRepository;

	@Override
	public void checkIn(String id, String datetime) {
		QRCodeRepository.checkIn(id, datetime);
	}

	@Override
	public Attendance getLastAttendance(String id) {
		return QRCodeRepository.getLastAttendance(id);
	}

	public void checkOut(String id, String time) {
		QRCodeRepository.checkOut(id, time);
	}

}
