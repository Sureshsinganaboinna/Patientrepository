package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserSignupEntityPractice;




@Repository
public interface UserSignupRepository extends JpaRepository<UserSignupEntityPractice, Long> {
	
//	Optional<UserSignupPractice> findbyemail();
//	Optional<UserSignupPractice> FindByEmail(String userEmail);
	
	Optional<UserSignupEntityPractice> findByEmail(String userEmail);

}
