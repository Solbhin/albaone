package com.springmvc.service;

import javax.servlet.http.HttpServletResponse;

import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;

public interface QRCodeService {

	Attendance getLastAttendance(String id);

	void checkOut(String id, String time);

	void checkIn(String id, String datetime, String businessNumber);
}
