package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendances(String id);

	List<Attendance> getAttendancesByBusinessNumber(String businessNumber);
	
	void deleteAttendance(String id);

	void addAttendance(Attendance attendance);
}
