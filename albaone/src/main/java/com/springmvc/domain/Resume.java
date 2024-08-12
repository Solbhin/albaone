package com.springmvc.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Resume {
	private Integer number; 		//이력서 글 번호
    private String name;   			// 성명
    private Date birthdate;			// 생년월일
    private MultipartFile myimg;		// 증명사진
    private String gender;          // 성별
    private String contact;          // 연락처
    private String email;            // 이메일
    private String address;          // 현 주소
    private String school;            // 학교명
    private String period;             // 기간
    private String major;             // 전공
    private String job_title;           // 직장명
    private String experience_period; // 경력 기간
    private String main_work;           // 주요 업무
    private String reason;              // 지원 동기
    private String work_hours;          // 근무 시간
    private String desired_salary;      // 희망 시급
    private String desired_days;        // 희망 휴일
    private String MyimgName; 			//이미지 이름
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getExperience_period() {
		return experience_period;
	}
	public void setExperience_period(String experience_period) {
		this.experience_period = experience_period;
	}
	public String getMain_work() {
		return main_work;
	}
	public void setMain_work(String main_work) {
		this.main_work = main_work;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getWork_hours() {
		return work_hours;
	}
	public void setWork_hours(String work_hours) {
		this.work_hours = work_hours;
	}
	public String getDesired_salary() {
		return desired_salary;
	}
	public void setDesired_salary(String desired_salary) {
		this.desired_salary = desired_salary;
	}
	public String getDesired_days() {
		return desired_days;
	}
	public void setDesired_days(String desired_days) {
		this.desired_days = desired_days;
	}
	public MultipartFile getMyimg() {
		return myimg;
	}
	public void setMyimg(MultipartFile myimg) {
		this.myimg = myimg;
	}
	public String getMyimgName() {
		return MyimgName;
	}
	public void setMyimgName(String myimgName) {
		this.MyimgName = myimgName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
    
}
