package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Apply;
import com.springmvc.repository.ApplyRespositoryImpl;

@Service
public class ApplyServiceImpl implements ApplyService{
	
	@Autowired
	private ApplyRespositoryImpl applyRepository;

	@Override
	public void applyForJob(String id,String resume_number, String resumeTitle, int postNumber, String companyName, String workLocation, int salary, String workHours,String workDays, String jobDescription,String name, String contact, String email, String address) {
		applyRepository.insertApplication(id,resume_number, resumeTitle,  postNumber,  companyName,  workLocation,  salary,  workHours, workDays,  jobDescription, name,  contact,  email,  address);
	}

	@Override
	public List<Apply> getApplicaionts(String userId) {
		return applyRepository.getApplicaionts(userId);
	}

	@Override
	public List<Apply> getAllapplys(String id) {
		return applyRepository.getAllapplys(id);
	}

	@Override
	public List<Apply> getAllbusinesapplys(int postNumber) {
		return applyRepository.getAllbusinesapplys(postNumber);
	}

	@Override
	public void setDeleteApply(String apply_id) {
		applyRepository.setDeleteApply(apply_id);
		
	}

	@Override
	public List<Apply> getbusinesview(int postNumber, int apply_id) {
		return applyRepository.getbusinesview(postNumber,apply_id);
	}

	@Override
	public void updateApplyStatus(int apply_id, String status, int postNumber) {
		applyRepository.updateApplyStatus(apply_id, status, postNumber);
	}

	@Override
	public String getEmpolyeeId(int apply_id) {
		return applyRepository.getEmpolyeeId(apply_id);
	}
	
}
