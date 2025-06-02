package com.itc.restclient.service;

import java.util.List;

import com.itc.restclient.entities.Entry;

public interface EntryService {
	

	
    public Entry saveEntry(Entry entry);
    public Entry updateEntry(Entry entry);
    public void deleteEntry(Entry entry);
    public Entry findById(Long id);
    public List<Entry> findAll();
    public List<Entry> findByUserId(Long id);


}
