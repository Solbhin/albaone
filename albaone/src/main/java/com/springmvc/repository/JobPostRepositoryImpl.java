package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.JobPost;

@Repository
public class JobPostRepositoryImpl implements JobPostRepository
{
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void jobPosting(JobPost jobPost, String id)
	{
		String SQL = "insert into jobpost(companyName, workLocation, contactNumber, salary, workHours, workDays, workDuration, jobDescription, id) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL, jobPost.getCompanyName(), jobPost.getWorkLocation(), jobPost.getContactNumber(),
				jobPost.getSalary(), jobPost.getWorkHours(), jobPost.getWorkDays(), jobPost.getWorkDuration(),
				jobPost.getJobDescription(), id);
	}

	@Override
	public List<JobPost> getAllPosts(int page) {
		int pageSize = 9;
		int offset = (page - 1) * pageSize;

		String SQL = "select * from jobpost order by postNumber DESC LIMIT ? OFFSET ?";
		return template.query(SQL, new Object[] { pageSize, offset },
				(rs, rowNum) -> new JobPost(rs.getInt("postNumber"), rs.getString("companyName"),
						rs.getString("workLocation"), rs.getInt("salary"), rs.getString("workHours"),
						rs.getString("workDays")));
	}

	@Override
	public List<JobPost> getMyPosts(int page, String id) {
		int pageSize = 9;
		int offset = (page - 1) * pageSize;
		String SQL = "SELECT * FROM jobpost WHERE id = ? ORDER BY postNumber DESC LIMIT ? OFFSET ?";
		return template.query(SQL, new Object[] { id, pageSize, offset },
				(rs, rowNum) -> new JobPost(rs.getInt("postNumber"), rs.getString("companyName"),
						rs.getString("workLocation"), rs.getInt("salary"), rs.getString("workHours"),
						rs.getString("workDays")));
	}

	@Override
	public int getTotalPosts() {
		String SQL = "SELECT COUNT(*) FROM jobpost";
		return template.queryForObject(SQL, Integer.class);
	}

	@Override
	public JobPost getPostDetail(int postNumber) {
		String SQL = "SELECT * FROM jobpost WHERE postNumber=?";
		return template.queryForObject(SQL, new Object[] { postNumber }, (rs, rowNum) -> {
			JobPost jobPost = new JobPost();
			jobPost.setPostNumber(rs.getInt("postNumber"));
			jobPost.setCompanyName(rs.getString("companyName"));
			jobPost.setWorkLocation(rs.getString("workLocation"));
			jobPost.setContactNumber(rs.getString("contactNumber"));
			jobPost.setSalary(rs.getInt("salary"));
			jobPost.setWorkHours(rs.getString("workHours"));
			jobPost.setWorkDays(rs.getString("workDays"));
			jobPost.setWorkDuration(rs.getString("workDuration"));
			jobPost.setJobDescription(rs.getString("jobDescription"));
			jobPost.setId(rs.getString("id"));
			return jobPost;
		});
	}

	@Override
	public void deletePost(int postNumber) {
		String SQL = "DELETE FROM jobpost WHERE postNumber = ?";
		template.update(SQL, postNumber);
	}

	@Override
	public void updatePost(JobPost jobPost) {
		String SQL = "UPDATE jobpost SET companyName = ?, workLocation = ?, contactNumber = ?, salary = ?, workHours = ?, workDays = ?, workDuration = ?, jobDescription = ? WHERE postNumber = ?";
		template.update(SQL, jobPost.getCompanyName(), jobPost.getWorkLocation(), jobPost.getContactNumber(),
				jobPost.getSalary(), jobPost.getWorkHours(), jobPost.getWorkDays(), jobPost.getWorkDuration(),
				jobPost.getJobDescription(), jobPost.getPostNumber());
	}

}
