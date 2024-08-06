package com.springmvc.repository;

import com.springmvc.domain.QRdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class QRrepositoryImpl implements QRrepository
{

    @Autowired
    private JdbcTemplate Template;

    @Override
    public void save(QRdto qrdto)
    {
        String sql = "insert into QRtable values (?, ?, ?, ?)";
        Template.update
        (
        		sql,
        		qrdto.getId(),
        		qrdto.getToday(),
        		qrdto.getIntime(),
        		qrdto.getQuittime()
        );
    }

    @Override
    public void update(QRdto qrdto)
    {
        String sql = "update QRtable set intime = ?, quittime = ? where id = ? and today = ?";
        Template.update
        (
        		sql,
        		qrdto.getIntime(),
        		qrdto.getQuittime(),
        		qrdto.getId(),
        		qrdto.getToday()
        );
    }

	@Override
    public QRdto findByIdAndDate(String id, String date)
    {
        //String sql = "select * from QRtable where id = ? and today = ?";
        String sql = "select * from QRtable where id = ?";
        
        return Template.queryForObject(sql, new Object[]{id, date}, (rs, rowNum)->
        {
        	QRdto qrdto = new QRdto();
            qrdto.setId(rs.getString("id"));
            qrdto.setToday(rs.getString("today"));
            qrdto.setIntime(rs.getString("intime"));
            qrdto.setQuittime(rs.getString("quittime"));
            return qrdto;
        });
    }

}
