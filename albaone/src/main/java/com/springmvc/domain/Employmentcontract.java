
package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Employmentcontract
{
	private int num; //조회 번호
	private String ownername; // 사업주명
	private String businessNumber; // 사업자 번호
	private String parttimename; // 알바생명
	private String period_start; // 근무 시작 날짜
	private String period_end; // 근무 종료 날짜
	private String place; // 근무 장소
	private String workdetail; // 업무 내용
	private String workinghours_start;// 근무 시작 시간
	private String workinghours_end; // 근무 종료 시간
	private String workday; // 주당 근무일
	private long money;// 임금 - 시급, 일급, 월급을 정하거나 미리 데이터베이스를 여러개 만들고 따로 저장하는 것으로 함
	private long bonus; // 상여금
	private String insurance; // 보험
	private MultipartFile sinefile; //사인 또는 도장 이미지 파일
	private String sinefilename; //사인 또는 도장 파일명
	private String createdate; // 작성 날짜

	// 기본생성자
	public Employmentcontract() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getParttimename() {
		return parttimename;
	}

	public void setParttimename(String parttimename) {
		this.parttimename = parttimename;
	}

	public String getPeriod_start() {
		return period_start;
	}

	public void setPeriod_start(String period_start) {
		this.period_start = period_start;
	}

	public String getPeriod_end() {
		return period_end;
	}

	public void setPeriod_end(String period_end) {
		this.period_end = period_end;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getWorkdetail() {
		return workdetail;
	}

	public void setWorkdetail(String workdetail) {
		this.workdetail = workdetail;
	}

	public String getWorkinghours_start() {
		return workinghours_start;
	}

	public void setWorkinghours_start(String workinghours_start) {
		this.workinghours_start = workinghours_start;
	}

	public String getWorkinghours_end() {
		return workinghours_end;
	}

	public void setWorkinghours_end(String workinghours_end) {
		this.workinghours_end = workinghours_end;
	}

	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getBonus() {
		return bonus;
	}

	public void setBonus(long bonus) {
		this.bonus = bonus;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public MultipartFile getSinefile() {
		return sinefile;
	}

	public void setSinefile(MultipartFile sinefile) {
		this.sinefile = sinefile;
	}

	public String getSinefilename() {
		return sinefilename;
	}

	public void setSinefilename(String sinefilename) {
		this.sinefilename = sinefilename;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
}
