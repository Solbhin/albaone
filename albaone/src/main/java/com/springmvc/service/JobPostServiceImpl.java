package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.JobPost;
import com.springmvc.repository.JobPostRepositoryImpl;

@Service
public class JobPostServiceImpl implements JobPostService {
	@Autowired
	private JobPostRepositoryImpl jobPostRepository;
	
	@Override
	public void jobPosting(JobPost jobPost) {
		jobPostRepository.jobPosting(jobPost);
	}

	@Override
	public List<JobPost> getAllPosts() {
		return jobPostRepository.getAllPosts();
	}



}
