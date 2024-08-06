package com.springmvc.repository;

import com.springmvc.domain.QRdto;

public interface QRrepository
{
    void save(QRdto qrdto);
    void update(QRdto qrdto);
    QRdto findByIdAndDate(String id, String date);
}
