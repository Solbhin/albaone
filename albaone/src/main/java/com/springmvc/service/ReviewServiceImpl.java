package com.springmvc.service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Review;
import com.springmvc.repository.ReviewRepositoryImpl;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewRepositoryImpl reviewRepository;
	
	@Override
	public List<Review> getAllreviews(String companyName) {
		return reviewRepository.getAllreviews(companyName);
	}

	@Override
	public double getRatingAverage(String companyName) {
		return reviewRepository.getRatingAverage(companyName);
	}

	@Override
	public int updateRating(Review review) {
		return reviewRepository.updateRating(review);
	}
	@Override
	public void setReviews(Review review) {
		reviewRepository.setReviews(review);
	}
	
	@Override
	public void removeReview(String companyName, String id, int reviewNumber) {
		reviewRepository.removeReview(companyName,id,reviewNumber);
	}

	@Override
	public void updateReview(Review review) {
	    reviewRepository.updateReview(review);
	}
	
	@Override
    public Review getReviewNumber(int reviewNumber) {
        return reviewRepository.getReviewNumber(reviewNumber);
    }
}
