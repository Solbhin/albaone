package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Review;

public interface ReviewService {
	List<Review> getAllreviews(String companyName);
	
	int updateRating(Review review);
	
	void setReviews(Review review);

	double getRatingAverage(String companyName);
	
	void removeReview(String companyName, String id, int reviewNumber);
    
    void updateReview(Review review);

	Review getReviewNumber(int reviewNumber);
}
