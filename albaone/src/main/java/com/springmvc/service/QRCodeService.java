package com.springmvc.service;

import javax.servlet.http.HttpServletResponse;

import com.springmvc.domain.QRdto;


public interface QRCodeService
{
    
    public void create(QRdto qrdto);

	public QRdto read(String id);

	void generateQRCode(String text, HttpServletResponse response) throws Exception;
}
