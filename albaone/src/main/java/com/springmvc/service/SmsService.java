package com.springmvc.service;

public interface SmsService {
	public void sendVerificationCode(String phoneNumber, String verificationCode);
}
