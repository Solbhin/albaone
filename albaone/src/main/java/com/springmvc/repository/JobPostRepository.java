package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.JobPost;

public interface JobPostRepository {
	void jobPosting(JobPost jobPost, String id);
	List<JobPost> getAllPosts(int page);
	List<JobPost> getMyPosts(int page, String id);
	int getTotalPosts();
	JobPost getPostDetail(int postNumber);
	void deletePost(int postNumber);
	void updatePost(JobPost jobPost);
}
