package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Entra;
import java.util.List;


public interface EntraaaRepository extends JpaRepository<Entra, Integer> {

	
	List<Entra> findByUsid(int usid);
}
