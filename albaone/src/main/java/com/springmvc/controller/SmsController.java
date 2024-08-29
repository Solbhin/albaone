package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.springmvc.service.SmsServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Controller
public class SmsController
{
    @Autowired
    private SmsServiceImpl smsServiceImpl;

    // 인증 코드를 저장할 HashMap
    private ConcurrentHashMap<String, String> verificationCodes = new ConcurrentHashMap<>();

    @PostMapping(value = "/sendCode", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String sendVerificationCode(@RequestParam("phone") String phoneNumber)
    {
    	System.out.println("/sendCode");
        // 랜덤 인증 코드 생성
        String verificationCode = generateVerificationCode();
        smsServiceImpl.sendVerificationCode(phoneNumber, verificationCode);

        // 인증 코드를 ConcurrentHashMap에 저장, 5분 동안 유효
        verificationCodes.put(phoneNumber, verificationCode);
        System.out.println(phoneNumber);
        System.out.println(verificationCode.getBytes());

        // 일정 시간이 지나면 인증 코드가 자동으로 삭제되도록 스케줄링
        new java.util.Timer().schedule(new java.util.TimerTask()
        {
            @Override
            public void run()
            {
                verificationCodes.remove(phoneNumber);
            }
        },
        TimeUnit.MINUTES.toMillis(5)); // 5분 후 삭제

        return "인증 코드가 전송되었습니다.";
    }

    @PostMapping(value = "/verifyCode", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<Map<String, String>> verifyCode(@RequestParam("phone") String phoneNumber, @RequestParam("code") String code)
    {
        System.out.println("인증 확인 시도 메서드");
        String savedCode = verificationCodes.get(phoneNumber);

        Map<String, String> response = new HashMap<>();
        if (savedCode != null && savedCode.equals(code))
        {
            response.put("status", "success");
            response.put("message", "인증 성공");
        }
        else
        {
            response.put("status", "fail");
            response.put("message", "인증 실패");
        }

        return ResponseEntity.ok(response);
    }


    //랜덤 인증 코드 생성 메서드
    private String generateVerificationCode()
    {
        return String.valueOf((int) ((Math.random() * 899999) + 100000)); // 6자리 랜덤 코드
    }
}


