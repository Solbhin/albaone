package com.springmvc.service;

import javax.servlet.http.HttpServletResponse;

import com.springmvc.domain.Attendance;

public interface QRCodeService {

	Attendance getLastAttendance(String id);

	void checkIn(String id, String datetime, String businessNumber);

	void checkOut(String id, String time, long flooredMinutes);
}
