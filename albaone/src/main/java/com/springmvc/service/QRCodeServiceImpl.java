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
import com.springmvc.domain.QRCode;
import com.springmvc.repository.QRcodeRepositoryImpl;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	@Autowired
	private QRcodeRepositoryImpl QRCodeRepository;

//	@Override
//	public void generateQRCode(String text, HttpServletResponse response) throws WriterException, IOException {
//		QRCodeWriter qrCodeWriter = new QRCodeWriter();
//		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
//		// QR 이미지 형식
//		response.setContentType("image/png");
//		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
//	}

//	@Override
//	public void create(QRCode qrdto) {
//		QRCodeRepository.create(qrdto);
//	}

//	@Override
//	public QRCode read(String id) {
//		return QRCodeRepository.read(id); // 리포지토리에서 ID로 QR 정보를 조회
//	}

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
