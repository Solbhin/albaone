package com.springmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Resume;

@Repository
public interface ResumeRespository {

	void setmyImg(Resume resume,String id);

	List<Resume> getAllresumeList(String id);

	Resume getResumeNumber(String number);

	void setUpdateResume(Resume resume);

	void setDeleteResume(String number);

	List<Resume> getfindResumesByUserId(String userId);

}
