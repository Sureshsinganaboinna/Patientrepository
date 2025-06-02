package com.itc.restclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Usesss;

@Repository
public interface UsesssRepository extends JpaRepository<Usesss, Integer> {

	Optional<Usesss> findByEmail(String email);
	
	
}
