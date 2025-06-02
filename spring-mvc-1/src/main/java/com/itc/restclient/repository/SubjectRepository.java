package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Subject;



public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
