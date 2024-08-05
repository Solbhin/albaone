package com.springmvc.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.QRdto;

@Repository
public class QRcodeRepositoryImpl implements QRcodeRepository
{
	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}
	
	//QR 생성
	@Override
	public void create(QRdto qrdto)
	{
		System.out.println("QR 코드 create 메서드 실행");
		
		String sql = "insert into QRtable values (?,?,?)";//넣을 값이 2개뿐임, url과 id
		template.update
		(
				sql,
				qrdto.getQRurl(),
				qrdto.getId(),
				qrdto.getToday()
		);
		return;
	}

	@SuppressWarnings("deprecation")
	@Override
	public QRdto read(String id)
	{
		String sql = "SELECT QRurl, id, todaytime FROM QRtable WHERE id = ?";

		return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
		{
			QRdto qrDto = new QRdto();
			qrDto.setQRurl(rs.getString("QRurl"));
			qrDto.setId(rs.getString("id"));
			qrDto.setToday(rs.getString("todaytime")); // setToday 메서드 사용
	        return qrDto;
	        });
	    }

}
