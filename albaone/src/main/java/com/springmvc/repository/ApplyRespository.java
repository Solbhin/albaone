package com.springmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Apply;

@Repository
public interface ApplyRespository {

	void insertApplication(String id,String resume_number, String resumeTitle, int postNumber, 
            String companyName, String workLocation, int salary, 
            String workHours, String workDays, String jobDescription, 
            String name, String contact, String email, String address);

	List<Apply> getApplicaionts(String userId);

	List<Apply> getAllapplys(String id);

	List<Apply> getAllbusinesapplys(int postNumber);

	void setDeleteApply(String apply_id);

	List<Apply> getbusinesview(int postNumber, int apply_id);

	void updateApplyStatus(int apply_id,String status,int postNumber);
}