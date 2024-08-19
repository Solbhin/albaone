package com.springmvc.domain;

public class Severance
{
	private String parttimename; //알바
	private String company; //업체
	private long money; //퇴직금
	private String companyNum; //사업자 등록번호
	
	public Severance(){}

	public String getParttimename() {
		return parttimename;
	}

	public void setParttimename(String parttimename) {
		this.parttimename = parttimename;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}
	
	
}
