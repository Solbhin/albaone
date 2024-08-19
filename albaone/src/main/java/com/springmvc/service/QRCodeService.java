package com.springmvc.service;

import com.springmvc.domain.Attendance;

public interface QRCodeService {

	Attendance getLastAttendance(String id);

	void checkOut(String id, String time);

	void checkIn(String id, String datetime);
}
