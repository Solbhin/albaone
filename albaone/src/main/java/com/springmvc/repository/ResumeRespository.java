package com.springmvc.repository;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Resume;

@Repository
public interface ResumeRespository {
	void setmyImg(Resume resume);
}
