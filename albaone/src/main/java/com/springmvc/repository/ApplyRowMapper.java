package com.springmvc.repository;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Apply;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplyRowMapper implements RowMapper<Apply> {

    @Override
    public Apply mapRow(ResultSet rs, int rowNum) throws SQLException {
        Apply apply = new Apply();
        apply.setId(rs.getString("id"));
        apply.setApply_id(rs.getInt("apply_id"));
        apply.setResumetitle(rs.getString("resumetitle"));
        apply.setCompanyName(rs.getString("companyName"));
        apply.setWorkLocation(rs.getString("workLocation"));
        apply.setSalary(rs.getInt("salary"));
        apply.setWorkHours(rs.getString("workHours"));
        apply.setWorkDays(rs.getString("workDays"));
        apply.setJobDescription(rs.getString("jobDescription"));
        apply.setResume_number(rs.getString("resume_number"));
        apply.setName(rs.getString("name"));
        apply.setContact(rs.getString("contact"));
        apply.setEmail(rs.getString("email"));
        apply.setAddress(rs.getString("address"));
        apply.setStatus(rs.getString("status"));
        apply.setMyimgName(rs.getString("myimgName"));
        return apply;
    }
}

