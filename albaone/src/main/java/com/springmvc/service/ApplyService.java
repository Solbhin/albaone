package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Apply;

public interface ApplyService {

	void applyForJob(String id,String resumenumber, String resumeTitle, int postNumber, String companyName, String workLocation, int salary, String workHours,String workDays, String jobDescription,String name, String contact, String email, String address, String MyimgName);

	List<Apply> getApplicaionts(String userId);

	List<Apply> getAllapplys(String id);

	List<Apply> getAllbusinesapplys(int postNumber);

	void setDeleteApply(String apply_id);

	List<Apply> getbusinesview(int postNumber, int apply_id);
	
	void updateApplyStatus(int apply_id,String status,Integer postNumber);

	String getEmpolyeeId(int apply_id);
}
