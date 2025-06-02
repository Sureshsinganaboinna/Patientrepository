package com.itc.restclient.controller;

import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.dto.InstructorDto;
import com.itc.restclient.entities.Instructor;
import com.itc.restclient.service.CourseService;
import com.itc.restclient.service.InstructorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;
//	@Parameter(description = "instructer id")
	@GetMapping("instructor/{id}")
	public ResponseEntity<?> getInstructorData(     @PathVariable Long id) {
		
		InstructorDto instructorDto = instructorService.getInstructorData(id);
		System.out.println(id);
		Map<String, Object> respoMap = new HashMap<String, Object>();
		respoMap.put("result", "success");
		respoMap.put("dbInstructerData", instructorDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(respoMap);
	}
	@GetMapping("course/{id}")
	public ResponseEntity<?> getCourseData(@PathVariable Long id) {
		
		Instructor instructor = courseService.getCoourseData(id);
		Map<String, Object> respoMap = new HashMap<String, Object>();
		respoMap.put("result", "success");
		respoMap.put("dbInstructerData", instructor);
		
		return ResponseEntity.status(HttpStatus.OK).body(respoMap);
	}
	

}
