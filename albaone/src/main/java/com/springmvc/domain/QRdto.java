package com.springmvc.domain;

public class QRdto
{
	private String QRurl;
	private String id;
	private String todaytime;
	
	public QRdto() {}

	public String getQRurl() {
		return QRurl;
	}

	public void setQRurl(String qRurl) {
		QRurl = qRurl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToday() {
		return todaytime;
	}

	public void setToday(String todaytime) {
		this.todaytime = todaytime;
	}
	
	
}
