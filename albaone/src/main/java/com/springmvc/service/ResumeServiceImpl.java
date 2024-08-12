package com.springmvc.service;

import java.util.List;

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

	@Override
	public List<Resume> getAllresumeList() {
		return resumeRespository.getAllresumeList();
	}

	@Override
	public Resume getResumeNumber(String number) {
		Resume resumeNumber = resumeRespository.getResumeNumber(number);
		return resumeNumber;
	}

	@Override
	public void setUpdateResume(Resume resume) {
		resumeRespository.setUpdateResume(resume);
	}

	@Override
	public void setDeleteResume(String number) {
		resumeRespository.setDeleteResume(number);
		
	}

}
