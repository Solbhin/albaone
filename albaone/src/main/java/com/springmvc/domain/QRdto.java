package com.springmvc.domain;

public class QRdto
{
	private String id; //아이디
	private String today; //날짜
	private String intime; //출근시간
	private String quittime; //퇴근시간
	
	public QRdto() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getQuittime() {
		return quittime;
	}

	public void setQuittime(String quittime) {
		this.quittime = quittime;
	}

	
}
