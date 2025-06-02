package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itc.restclient.entities.TurEntity;


public interface TutEntityRepository extends JpaRepository<TurEntity, Long> {

	@Query("SELECT t FROM TurEntity t LEFT JOIN t.subEntity s WHERE s.subjectId = :id")
	TurEntity getTutorDetailAlongWithSubjects(@Param("id") Long id);
/*			
			@Query("select i from Instructor i LEFT JOIN FETCH i.courses where i.id = :insid")
	Instructor getInstructorData(@Param("insid") Long insid);
	*/
	
}
