package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Contact;
import com.example.demo.entity.Contdetails;
import com.example.demo.repository.ContactRepository;
import com.opencsv.CSVReader;

@Service
public class CsvToDbUploadService {
	
	@Autowired
	private CsvToDbUsingMultipleThread csvToDbUsingMultipleThread;
	
	public void handlCsvFileUpload(MultipartFile inputFile) throws Exception
	{
		String cleanedInputFile = StringUtils.cleanPath(inputFile.getOriginalFilename());
		String fileextensionname = StringUtils.getFilenameExtension(cleanedInputFile);
		
		System.out.println(fileextensionname);
		
		if(fileextensionname.equals("csv")==false)
		{
			throw new Exception("Please upload CSV file");   
		}
	try(Reader reader	= new BufferedReader (new InputStreamReader(inputFile.getInputStream()));
		   	CSVReader csvreader = new CSVReader(reader);) {	
		
	   	System.out.println(csvreader.readNext());
	   	List<Contdetails> contactlist = new ArrayList<Contdetails>();
      System.out.println("Main thread handlCsvFileUpload"+Thread.currentThread().getName());
	   	String[] csv = csvreader.readNext();
	   	while(csv!=null) {
	   		
	   		Contdetails contact = new Contdetails();
	       	  contact.setEmail(csv[3]);
	       	  contact.setFirstName(csv[0]);
	       	  contact.setLastName(csv[1]);
	       	  contact.setPhoneNumber(csv[2]);
	       	  contact.setCompany(csv[4]);
	       	  contactlist.add(contact);
	       	  
	       	  if(contactlist.size() == 200)
	       	  {
	       		csvToDbUsingMultipleThread.CsvTodbUsingThreads(new ArrayList<>(contactlist));
	       		 contactlist.clear();
	       	  }
	       	//  System.out.println(Arrays.toString(csv));
	   		csv = csvreader.readNext();
	   	}
	   	if(contactlist.size()>0)
	   	{
	 		csvToDbUsingMultipleThread.CsvTodbUsingThreads(new ArrayList<>(contactlist));
	   		 contactlist.clear();
	   	}
		
	}catch (Exception e) {
		throw new Exception("Unable to upload CSV file");
	}
     
          }
	}
	


