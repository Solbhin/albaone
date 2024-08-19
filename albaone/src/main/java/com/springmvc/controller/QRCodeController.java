package com.springmvc.controller;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.springmvc.domain.Attendance;
import com.springmvc.domain.QRCode;
import com.springmvc.service.QRCodeServiceImpl;

@Controller
public class QRCodeController {
	@Autowired
	private QRCodeServiceImpl QRCodeService;

	// QR만들고 보여주기
	@GetMapping("/QR")
	public String QRcreate(HttpServletResponse response, Model model, HttpSession session) {
		// 세션과 현재 시간 - 파라미터 확보
		String id = (String) session.getAttribute("id"); // 아이디
		LocalDateTime timeStamp = LocalDateTime.now();
		
		// 가져온 시간 객체를 포맷팅하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String stringTimeStamp = timeStamp.format(formatter);

		// 인코딩
		try {
			String encodedId = URLEncoder.encode(id, "UTF-8");
			String encodedDateTime = URLEncoder.encode(stringTimeStamp, "UTF-8");

			// URL 생성
			String qrUrl = String.format("http://localhost:8080/albaone/QRcheck?id=%s&datetime=%s", encodedId,
					encodedDateTime);

			// QR 코드를 Base64 형식으로 생성
			String base64QRCode = generateQRCodeAsBase64(qrUrl);
			model.addAttribute("qrCodeUrl", "data:image/png;base64," + base64QRCode);
			// 사진 찍을 수 있으면 삭제. 임시용
			model.addAttribute("id", encodedId);
			model.addAttribute("datetime", encodedDateTime);

		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
		// QRview로 이동
		return "QRview";
	}

//    QR URL을 찍었을 때 출퇴근 확인 - 일단은 a태그로 확인
	@GetMapping("/QRcheck")
	public String QRcheck(Model model, @RequestParam String id, // 아이디
			@RequestParam String datetime) { 
		Attendance attendance = QRCodeService.getLastAttendance(id);
		if (attendance == null) { // 첫 출근
			QRCodeService.checkIn(id, datetime);
		} else {
			LocalDateTime CheckOutTime = attendance.getCheckOutTime();
			if (CheckOutTime == null) {
				QRCodeService.checkOut(id, datetime);
			} else {
				QRCodeService.checkIn(id, datetime);
			}
		}
		return "redirect:/attendanceCalendar";
	}

	// QR 만드는 메서드
	private String generateQRCodeAsBase64(String text) throws Exception {
		// UTF-8로 인코딩 - 한글 깨짐 방지
		String encodedText = new String(text.getBytes("UTF-8"), "UTF-8");

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(encodedText, BarcodeFormat.QR_CODE, 200, 200);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

		byte[] qrCodeBytes = outputStream.toByteArray();
		return Base64.getEncoder().encodeToString(qrCodeBytes);
	}
}
