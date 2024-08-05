package com.springmvc.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.springmvc.domain.QRdto;
import com.springmvc.service.QRCodeService;

@Controller
public class QRCodeController
{    
    @Autowired
    private QRCodeService qrCodeService;

    //QR 생성 폼 제공
    @GetMapping("/QRform")
    public String QRform()
    {
        System.out.println("QR 생성 폼으로 이동");
        return "QRform";
    }

    //QR 생성 -아이디, 시간 생성용
    @PostMapping("/QRcreate")
    public String QRcreate(@ModelAttribute("QRcreate") QRdto qrdto, BindingResult result, Model model)
    {
        System.out.println("QR 생성 메서드");

        qrCodeService.create(qrdto); // QR 코드 생성 및 DB 저장
        return "redirect:home"; // QR read로 이동 - read 완성시 수정
    }
    
    //read메서드 - QR read 폼 제공
    @GetMapping("/QRread")
    public String QRreadform()
    {
		return "QRread";
    }
    
    //폼에서 읽은 알바생 아이디 기본키를 이용하여 데이터베이스url을 이용하여 qr 생성
    //id를 읽으면, 해당 아이디로 QR 데이터베이스의 URL열을 가져와 사용
    @PostMapping("/QRread")
    public String QRread(@ModelAttribute("QRread") QRdto qrdto, BindingResult result, HttpServletResponse response, Model model) {
        System.out.println("QR 조회하기");

        try
        {
            // ID를 사용하여 QR 정보를 조회
            QRdto retrievedQRdto = qrCodeService.read(qrdto.getId());

            if (retrievedQRdto != null)
            {
                // ID와 시간을 사용하여 URL 생성
                String id = retrievedQRdto.getId();
                String time = retrievedQRdto.getToday(); // 데이터베이스에서 가져온 시간

                // URL 생성
                String qrUrl = String.format("http://localhost:8080/albaone/QRread?id=%s&time=%s", id, time);

                // QR 코드를 Base64 형식으로 생성
                String base64QRCode = generateQRCodeAsBase64(qrUrl);
                model.addAttribute("qrCodeUrl", "data:image/png;base64," + base64QRCode);
                return "QRview"; // QRview로 이동
            }
            else
            {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "해당 ID의 QR 정보가 없습니다.");
            }
        }
        catch (Exception e)
        {
            System.out.println("QR 조회 중 오류 발생: " + e.getMessage());
            try
            {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "QR 조회 중 오류가 발생했습니다.");
            }
            catch (Exception Exception)
            {
                Exception.printStackTrace();
            }
        }
        return "home";
    }


    //QR 만드는 메서드
    private String generateQRCodeAsBase64(String text) throws WriterException, IOException
    {
        // UTF-8로 인코딩 - 안하면 url에 한글이 깨짐
        String encodedText = new String(text.getBytes("UTF-8"), "UTF-8");
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(encodedText, BarcodeFormat.QR_CODE, 200, 200);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        
        byte[] qrCodeBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(qrCodeBytes);
    }
}
