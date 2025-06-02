package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CsvToDbUploadService;
import com.example.demo.service.FileUploadService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "File Upload API's")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	public CsvToDbUploadService csvToDbUploadService;
	
	@PostMapping("/upload/image")
	public ResponseEntity<?> imagesUpload(@RequestParam("file") MultipartFile inputFile) throws Exception
	{
		fileUploadService.fileUpload(inputFile);
		Map<String, String> responseMap = new HashMap<String,String>();
		responseMap.put("result", "Success");
		responseMap.put("Status", "File has been uploaded seccessfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	@PostMapping("/upload/pdf")
	public ResponseEntity<?> pdfUpload(@RequestParam("pdf_file") MultipartFile inputFile) throws Exception
	{
		fileUploadService.handlePdfs(inputFile);
		Map<String, String> responseMap = new HashMap<String,String>();
		responseMap.put("result", "Success");
		responseMap.put("Status", "File has been uploaded seccessfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	@PostMapping("/csv/upload")
	public ResponseEntity<Map<String,String>> uploadCsvFile(@RequestParam("csv_file") MultipartFile inputFile) throws Exception
	{
		csvToDbUploadService.handlCsvFileUpload(inputFile);
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("Status", "CSV File has been uploaded seccessfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	
	

}
