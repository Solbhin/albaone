package com.springmvc.domain;

public class JobPost {
	private int postNumber;			// 게시글 번호
	private String companyName;		// 상호명
	private String workLocation;	// 근무지 주소
	private String contactNumber;	// 연락처
	private int salary;				// 임금
	private String workHours;		// 근무시간
	private String workDays;		// 근무요일
	private String workDuration;	// 근무기간
	private String jobDescription;	// 하는 일
	private String id;				// 작성자 id
	
	public JobPost(){}
	
	public JobPost(int postNumber, String companyName, String workLocation, int salary, String workHours, String workDays){
		this.postNumber = postNumber;
		this.companyName = companyName;
		this.workLocation = workLocation;
		this.salary = salary;
		this.workHours = workHours;
		this.workDays = workDays;
	}
	
	public JobPost(int postNumber, String companyName, String workLocation, int salary, String workHours, String workDays, String contactNumber, String workDuration, String jobDescription, String id){
		this.postNumber = postNumber;
		this.companyName = companyName;
		this.workLocation = workLocation;
		this.salary = salary;
		this.workHours = workHours;
		this.workDays = workDays;
		this.contactNumber = contactNumber;
		this.workDuration = workDuration;
		this.jobDescription = jobDescription;
		this.id = id;
	}
	
	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getWorkHours() {
		return workHours;
	}
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}
	public String getWorkDays() {
		return workDays;
	}
	public void setWorkDays(String workDays) {
		this.workDays = workDays;
	}
	public String getWorkDuration() {
		return workDuration;
	}
	public void setWorkDuration(String workDuration) {
		this.workDuration = workDuration;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
