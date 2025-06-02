package com.itc.restclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Student;
import com.itc.restclient.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	@Cacheable(value = "students", key = "#id", unless = "#result == null")

	public Student getStudentById(int id) {
		System.out.println("Fetching from DB...");
		return repo.findById(id).orElse(null);
	}

	@Cacheable(value = "students", condition = "#id>10")

	public Student geStudentById(int id) {
		System.out.println("Fetching from DB...");
		return repo.findById(id).orElse(null);
	}

	@CachePut(value = "students", key = "#student.id")
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@CacheEvict(value = "students", key = "#id")
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

	@Cacheable(value = "students", key = "#id + '-' + #name")
	public Student getStudent(int id, String name) {
		System.out.println("Fetching from DB...");
		return repo.findById(id).orElse(null);
	}
}
