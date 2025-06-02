package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRespository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRespository courseRespositorye;
	
	public Instructor getCoourseData(Long id)
	{
	Instructor	instructor = courseRespositorye.findInstructorByCourseId(id);
	return instructor;
	}
	

}
