package com.example.demo.service;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import com.opencsv.CSVReader;

import aj.org.objectweb.asm.commons.AnalyzerAdapter;


@Service
public class FileUploadService {
	/*
	 * Get Input File
	 * Sanitise the recievd file.
	 * Verify the File extension allowed or not
	 * Verify File Size whether it is allowed or not 
	 * Generate Uniqe File name
	 * Upload to folder
	 * resize image
	 * resize image without affecting quality 
	 */
	@Value("${file.upload.image.path}")
	private String UPLOAD_IMAGE_PATH;
	
	@Value("${file.upload.pdf.path}")
	private String UPLOAD_PDFS_PATH;
	
	private int ALLOWED_IMAGE_SIZE = 1*1024*1024;
	
	private int MAX_ALLOWED_PDF_SIZE = 10*1024*1024;
	
	public void fileUpload(MultipartFile inputFile) throws Exception
	{
		String cleanedInputFile = StringUtils.cleanPath(inputFile.getOriginalFilename());
		String filenameextension = StringUtils.getFilenameExtension(cleanedInputFile);
		
		String[] allowedFileExtensions = {"png","jpg","gif","jpeg"};
		 
		Boolean isAllowedFileType = Arrays.stream(allowedFileExtensions).anyMatch(filenameextension::equals);
		if(isAllowedFileType == false)
		{
			throw new Exception( cleanedInputFile + "  File is not allowed");
		}
		if(inputFile.getSize()>ALLOWED_IMAGE_SIZE)
		{
			throw new Exception("Max 5MB allowed");
		}
	
		String uploadImageName = UUID.randomUUID().toString() + "."+filenameextension;
		
		Path uploadFilePath = Paths.get(UPLOAD_IMAGE_PATH + uploadImageName);
	    Files.copy(inputFile.getInputStream(), uploadFilePath);
	}
	
	public void handlePdfs(MultipartFile inputFile) throws Exception
	{
		String sanitizedInputFile = StringUtils.cleanPath(inputFile.getOriginalFilename());
		String fileExtension = StringUtils.getFilenameExtension(sanitizedInputFile);
		
		if(fileExtension.equals("pdf")==false)
		{
			throw new Exception("Only Pdf files are allowed");
		}
		
		if(inputFile.getSize()>MAX_ALLOWED_PDF_SIZE)
		{
			throw new Exception("Only 10MP allowed ");
		}
		
		String uploadname = UUID.randomUUID().toString() +".pdf";
		
		Path uploadPath = Paths.get(UPLOAD_PDFS_PATH+uploadname);
		System.out.println(uploadPath);
		Files.copy(inputFile.getInputStream(), uploadPath);
		
		
	}
	
	
	public void handlGreetingFiles(MultipartFile inputFile) throws Exception
	{
		
		
		  int UPLOAD_FILE_SIZE = 1024*1024*2;
		  
	         String greetingfile =	StringUtils.cleanPath(inputFile.getOriginalFilename());
	         String fileext = StringUtils.getFilenameExtension(greetingfile);
	         
	         String[] fileextallowed = {"wav","mp3"};
	         
	         Boolean isMatching = Arrays.stream(fileextallowed).anyMatch(fileext:: equals);
	         if(isMatching == false)
	         {
	        	 throw new Exception("Upload valid file, mp3 and wav will be allowed");
	         }
	         if(inputFile.getSize()>UPLOAD_FILE_SIZE)
	         {
	        	 throw new Exception("Only 2GB size files are allowed");
	         }
	         
	         String uploadImageName = UUID.randomUUID().toString()+"."+fileext;
	         Path uploadPath = Paths.get(uploadImageName);
	          Files.copy(inputFile.getInputStream(),uploadPath);
	         
	         
	         
	         
	         
	}
	
	}
	



