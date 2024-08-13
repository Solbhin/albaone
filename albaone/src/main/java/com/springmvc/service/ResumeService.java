package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Resume;

public interface ResumeService {
	void setmyImg(Resume resume, String id);
	List<Resume> getAllresumeList(String id);
	Resume getResumeNumber(String number);
	void setUpdateResume(Resume resume);
	void setDeleteResume(String number);
	List<Resume> getfindResumesByUserId(String userId);
}
