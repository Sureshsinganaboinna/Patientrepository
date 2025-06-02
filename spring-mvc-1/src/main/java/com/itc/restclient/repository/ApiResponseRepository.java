package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.ApiResponseData;


public interface ApiResponseRepository extends JpaRepository<ApiResponseData, Integer> {
	
	

}
