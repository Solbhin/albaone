package com.springmvc.service;

import com.springmvc.domain.QRdto;

public interface QRservice
{
	void update(QRdto qrdto);
    QRdto findByIdAndDate(String id, String date);
	void save(QRdto qrdto);
}