package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	
	@Query("select i from Instructor i LEFT JOIN FETCH i.courses where i.id = :insid")
	Instructor getInstructorData(@Param("insid") Long insid);
	
	/* @Query("SELECT i FROM Instructor i LEFT JOIN i.courses c WHERE i.id = :insid")
	    Instructor getInstructorData(@Param("insid") Long insid);
*/
}
