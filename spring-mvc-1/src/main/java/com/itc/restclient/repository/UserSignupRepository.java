package com.itc.restclient.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.UserSignupEntityPractice;

@Repository
public interface UserSignupRepository extends JpaRepository<UserSignupEntityPractice, Long> {
	
//	Optional<UserSignupPractice> findbyemail();
//	Optional<UserSignupPractice> FindByEmail(String userEmail);
	
	Optional<UserSignupEntityPractice> findByEmail(String userEmail);

}
