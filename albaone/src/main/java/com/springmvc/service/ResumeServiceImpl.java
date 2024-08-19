package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Resume;
import com.springmvc.repository.ResumeRespositoryImpl;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeRespositoryImpl resumeRespository;

	@Override
	public void setmyImg(Resume resume,String id) {
		resumeRespository.setmyImg(resume,id);
		
	}

	@Override
	public List<Resume> getAllresumeList(String id) {
		return resumeRespository.getAllresumeList(id);
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
	
	@Override
	public List<Resume> getfindResumesByUserId(String userId) {
		return resumeRespository.getfindResumesByUserId(userId);
	}

}
