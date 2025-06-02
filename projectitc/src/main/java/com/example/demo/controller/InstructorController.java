package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.InstructorConvertor;
import com.example.demo.dto.InstructorDto;
import com.example.demo.entity.Instructor;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;

import io.swagger.v3.oas.annotations.Parameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping("instructor/{id}")
	public ResponseEntity<?> getInstructorData(@Parameter(description = "instructer id")     @PathVariable Long id) {
		
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
