package com.springmvc.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.domain.Review;
import com.springmvc.service.ReviewServiceImpl;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl reviewService;
	
	String encodedCompanyName = null;
	
	@GetMapping("/reviewList")
	public String showReviewList(@RequestParam("companyName") String companyName,Model model,HttpSession session) {
		String id=(String) session.getAttribute("id");
		
		List<Review> reviews=reviewService.getAllreviews(companyName);
		
		double averageRating = reviewService.getRatingAverage(companyName);
		
		model.addAttribute("id",id);
		model.addAttribute("reviews",reviews);
		model.addAttribute("companyName",companyName);
		model.addAttribute("averageRating", averageRating);
		return "reviewLists";
	}
	@GetMapping("/ReviewForm")
	public String writeReviewForm(@RequestParam("companyName") String companyName,Model model,HttpSession session) {
		model.addAttribute("companyName",companyName);
		String id=(String) session.getAttribute("id");
		model.addAttribute("id",id);
		return "ReviewForm";
	}
	@PostMapping("/writeReview")
	public String writeReview(@RequestParam("companyName") String companyName, 
	                          @RequestParam("comment") String comment, 
	                          @RequestParam("rating") double rating,
	                          @RequestParam("id") String id,
	                          Model model)
	{

	    Review review = new Review();
	    review.setCompanyName(companyName);
	    review.setComment(comment);
	    review.setId(id);
	    review.setRatingAvg(rating);

	    reviewService.setReviews(review);

	    double averageRating = reviewService.getRatingAverage(companyName);
	    
	    try {
			encodedCompanyName = URLEncoder.encode(companyName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return "redirect:/reviewList?companyName=" + encodedCompanyName + "&averageRating=" + averageRating;
	}
	@GetMapping("/removeReview")
	public String removeReview(@RequestParam("id") String id,
								@RequestParam("companyName") String companyName,
								@RequestParam("reviewNumber") int reviewNumber) {
		
		reviewService.removeReview(id,companyName,reviewNumber);
		
		try {
			encodedCompanyName = URLEncoder.encode(companyName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/reviewList?companyName=" + encodedCompanyName ;
	}
	@GetMapping("/updateReview")
	public String updateReviewForm(@RequestParam("reviewNumber") int reviewNumber, Model model) {

	    Review review = reviewService.getReviewNumber(reviewNumber);
	    
	    model.addAttribute("reviewNumber",reviewNumber);
	    model.addAttribute("updateReview", review);
	    model.addAttribute("companyName", review.getCompanyName());
	    
	    return "updateReview"; 
	}
	@PostMapping("/updateReview")
	public String updateReview(@ModelAttribute("updateReview") Review review,@RequestParam("companyName") String companyName,@RequestParam("reviewNumber") int reviewNumber,Model model) {
		reviewService.updateReview(review);
		model.addAttribute("reviewNumber", review.getReviewNumber());
		return "redirect:/reviewList?companyName=" + companyName ;
	}
}
