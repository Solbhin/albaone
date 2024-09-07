package com.springmvc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	@Override
	public void editAttendance(Attendance attendance, LocalDateTime checkInTime) {
		attendanceRepository.editAttendance(attendance, checkInTime);
	}

	@Override
	public int get3MonthWorkMinutes(String id, String businessNumber, LocalDate dateAll1, LocalDate dateAll2) {
		return attendanceRepository.get3MonthWorkMinutes(id, businessNumber, dateAll1, dateAll2);
	}
	
}
