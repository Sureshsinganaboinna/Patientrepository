package com.itc.restclient.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Instructor;
import com.itc.restclient.repository.CourseRespository;



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
