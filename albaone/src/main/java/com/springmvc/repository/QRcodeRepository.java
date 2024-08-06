package com.springmvc.repository;

import com.springmvc.domain.QRdto;

public interface QRcodeRepository
{
	void create(QRdto qrdto);
	QRdto read(String id);
}
