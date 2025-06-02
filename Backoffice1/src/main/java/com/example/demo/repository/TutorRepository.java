package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
	
@Query(value = "select * from tutorss as t LEFT JOIN subjectss as s ON t.tutor_id = s.subject_fkey_id WHERE t.tutor_id  = :id", nativeQuery = true)
	   Tutor  getTandSdetailbyOneToMany(@Param("id") Long id);
	

}
