package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Review;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    private JdbcTemplate template;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Review> getAllreviews(String companyName) {
        String SQL = "SELECT * FROM Review WHERE companyName = ?";
        
        return template.query(SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                ps.setString(1, companyName);
            }
        }, new RowMapper<Review>() {
            @Override
            public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                Review review = new Review();
                review.setReviewNumber(rs.getInt("ReviewNumber"));
                review.setId(rs.getString("id"));
                review.setRatingAvg(rs.getDouble("ratingAvg"));
                review.setCompanyName(rs.getString("companyName"));
                review.setComment(rs.getString("comment")); 
                return review;
            }
        });
    }

    public int updateRating(Review review) {
        String SQL = "UPDATE Review SET ratingAvg = ? WHERE id = ?";
        return template.update(SQL, review.getRatingAvg(), review.getId());
    }

    public double getRatingAverage(String companyName) {
        List<Review> reviews = getAllreviews(companyName);
        if (reviews.isEmpty()) {
            return 0.0; 
        }
        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRatingAvg();
        }
        double average = totalRating / reviews.size();
        average =(double) (Math.round(average*10)) / 10 ;
        
        return average;
    }


    public void setReviews(Review review) {
        String SQL = "INSERT INTO Review(ReviewNumber , companyName, comment, ratingAvg, id) VALUES (? ,?, ?, ?, ?)";
        template.update(SQL,
        		review.getReviewNumber(),
                review.getCompanyName(),
                review.getComment(),
                review.getRatingAvg(),
                review.getId());
    }

    public void removeReview(String id, String companyName ,int reviewNumber) {
        String SQL = "delete from Review Where id = ? and  companyName = ? and ReviewNumber = ?";
        template.update(SQL, id, companyName, reviewNumber);
    }

    public void updateReview(Review review) {
        String SQL = "UPDATE Review SET companyName = ?, comment = ?, ratingAvg = ? WHERE ReviewNumber = ?";
        template.update(SQL,
                review.getCompanyName(),
                review.getComment(),
                review.getRatingAvg(),
                review.getReviewNumber());
    }

	public Review getReviewNumber(int reviewNumber) {
	    String SQL = "SELECT * FROM Review WHERE ReviewNumber = ?";
	    
	    return template.query(SQL, new Object[] { reviewNumber }, rs -> {
	        if (rs.next()) {
	            Review review = new Review();
	            review.setReviewNumber(rs.getInt("reviewNumber"));
	            review.setId(rs.getString("id"));
	            review.setRatingAvg(rs.getDouble("ratingAvg"));
	            review.setCompanyName(rs.getString("companyName"));
	            review.setComment(rs.getString("comment"));
	            return review;
	        }
	        return null;
	    });
	}
}
