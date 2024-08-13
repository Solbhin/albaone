package com.springmvc.service;

import javax.servlet.http.HttpServletResponse;

import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;

public interface QRCodeService {

//	public void create(QRCode qrdto);

//	public QRCode read(String id);

//	void generateQRCode(String text, HttpServletResponse response) throws Exception;

	Attendance getLastAttendance(String id);

	void checkOut(String id, String time);

	void checkIn(String id, String datetime);
}
