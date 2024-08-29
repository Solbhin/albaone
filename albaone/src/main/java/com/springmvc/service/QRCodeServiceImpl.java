package com.springmvc.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.springmvc.domain.Attendance;
import com.springmvc.repository.QRcodeRepositoryImpl;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	@Autowired
	private QRcodeRepositoryImpl QRCodeRepository;

	@Override
	public void checkIn(String id, String datetime, String businessNumber) {
		QRCodeRepository.checkIn(id, datetime, businessNumber);
	}

	@Override
	public Attendance getLastAttendance(String id) {
		return QRCodeRepository.getLastAttendance(id);
	}
	
	@Override
	public void checkOut(String id, String time, long flooredMinutes) {
		QRCodeRepository.checkOut(id, time, flooredMinutes);
	}

}
