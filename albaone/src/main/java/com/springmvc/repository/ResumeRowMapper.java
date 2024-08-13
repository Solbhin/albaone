package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Resume;

public class ResumeRowMapper implements RowMapper<Resume> {

	@Override
	public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
		Resume resume = new Resume();
		resume.setNumber(Integer.valueOf(rs.getString("number")));
		resume.setName(rs.getString("name"));
		resume.setBirthdate(rs.getDate("birthdate"));
		resume.setGender(rs.getString("gender"));
		resume.setContact(rs.getString("contact"));
		resume.setEmail(rs.getString("email"));
		resume.setAddress(rs.getString("address"));
		resume.setSchool(rs.getString("school"));
		resume.setPeriod(rs.getString("period"));
		resume.setMajor(rs.getString("major"));
		resume.setJob_title(rs.getString("job_title"));
		resume.setExperience_period(rs.getString("experience_period"));
		resume.setMain_work(rs.getString("main_work"));
		resume.setReason(rs.getString("reason"));
		resume.setWork_hours(rs.getString("work_hours"));
		resume.setDesired_salary(rs.getString("desired_salary"));
		resume.setDesired_days(rs.getString("desired_days"));
		resume.setMyimgName(rs.getString("myimgName"));
		return resume;
	}
}
