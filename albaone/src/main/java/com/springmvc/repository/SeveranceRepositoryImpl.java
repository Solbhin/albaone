package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Severance;
import com.springmvc.domain.employmentcontract;

@Repository
public class SeveranceRepositoryImpl implements SeveranceRepository
{
	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Severance Severance)
	{
		String sql = "insert into Severance (parttimename, company, money, companyNum) values(?,?,?,?)";
		
		template.update
		(
				sql,
				Severance.getParttimename(),
				Severance.getCompany(),
				Severance.getMoney(),
				Severance.getCompanyNum()
		);
		return;
	}

	//알바생 알바생명으로 조회
	@SuppressWarnings("deprecation")
	@Override
	public List<Severance> findAllBySeverance_alba(String parttimename)
	{
		String sql = "select * from Severance where parttimename = ?";
		return template.query(sql, new Object[]{parttimename}, new RowMapper<Severance>()
        {
            @Override
            public Severance mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Severance Severance = new Severance();
            	Severance.setParttimename(rs.getString("parttimename"));
            	Severance.setCompany(rs.getString("company"));
            	Severance.setMoney(rs.getLong("money"));
            	Severance.setCompanyNum(rs.getString("companyNum"));
                return Severance;
            }
        });
	}

	//기업 기업 번호로 조회
	@SuppressWarnings("deprecation")
	@Override
	public List<Severance> findAllBySeverance_comp(String company)
	{
		String sql = "select * from Severance where companyNum = ?";
		return template.query(sql, new Object[]{company}, new RowMapper<Severance>()
        {
            @Override
            public Severance mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Severance Severance = new Severance();
            	Severance.setParttimename(rs.getString("parttimename"));
            	Severance.setCompany(rs.getString("company"));
            	Severance.setMoney(rs.getLong("money"));
            	Severance.setCompanyNum(rs.getString("companyNum"));
                return Severance;
            }
        });
	}

}
