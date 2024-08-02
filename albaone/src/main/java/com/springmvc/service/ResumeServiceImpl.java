package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Resume;
import com.springmvc.repository.ResumeRespository;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeRespository resumeRespository;

	@Override
	public void setmyImg(Resume resume) {
		resumeRespository.setmyImg(resume);
		
	}

}
