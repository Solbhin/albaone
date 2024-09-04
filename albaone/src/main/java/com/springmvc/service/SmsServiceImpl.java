package com.springmvc.service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.model.MessageType;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
	// 모든 IP 허용 key - git에 업로드할때 키는 빼고 업로드할것
	// 전역 변수
	private final DefaultMessageService messageService;
	private final String key = ""; // api 키
	private final String secretkey = "";

	// 생성자 초기화
	public SmsServiceImpl() {
		this.messageService = NurigoApp.INSTANCE.initialize(key, secretkey, "https://api.coolsms.co.kr");
	}

	@Override
	public void sendVerificationCode(String phoneNumber, String verificationCode) {
		System.out.println("인증 코드 생성");
		Message message = new Message();
		// 발신 번호 - api에서 설정한 유효한 발신 번호를 입력하지 않으면 200 에러 발생 - 서버는 연결되었는데 sms는 발신되지 않음
		message.setFrom("01043285253");
		message.setTo(phoneNumber);
		message.setText("인증 코드는 " + verificationCode + "입니다.");
		message.setType(MessageType.SMS);

		try {
			SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
