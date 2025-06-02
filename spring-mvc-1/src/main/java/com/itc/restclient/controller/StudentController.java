package com.itc.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.Student;
import com.itc.restclient.repository.StudentRepository;
import com.itc.restclient.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	 @Autowired
	    private StudentRepository repo;

	@PostMapping("/saveData")
	public Student saveStudentData(@RequestBody  Student student)
	{
	   System.out.println(student.getName());
		Student dbStudent = repo.save(student) ;
		  System.out.println(dbStudent.getName());
		return dbStudent;
		
	}
	@PutMapping("/updateData")
	public Student updateStudentData(@RequestBody  Student student)
	{
		Student dbStudent = studentService.getStudentById(student.getId());
		
		dbStudent.setName(student.getName());
		
		Student dbStudent1 = repo.save(student) ;

		return dbStudent1;
		
	}
	@DeleteMapping("/deleteData/{id}")
	public String deleteStudentData(@PathVariable int id)
	{
	
		 studentService.deleteStudent(id);
		
		return "deleted successfully";
		
	}

	@GetMapping("/getData/{id}")
	public Student getStudentData(@PathVariable int id)
	{
	
		Student dbStudent = studentService.getStudentById(id);
		
		return dbStudent;
		
	}

}
