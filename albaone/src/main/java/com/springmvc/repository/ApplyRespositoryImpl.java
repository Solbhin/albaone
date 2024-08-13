package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Apply;

@Repository
public class ApplyRespositoryImpl implements ApplyRespository{

	private JdbcTemplate template;
	
	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	@Override
	public void insertApplication(String id,String resume_number, String resumeTitle, int postNumber, 
	                              String companyName, String workLocation, int salary, 
	                              String workHours, String workDays, String jobDescription, 
	                              String name, String contact, String email, String address) 
	{
	    String SQL = "INSERT INTO apply(id,resume_number, resumetitle, postNumber, companyName, workLocation, salary, workHours, workDays, jobDescription, name, contact, email, address) " +
	                 "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    template.update(SQL, id,resume_number, resumeTitle, postNumber, companyName, workLocation, salary, workHours, workDays, jobDescription, name, contact, email, address);
	}


	@Override
	public List<Apply> getApplicaionts(String userId) {
		String sql = "SELECT a.apply_id, a.resumetitle, j.companyName, j.workLocation, j.salary, j.workHours, j.workDays, j.jobDescription, a.resume_id, r.name, r.contact, r.email, r.address " +
                "FROM apply a " +
                "JOIN Resume r ON a.resume_id = r.resume_id " +
                "JOIN jobpost j ON a.postNumber = j.postNumber " +
                "WHERE r.resume_id = ?";
		return template.query(sql, new Object[]{userId}, new ApplyRowMapper());
	}
	@Override
	public List<Apply> getAllapplys(String id) {
		String SQL="SELECT * FROM Apply where id= ? ";
		List<Apply> listOfApply = template.query(SQL,new Object[] {id},new ApplyRowMapper());
		System.out.println(listOfApply);
		return listOfApply;
	}
	@Override
	public List<Apply> getAllbusinesapplys(int postNumber) {
		String SQL="SELECT * FROM apply where postNumber = ? ";
		System.out.println(postNumber);
		List<Apply> listOfbusinesApply=template.query(SQL,new Object[] {postNumber},new ApplyRowMapper());
		return listOfbusinesApply;
	}
	@Override
	public void setDeleteApply(String apply_id) {
		String SQL="DELETE FROM Apply where apply_id=?";
		this.template.update(SQL,apply_id);
		
	}
	@Override
	public List<Apply> getbusinesview(int postNumber, int apply_id) {
		String SQL ="SELECT * FROM Apply WHERE postNumber = ? AND apply_id =?";
		return template.query(SQL,new Object[] {postNumber,apply_id},new ApplyRowMapper());
	}
}

