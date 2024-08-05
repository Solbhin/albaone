package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.JobPost;

public interface JobPostRepository {
	void jobPosting(JobPost jobPost);
	List<JobPost> getAllPosts();
}
