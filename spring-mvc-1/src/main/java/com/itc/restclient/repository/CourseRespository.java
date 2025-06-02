package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Course;
import com.itc.restclient.entities.Instructor;



@Repository
public interface CourseRespository extends JpaRepository<Course, Long> {

	 @Query("SELECT c.instructor FROM Course c WHERE c.id = :courseId")
	    Instructor findInstructorByCourseId(@Param("courseId") Long courseId);
	
	
}
