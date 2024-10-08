package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Employmentcontract;

@Repository
public class EmploymentcontractRepositoryImpl implements EmploymentcontractRepository
{
	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	//데이터베이스에 계약서 삽입하는 메서드
	@Override
	public void create(Employmentcontract Employmentcontract)
	{
		System.out.println("근로계약서 리파지토리 create");
		String sql =
				"insert into employmentcontract values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		template.update
		(
				sql,
				Employmentcontract.getNum(),
				Employmentcontract.getOwnername(),
				Employmentcontract.getBusinessNumber(),
				Employmentcontract.getOwnerPhone(),
				Employmentcontract.getOwneraddr(),
				Employmentcontract.getParttimename(),
				Employmentcontract.getParttimePhone(),
				Employmentcontract.getParttimeaddr(),
				Employmentcontract.getPeriod_start(),
				Employmentcontract.getPeriod_end(),
				Employmentcontract.getPlace(),
				Employmentcontract.getWorkdetail(),
				Employmentcontract.getWorkinghours_start(),
				Employmentcontract.getWorkinghours_end(),
				Employmentcontract.getWorkday(),
				Employmentcontract.getMoney(),
				Employmentcontract.getBonus(),
				Employmentcontract.getInsurance(),
				Employmentcontract.getSinefilenameowner(),
				Employmentcontract.getSinefilenameparttime(),
				Employmentcontract.getCreatedate(),
				Employmentcontract.getParttimeid()
		);
		return;
	}
	
	//사업자 번호로 계약서 조회
	@SuppressWarnings("deprecation")
	@Override
    public List<Employmentcontract> findAllByBusinessNumber(String BusinessNumber)
	{
        String sql = "select * from employmentcontract where businessNumber = ?";
        return template.query(sql, new Object[]{BusinessNumber}, new RowMapper<Employmentcontract>()
        {
            @Override
            public Employmentcontract mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Employmentcontract Employmentcontract = new Employmentcontract();
            	Employmentcontract.setNum(rs.getInt("num"));
            	Employmentcontract.setOwnername(rs.getString("ownername"));
            	Employmentcontract.setBusinessNumber(rs.getString("businessNumber"));
            	Employmentcontract.setOwnerPhone(rs.getString("ownerPhone"));
            	Employmentcontract.setOwneraddr(rs.getString("owneraddr"));
            	Employmentcontract.setParttimename(rs.getString("parttimename"));
            	Employmentcontract.setParttimeaddr(rs.getString("parttimePhone"));
            	Employmentcontract.setParttimePhone(rs.getString("parttimeaddr"));
            	Employmentcontract.setPeriod_start(rs.getString("period_start"));
            	Employmentcontract.setPeriod_end(rs.getString("period_end"));
            	Employmentcontract.setPlace(rs.getString("place"));
            	Employmentcontract.setWorkdetail(rs.getString("workdetail"));
            	Employmentcontract.setWorkinghours_start(rs.getString("workinghours_start"));
            	Employmentcontract.setWorkinghours_end(rs.getString("workinghours_end"));
            	Employmentcontract.setWorkday(rs.getString("workday"));
            	Employmentcontract.setMoney(rs.getInt("money"));
            	Employmentcontract.setBonus(rs.getInt("bonus"));
            	Employmentcontract.setInsurance(rs.getString("insurance"));
            	Employmentcontract.setSinefilenameowner(rs.getString("sinefilenameowner"));
            	Employmentcontract.setSinefilenameparttime(rs.getString("sinefilenameparttime"));
            	Employmentcontract.setCreatedate(rs.getString("createdate"));
                return Employmentcontract;
            }
        });
    }

	//알바생 아이디로 조회하기
	@SuppressWarnings("deprecation")
	@Override
    public List<Employmentcontract> findAllByParttimeid(String parttimeid)
	{
        String sql = "select * from employmentcontract where parttimeid = ?";
        return template.query(sql, new Object[]{parttimeid}, new RowMapper<Employmentcontract>()
        {
            @Override
            public Employmentcontract mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Employmentcontract Employmentcontract = new Employmentcontract();
            	Employmentcontract.setNum(rs.getInt("num"));
            	Employmentcontract.setOwnername(rs.getString("ownername"));
            	Employmentcontract.setBusinessNumber(rs.getString("businessNumber"));
            	Employmentcontract.setOwnerPhone(rs.getString("ownerPhone"));
            	Employmentcontract.setOwneraddr(rs.getString("owneraddr"));
            	Employmentcontract.setParttimename(rs.getString("parttimename"));
            	Employmentcontract.setParttimeaddr(rs.getString("parttimePhone"));
            	Employmentcontract.setParttimePhone(rs.getString("parttimeaddr"));
            	Employmentcontract.setPeriod_start(rs.getString("period_start"));
            	Employmentcontract.setPeriod_end(rs.getString("period_end"));
            	Employmentcontract.setPlace(rs.getString("place"));
            	Employmentcontract.setWorkdetail(rs.getString("workdetail"));
            	Employmentcontract.setWorkinghours_start(rs.getString("workinghours_start"));
            	Employmentcontract.setWorkinghours_end(rs.getString("workinghours_end"));
            	Employmentcontract.setWorkday(rs.getString("workday"));
            	Employmentcontract.setMoney(rs.getInt("money"));
            	Employmentcontract.setBonus(rs.getInt("bonus"));
            	Employmentcontract.setInsurance(rs.getString("insurance"));
            	Employmentcontract.setSinefilenameowner(rs.getString("sinefilenameowner"));
            	Employmentcontract.setSinefilenameparttime(rs.getString("sinefilenameparttime"));
            	Employmentcontract.setCreatedate(rs.getString("createdate"));
                return Employmentcontract;
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
    
    // 계약서 번호로 조회하는 메서드 구현
    @SuppressWarnings("deprecation")
	@Override
    public Employmentcontract findByNum(int num)
    {
        String sql = "select * from employmentcontract where num = ?";
        return template.queryForObject(sql, new Object[]{num}, new RowMapper<Employmentcontract>()
        {
            @Override
            public Employmentcontract mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Employmentcontract Employmentcontract = new Employmentcontract();
            	Employmentcontract.setNum(rs.getInt("num"));
            	Employmentcontract.setOwnername(rs.getString("ownername"));
            	Employmentcontract.setBusinessNumber(rs.getString("businessNumber"));
            	Employmentcontract.setOwnerPhone(rs.getString("ownerPhone"));
            	Employmentcontract.setOwneraddr(rs.getString("owneraddr"));
            	Employmentcontract.setParttimename(rs.getString("parttimename"));
            	Employmentcontract.setParttimeaddr(rs.getString("parttimePhone"));
            	Employmentcontract.setParttimePhone(rs.getString("parttimeaddr"));
            	Employmentcontract.setPeriod_start(rs.getString("period_start"));
            	Employmentcontract.setPeriod_end(rs.getString("period_end"));
            	Employmentcontract.setPlace(rs.getString("place"));
            	Employmentcontract.setWorkdetail(rs.getString("workdetail"));
            	Employmentcontract.setWorkinghours_start(rs.getString("workinghours_start"));
            	Employmentcontract.setWorkinghours_end(rs.getString("workinghours_end"));
            	Employmentcontract.setWorkday(rs.getString("workday"));
            	Employmentcontract.setMoney(rs.getInt("money"));
            	Employmentcontract.setBonus(rs.getInt("bonus"));
            	Employmentcontract.setInsurance(rs.getString("insurance"));
            	Employmentcontract.setSinefilenameowner(rs.getString("sinefilenameowner"));
            	Employmentcontract.setSinefilenameparttime(rs.getString("sinefilenameparttime"));
            	Employmentcontract.setCreatedate(rs.getString("createdate"));
                return Employmentcontract;
            }
        });
    }
}
