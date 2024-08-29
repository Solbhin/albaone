package com.springmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Review;

@Repository
public interface ReviewRepository {
	List<Review> getAllreviews(String companyName);
	
	int updateRating(Review review);
	
	double getRatingAverage(String companyName);
	
	void setReviews(Review review);
	
	void removeReview(String companyName, String id , int reviewNumber);
	
	void updateReview(Review review);

	Review getReviewNumber(int reviewNumber);
}
