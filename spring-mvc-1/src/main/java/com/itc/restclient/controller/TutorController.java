package com.itc.restclient.controller;

import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.Tutor;
import com.itc.restclient.repository.TutorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TutorController {
	
	@Autowired
	private TutorRepository tutorRepository;
	
	
	@PostMapping("/SaveTutorDetaile")
	public List<Tutor> postMethodName(@RequestBody List<Tutor> tutor) {
	
		tutorRepository.saveAll(tutor);
		System.out.println(tutor);
		
		return tutor;
	}
	
	/*@GetMapping("getTutorandsubjects/{id}")
	public List<Tutor> getTutorandSubjectDetails(@PathVariable Long id)
	{
		List<Tutor> getResult = tutorRepository.getTandSdetailes(id);
		
		return getResult;
	}*/
	@PostMapping("/OneToManyMapping")
	public List<Tutor> saveDetailsByOneToMany(@RequestBody List<Tutor> tutor) {
	
		tutorRepository.saveAll(tutor);
		System.out.println(tutor);
		
		return tutor;
	}
	@GetMapping("OneToManyMapping/{id}")
	public Tutor  getDetailsByOneToMany(@PathVariable Long id) {
	
		Tutor  tutor  = tutorRepository.getTandSdetailbyOneToMany(id);
		System.out.println(tutor);
		
		return tutor;
	}
	

}
