package com.springmvc.domain;

public class Review {
	private int ReviewNumber;
	private String companyName;
	private double ratingAvg;
	private String id;
	private String comment;
	
	public int getReviewNumber() {
		return ReviewNumber;
	}
	public void setReviewNumber(int reviewNumber) {
		ReviewNumber = reviewNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getRatingAvg() {
		return ratingAvg;
	}
	public void setRatingAvg(double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
	    return "Review [ReviewNumber=" + ReviewNumber + 
	           ", companyName=" + companyName + 
	           ", ratingAvg=" + ratingAvg + 
	           ", id=" + id + 
	           ", comment=" + comment + "]";
	}

}
