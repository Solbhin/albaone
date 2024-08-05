package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.JobPost;

@Repository
public class JobPostRepositoryImpl implements JobPostRepository {
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void jobPosting(JobPost jobPost) {
		String SQL = "insert into jobpost(companyName, workLocation, contactNumber, salary, workHours, workDays, workDuration, jobDescription) values(?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, jobPost.getCompanyName(), jobPost.getWorkLocation(), jobPost.getContactNumber(), jobPost.getSalary(), jobPost.getWorkHours(), jobPost.getWorkDays(), jobPost.getWorkDuration(), jobPost.getJobDescription());
	}

	@Override
	public List<JobPost> getAllPosts() {
		String SQL = "select * from jobpost order by postNumber DESC";
//		return template.query(SQL, (rs, rowNum)->new JobPost(rs.getString("companyName")));
		return null;
	}

}
