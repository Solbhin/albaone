package com.springmvc.domain;

public class Albarate {
	private String parttimename; // 알바생
	private int commute; // 출퇴근
	private int absent; // 결근
	private int blinking; // QR 얼마나 깜빡했는지
	private int company; // 사장 평가
	private String rating; // 긍정적/부정적 평가

	public Albarate() {
	}

	public String getParttimename() {
		return parttimename;
	}

	public void setParttimename(String parttimename) {
		this.parttimename = parttimename;
	}

	public int getCommute() {
		return commute;
	}

	public void setCommute(int commute) {
		this.commute = commute;
	}

	public int getBlinking() {
		return blinking;
	}

	public void setBlinking(int blinking) {
		this.blinking = blinking;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

}
