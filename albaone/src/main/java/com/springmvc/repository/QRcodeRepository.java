package com.springmvc.repository;

import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;

public interface QRcodeRepository {
	Attendance getLastAttendance(String id);

	void checkOut(String id, String time);

	void checkIn(String id, String datetime, String businessNumber);
}
