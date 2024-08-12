package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Resume;

public interface ResumeService {
	void setmyImg(Resume resume);
	List<Resume> getAllresumeList();
	Resume getResumeNumber(String number);
	void setUpdateResume(Resume resume);
	void setDeleteResume(String number);
}
