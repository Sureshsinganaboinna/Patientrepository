package com.itc.restclient.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Contdetails;
import com.itc.restclient.repository.ContactRepository;



@Service
public class CsvToDbUsingMultipleThread {
	@Autowired
	private ContactRepository contactRepository;

	@Async
	public void CsvTodbUsingThreads(List<Contdetails> contactlist) {
		try {
			contactRepository.saveAll(contactlist);
			System.out.println(" CsvTodbUsingThreads " + Thread.currentThread().getName());

			// System.out.println(contactlist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
