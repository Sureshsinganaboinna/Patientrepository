package com.itc.restclient.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadOnAwsServicePractice {
	
	
	public void uploadPdfFile( MultipartFile inputFile) throws Exception
	{
	    String filenameString =  StringUtils.cleanPath(inputFile.getOriginalFilename());
	    String getFileExt = StringUtils.getFilenameExtension(filenameString);
	    System.out.println(getFileExt);
	    
	    if(getFileExt.equals("pdf")==false)
	    	throw new Exception(getFileExt + " file is not allowed, Only pdf file is accepted");
	    int file_Size = 1024*1024;
	    System.out.println(inputFile.getSize());
	    if(inputFile.getSize()>file_Size)
	    	throw new Exception("Only 2MB is allowed");
	    
	    String uniqueFileName = UUID.randomUUID().toString() + ".pdf";
	    System.out.println(uniqueFileName);
    
	}

}
