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
	public void jobPosting(JobPost jobPost, String id) {
		jobPostRepository.jobPosting(jobPost, id);
	}

	@Override
	public List<JobPost> getAllPosts(int page) {
		return jobPostRepository.getAllPosts(page);
	}

	@Override
	public int getTotalPosts() {
		return jobPostRepository.getTotalPosts();
	}

	@Override
	public JobPost getPostDetail(int postNumber) {
		return jobPostRepository.getPostDetail(postNumber);
	}

	@Override
	public void deletePost(int postNumber) {
		jobPostRepository.deletePost(postNumber);
	}

	@Override
	public void updatePost(JobPost jobPost) {
		jobPostRepository.updatePost(jobPost);
	}

	@Override
	public List<JobPost> getMyPosts(int page, String id) {
		return jobPostRepository.getMyPosts(page, id);
	}

}
