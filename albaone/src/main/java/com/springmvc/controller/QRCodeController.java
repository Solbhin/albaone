package com.springmvc.controller;

import com.springmvc.domain.QRdto;
import com.springmvc.service.QRservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Controller
public class QRCodeController
{
    @Autowired
    private QRservice qrservice;

    //폼으로 이동
    @GetMapping("/QRform")
    public String QRform(@ModelAttribute("QR") QRdto QRdto, Model model)
    {
        return "QRform";
    }

    @PostMapping("/QRcreate")
    public String QRcreate(@ModelAttribute("QR") QRdto QRdto, Model model)
    {
        try
        {
            // DB에서 오늘 날짜에 해당하는 기록을 조회
            QRdto existingRecord = qrservice.findByIdAndDate(QRdto.getId(), QRdto.getToday());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String now = LocalDateTime.now().format(formatter);

            if (existingRecord == null)
            {
                // 처음 입력받은 경우 출근 시간으로 저장
                QRdto.setIntime(now);
                qrservice.save(QRdto);
            }
            else
            {
                // 두번째 입력받은 경우 퇴근 시간으로 저장
                existingRecord.setQuittime(now);
                qrservice.update(existingRecord);
                QRdto = existingRecord; // 업데이트된 기록을 사용
            }

            // QR 코드에 포함될 텍스트 구성
            String qrText = "ID: " + QRdto.getId() + "\n" +
                            "Date: " + QRdto.getToday() + "\n" +
                            "In Time: " + (QRdto.getIntime() != null ? QRdto.getIntime() : "N/A") + "\n" +
                            "Quit Time: " + (QRdto.getQuittime() != null ? QRdto.getQuittime() : "N/A");

            // QR 코드 생성
            String qrCodeBase64 = generateQRCodeAsBase64(qrText);
            
            // 모델에 QR 코드 추가
            model.addAttribute("qrCode", qrCodeBase64);
            // QR 코드를 표시할 뷰
            return "QRview"; 
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("error", "QR 코드 생성 중 오류가 발생했습니다.");
            // 오류 페이지
            return "error"; 
        }
    }

    // QR 만드는 메서드
    private String generateQRCodeAsBase64(String text) throws Exception
    {
        // UTF-8로 인코딩 - 안하면 url에 한글이 깨짐
        String encodedText = new String(text.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(encodedText, BarcodeFormat.QR_CODE, 200, 200);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        
        byte[] qrCodeBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(qrCodeBytes);
    }
}
