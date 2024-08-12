package com.springmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Resume;

@Repository
public interface ResumeRespository {

	void setmyImg(Resume resume);

	List<Resume> getAllresumeList();

	Resume getResumeNumber(String number);

	void setUpdateResume(Resume resume);

	void setDeleteResume(String number);

}
