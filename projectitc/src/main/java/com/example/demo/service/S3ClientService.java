package com.example.demo.service;

import org.springframework.stereotype.Service;



import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;




@Service
public class S3ClientService {

	
	//bucket name, region, access key and secret key
	
	
//	 private final S3Client s3Client;
     
	  public S3ClientService() {
		AwsBasicCredentials awsBasicCredentials =  AwsBasicCredentials.create("AKIAVVZOOJ5QWG5QLGWO", "O/5UbkPyqL5jXnHk7x/+NiBm2vwCaNU9KLLYxg0P");
	
	}
	
	
}
