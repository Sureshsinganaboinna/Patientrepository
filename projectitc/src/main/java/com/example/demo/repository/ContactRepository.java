package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Contact;
import com.example.demo.entity.Contdetails;

public interface ContactRepository extends JpaRepository<Contdetails, Long> {

}
