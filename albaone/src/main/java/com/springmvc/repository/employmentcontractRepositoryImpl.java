package com.springmvc.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.employmentcontract;

@Repository
public class employmentcontractRepositoryImpl implements employmentcontractRepository
{
	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	//데이터베이스에 계약서 삽입하는 메서드
	@Override
	public void create(employmentcontract employmentcontract)
	{
		System.out.println("근로계약서 리파지토리 create");
		String sql = "insert into employmentcontract values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		template.update
		(
				sql,
				employmentcontract.getOwnername(),
				employmentcontract.getParttimename(),
				employmentcontract.getPeriod_start(),
				employmentcontract.getPeriod_end(),
				employmentcontract.getPlcae(),
				employmentcontract.getWorkdetail(),
				employmentcontract.getWorkinghours_start(),
				employmentcontract.getWorkinghours_end(),
				employmentcontract.getWorkday(),
				employmentcontract.getMoney(),
				employmentcontract.getBonus(),
				employmentcontract.getInsurance(),
				employmentcontract.getDate()	
		);
		return;
	}

	//계약서 갱신
	@Override
	public void update(employmentcontract employmentcontract)
	{
	    String sql = "update employmentcontract set " +
	    			 //컬럼
	                 "period_start = ?, " +
	                 "period_end = ?, " +
	                 "place = ?, " +
	                 "workdetail = ?, " +
	                 "workinghours_start = ?, " +
	                 "workinghours_end = ?, " +
	                 "workday = ?, " +
	                 "money = ?, " +
	                 "bonus = ?, " +
	                 "insurance = ?, " +
	                 "createdate = ? " +
	                 //조건
	                 "Where parttimename = ?";

	    template.update
	    (
	    	sql,
	        employmentcontract.getPeriod_start(),
	        employmentcontract.getPeriod_end(),
	        employmentcontract.getPlcae(),
	        employmentcontract.getWorkdetail(),
	        employmentcontract.getWorkinghours_start(),
	        employmentcontract.getWorkinghours_end(),
	        employmentcontract.getWorkday(),
	        employmentcontract.getMoney(),
	        employmentcontract.getBonus(),
	        employmentcontract.getInsurance(),
	        employmentcontract.getDate(),
	        employmentcontract.getParttimename()
	    );
	    return;
	}

}
