package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.id = :userId")
	List<User> getUserDetails(@Param("userId") Long userId);
	
	
}
