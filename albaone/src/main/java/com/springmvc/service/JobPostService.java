package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.JobPost;

public interface JobPostService {
	void jobPosting(JobPost jobPost);
	List<JobPost> getAllPosts();
}
