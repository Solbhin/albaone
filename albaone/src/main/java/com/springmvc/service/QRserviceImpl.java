package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.QRdto;
import com.springmvc.repository.QRrepository;

@Service
public class QRserviceImpl implements QRservice {

    @Autowired
    private QRrepository qRrepository;

    @Override
    public void save(QRdto qrdto)
    {
        qRrepository.save(qrdto);
    }

    @Override
    public void update(QRdto qrdto)
    {
        qRrepository.update(qrdto);
    }

    @Override
    public QRdto findByIdAndDate(String id, String date)
    {
        return qRrepository.findByIdAndDate(id, date);
    }
}
