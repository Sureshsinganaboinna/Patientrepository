package com.itc.restclient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	public List<Entry> findByUserid(Long userid); 
	
}
