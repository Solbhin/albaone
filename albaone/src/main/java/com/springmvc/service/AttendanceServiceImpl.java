package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Attendance;
import com.springmvc.repository.AttendanceRepositoryImpl;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepositoryImpl attendanceRepository;

	@Override
	public List<Attendance> getAllAttendances(String id) {
		return attendanceRepository.getAllAttendances(id);
	}

	@Override
	public List<Attendance> getAttendancesByBusinessNumber(String businessNumber) {
		return attendanceRepository.getAttendancesByBusinessNumber(businessNumber);
	}

	@Override
	public void deleteAttendance(String id) {
		attendanceRepository.deleteAttendance(id);
	}
	
	@Override
	public void addAttendance(Attendance attendance) {
		attendanceRepository.addAttendance(attendance);
	}
	
}
