package com.springmvc.repository;

import com.springmvc.domain.Albarate;

public interface AlbarateRepository
{
	void insert(String id);
	void update(Albarate albarate);
	public Albarate read(String id);
}
