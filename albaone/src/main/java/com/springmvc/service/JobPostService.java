package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.JobPost;

public interface JobPostService {
	void jobPosting(JobPost jobPost, String id);
	List<JobPost> getAllPosts(int page);
	List<JobPost> getMyPosts(int page, String id);
	int getTotalPosts();
	JobPost getPostDetail(int postNumber);
	void deletePost(int postNumber);
	void updatePost(JobPost jobPost);
}
