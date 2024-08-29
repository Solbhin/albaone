package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Apply {
	private String id;
	private String resume_number;
	private int apply_id;
	private String resumetitle;
	private String companyName;
	private String workLocation;
	private int salary;
	private String workHours;
	private String workDays;
	private String jobDescription;
	private String name;
	private String contact;
	private String email;
	private String address;
	private int postNumber;
	private String status;
	private String MyimgName;
	private MultipartFile myimg;		// 증명사진
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResume_number() {
		return resume_number;
	}
	public void setResume_number(String resume_number) {
		this.resume_number = resume_number;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
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
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getResumetitle() {
		return resumetitle;
	}
	public void setResumetitle(String resumetitle) {
		this.resumetitle = resumetitle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMyimgName() {
		return MyimgName;
	}
	public void setMyimgName(String myimgName) {
		MyimgName = myimgName;
	}
	public MultipartFile getMyimg() {
		return myimg;
	}
	public void setMyimg(MultipartFile myimg) {
		this.myimg = myimg;
	}
	
	
}
