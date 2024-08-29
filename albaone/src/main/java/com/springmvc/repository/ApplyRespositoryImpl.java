package com.springmvc.repository;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	                              String name, String contact, String email, String address, String MyimgName) 
	{
	    String SQL = "INSERT INTO apply(id,resume_number, resumetitle, postNumber, companyName, workLocation, salary, workHours, workDays, jobDescription, name, contact, email, address, MyimgName) " +
	                 "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    template.update(SQL, id,resume_number, resumeTitle, postNumber, companyName, workLocation, salary, workHours, workDays, jobDescription, name, contact, email, address, MyimgName);
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
	@Override
	public void updateApplyStatus(int apply_id, String status, Integer postNumber) {
	    
		if(postNumber == null) {
			String statusEnum = convertToEnumStatus(status);
			String SQL = "UPDATE Apply SET status = ? WHERE apply_id = ? ";
			template.update(SQL,statusEnum,apply_id);
		}
	    if(postNumber != null) {
		    String statusEnum = convertToEnumStatus(status);
		    String SQL = "UPDATE Apply SET status = ? WHERE apply_id = ? AND postNumber = ?";
		    template.update(SQL, statusEnum, apply_id, postNumber);
	    }
	}

	private String convertToEnumStatus(String status) {
	    switch (status) {
	        case "accepted":
	            return "수락";
	        case "rejected":
	            return "거절";
	        case "공고 없음":
	        	return "공고 없음";
	        default:
	            return "지원 중";
	    }
	}
	public List<Integer> getApplyIdsByPostNumber(int postNumber) {
	    String SQL = "SELECT apply_id FROM Apply WHERE postNumber = ?";
	    return template.query(SQL, new Object[]{postNumber}, new RowMapper<Integer>() {
	        @Override
	        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
	            return rs.getInt("apply_id");
	        }
	    });
	}

	
	@Override
	public String getEmpolyeeId(int apply_id) {
		String SQL = "SELECT id FROM apply WHERE apply_id = ?";
		return template.queryForObject(SQL, new Object[] {apply_id}, String.class);
	}

	
}

