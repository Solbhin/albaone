package com.springmvc.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Albarate;
import com.springmvc.domain.QRdto;

@Repository
public class AlbarateRepositoryImpl implements AlbarateRepository
{
	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(String id)
	{
		String sql = "insert into Albarate values(?,?,?,?,?)";
		
		template.update
		(
				sql,
				id,0,0,0,0
		);
		return;
	}

	@Override
	public void update(Albarate albarate)
	{
	    String sql = "update Albarate set "
	            + "commute = commute + ?, "
	    		+ "absent = absent + ?,"
	            + "blinking = blinking + ?, "
	            + "company = company + ? "
	            + "where parttimename = ?";
	    
	    template.update
	    (
	            sql,
	            albarate.getCommute(),
	            albarate.getBlinking(),
	            albarate.getAbsent(),
	            albarate.getCompany(),
	            albarate.getParttimename() // where에 들어갈 값
	    );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Albarate read(String id)
	{
		String sql = "select parttimename,commute,absent,blinking,company from Albarate where parttimename = ?";
		
		return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
		{
			Albarate Albarate = new Albarate();
			Albarate.setParttimename(rs.getString("parttimename"));
			Albarate.setCommute(rs.getInt("commute"));
			Albarate.setAbsent(rs.getInt("absent"));
			Albarate.setBlinking(rs.getInt("blinking"));
			Albarate.setCompany(rs.getInt("company"));
			return Albarate;
		});
	}
}
