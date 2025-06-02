package com.example.demo.repository;

import java.util.Optional;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import jakarta.transaction.Transactional;

import java.util.List;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	//List<User> findByEmail(String email);
	Optional<User> findByResetPasswordLink(String resetPasswordLink);
	
	Optional<User> findByAccountNumber(String accountNumber);
	
	//Native SQL queries
	
	@Query(value= "select * from backofficeusers where email = :emailid and password =  :pwod" , nativeQuery = true)
	Optional<User> dbloginwithquery(@Param("emailid")  String email, @Param("pwod") String password);
	
	@Transactional
	@Procedure(procedureName = "proc_users")
	Optional<User> dbloginwithstoreprocedure(@Param("emailid")  String email, @Param("pwod") String password);
	
	/*//JPQL with index parameters
	@Query("SELECT u from User u where u.email = ?1 and u.password = ?2")
	Optional<User> dbloginwithquery(String email,String password);
	*/
	//Native with index parameters
	/*@Query(value = "select * from users  where email = ?1 and password = ?2", nativeQuery = true)
	Optional<User> dbloginwithquery(String email,String password);*/
	
/*	//JPQL with named parameters
	
	@Query("select u from User u where u.email = :emailid and u.password = :pword")
	Optional<User> dbloginwithquery(@Param("emailid")  String email, @Param("pword")String password);
	*/
	/*
	//Native SQL queries with names parameters
	@Query(value= "select * from users where email = :emailid and password =  :pword" , nativeQuery = true)
	Optional<User> dbloginwithquery(@Param("emailid")  String email, @Param("pword")String password);
	*/
	
	
	
	@Query(value = "select * from users where email = :emailid and password = :pword", nativeQuery = true)
	Optional<User>  dnloginwith(@Param("emailid") String email, @Param("pword") String password);
	
	
//	Optional<User> findByEmail(String email);
	
	/*  Optional<User> findByEmail(String email);
	  Optional<User> getByEmail(String email);*/
	
}
