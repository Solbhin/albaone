package com.springmvc.domain;

import java.time.LocalDateTime;

public class QRCode {
	private String id; // 아이디
	private LocalDateTime timestamp; // 날짜와 시간 
	
	public QRCode() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
