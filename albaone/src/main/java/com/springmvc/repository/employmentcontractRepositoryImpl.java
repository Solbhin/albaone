package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = "insert into employmentcontract values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		template.update
		(
				sql,
				employmentcontract.getNum(),
				employmentcontract.getOwnername(),
				employmentcontract.getParttimename(),
				employmentcontract.getPeriod_start(),
				employmentcontract.getPeriod_end(),
				employmentcontract.getPlace(),
				employmentcontract.getWorkdetail(),
				employmentcontract.getWorkinghours_start(),
				employmentcontract.getWorkinghours_end(),
				employmentcontract.getWorkday(),
				employmentcontract.getMoney(),
				employmentcontract.getBonus(),
				employmentcontract.getInsurance(),
				employmentcontract.getCreatedate()	
		);
		return;
	}
	
	//알바생이름으로 계약서 조회
	@SuppressWarnings("deprecation")
	@Override
    public List<employmentcontract> findAllByPartTimeName(String parttimename)
	{
        String sql = "select * from employmentcontract where parttimename = ?";
        return template.query(sql, new Object[]{parttimename}, new RowMapper<employmentcontract>()
        {
            @Override
            public employmentcontract mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	employmentcontract employmentcontract = new employmentcontract();
            	employmentcontract.setNum(rs.getInt("num"));
            	employmentcontract.setOwnername(rs.getString("ownername"));
            	employmentcontract.setParttimename(rs.getString("parttimename"));
            	employmentcontract.setPeriod_start(rs.getString("period_start"));
            	employmentcontract.setPeriod_end(rs.getString("period_end"));
            	employmentcontract.setPlace(rs.getString("place"));
            	employmentcontract.setWorkdetail(rs.getString("workdetail"));
            	employmentcontract.setWorkinghours_start(rs.getString("workinghours_start"));
            	employmentcontract.setWorkinghours_end(rs.getString("workinghours_end"));
            	employmentcontract.setWorkday(rs.getInt("workday"));
            	employmentcontract.setMoney(rs.getInt("money"));
            	employmentcontract.setBonus(rs.getInt("bonus"));
            	employmentcontract.setInsurance(rs.getString("insurance"));
            	employmentcontract.setCreatedate(rs.getString("createdate"));
                return employmentcontract;
            }
        });
    }
    
    //사장 이름으로 계약서 조회
    @SuppressWarnings("deprecation")
	@Override
	public List<employmentcontract> findAllByPartTimeNameownername(String ownername) {
		String sql = "select * from employmentcontract where ownername = ?";
        return template.query(sql, new Object[]{ownername}, new RowMapper<employmentcontract>()
        {
            @Override
            public employmentcontract mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	employmentcontract employmentcontract = new employmentcontract();
            	employmentcontract.setNum(rs.getInt("num"));
            	employmentcontract.setOwnername(rs.getString("ownername"));
            	employmentcontract.setParttimename(rs.getString("parttimename"));
            	employmentcontract.setPeriod_start(rs.getString("period_start"));
            	employmentcontract.setPeriod_end(rs.getString("period_end"));
            	employmentcontract.setPlace(rs.getString("place"));
            	employmentcontract.setWorkdetail(rs.getString("workdetail"));
            	employmentcontract.setWorkinghours_start(rs.getString("workinghours_start"));
            	employmentcontract.setWorkinghours_end(rs.getString("workinghours_end"));
            	employmentcontract.setWorkday(rs.getInt("workday"));
            	employmentcontract.setMoney(rs.getInt("money"));
            	employmentcontract.setBonus(rs.getInt("bonus"));
            	employmentcontract.setInsurance(rs.getString("insurance"));
            	employmentcontract.setCreatedate(rs.getString("createdate"));
                return employmentcontract;
            }
        });
	}

    //넘버로 계약서 삭제
    @Override
    public int deleteContractsByPartTimeName(int num)
    {
    	String sql = "delete from employmentcontract where num = ?";
    	// 삭제된 행 수 반환
        return template.update(sql, num); 
    }
	

}
