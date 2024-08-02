package com.springmvc.repository;

import com.springmvc.domain.Resume;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeRespositoryImpl implements ResumeRespository {
	
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void setmyImg(Resume resume) {
		String SQL = "INSERT INTO Resume(name, birthdate, gender, contact, email, address, school, period, major, job_title, experience_period, main_work, reason, work_hours, desired_salary, desired_days, MyimgName) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(SQL,
		    resume.getName(),
		    resume.getBirthdate(),
		    resume.getGender(),
		    resume.getContact(),
		    resume.getEmail(),
		    resume.getAddress(),
		    resume.getSchool(),
		    resume.getPeriod(),
		    resume.getMajor(),
		    resume.getJob_title(),
		    resume.getExperience_period(),
		    resume.getMain_work(),
		    resume.getReason(),
		    resume.getWork_hours(),
		    resume.getDesired_salary(),
		    resume.getDesired_days(),
		    resume.getMyimgName()
		);


		return;
	}

}
