package com.itc.restclient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Productt;

public interface ProductRepositorry extends JpaRepository<Productt, Integer> {

	
	List<Productt> findBynameAndCatogory(String name, String catogory);
	
	
}
