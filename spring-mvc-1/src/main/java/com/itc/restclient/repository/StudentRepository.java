package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
