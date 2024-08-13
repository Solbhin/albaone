package com.springmvc.repository;

import com.springmvc.domain.Resume;

import java.util.List;

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
	public void setmyImg(Resume resume,String id) {
		String SQL = "INSERT INTO Resume(number,name, birthdate, gender, contact, email, address, school, period, major, job_title, experience_period, main_work, reason, work_hours, desired_salary, desired_days, MyimgName,resume_id) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		template.update(SQL,
			resume.getNumber(),
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
		    resume.getMyimgName(),
		    id
		);


		return;
	}

	@Override
	public List<Resume> getAllresumeList(String id) {
		String SQL="SELECT * FROM Resume WHERE resume_id = ?";
		List<Resume> listOfResume = template.query(SQL,new Object[]{id}, new ResumeRowMapper());
		return listOfResume;
	}

	@Override
	public Resume getResumeNumber(String number) {
		Resume ResumeInfo = null;
		String SQL = "SELECT count(*) FROM resume where Number=?";
		int rowCount = template.queryForObject(SQL,Integer.class,number);
		if(rowCount != 0) {
			SQL= "SELECT * FROM resume where Number=?";
			ResumeInfo = template.queryForObject(SQL,new Object[] {number},new ResumeRowMapper());
		}
		return ResumeInfo;
	}
	
	public List<Resume> getfindResumesByUserId(String userId) {
        String sql = "SELECT * FROM Resume WHERE resume_id = ?";
        return template.query(sql, new Object[]{userId}, new ResumeRowMapper());
    }

	@Override
	public void setUpdateResume(Resume resume) {
	    String SQL;
	    if (resume.getMyimgName() != null) {
	        SQL = "UPDATE Resume SET name = ?, birthdate = ?, gender = ?, contact = ?, email = ?, address = ?, school = ?, period = ?, major = ?, job_title = ?, experience_period = ?, main_work = ?, reason = ?, work_hours = ?, desired_salary = ?, desired_days = ?, MyimgName = ? WHERE number = ?";
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
	            resume.getMyimgName(),
	            resume.getNumber()
	        );
	    } else {
	        SQL = "UPDATE Resume SET name = ?, birthdate = ?, gender = ?, contact = ?, email = ?, address = ?, school = ?, period = ?, major = ?, job_title = ?, experience_period = ?, main_work = ?, reason = ?, work_hours = ?, desired_salary = ?, desired_days = ? WHERE number = ?";
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
	            resume.getNumber()
	        );
	    }
	}

	@Override
	public void setDeleteResume(String number) {
		String SQL="DELETE FROM Resume where number = ?";
		this.template.update(SQL,number);
		
	}

}

