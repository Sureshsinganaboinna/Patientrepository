package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ApiResponseData;

public interface ApiResponseRepository extends JpaRepository<ApiResponseData, Integer> {
	
	

}
