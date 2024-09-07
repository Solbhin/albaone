package com.springmvc.service;

import com.springmvc.domain.Albarate;

public interface AlbarateService
{
	void insert(String id);
	void update(Albarate albarate);
	public Albarate read(String id);
}
