	package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Contdetails;



public interface ContactRepository extends JpaRepository<Contdetails, Long> {

}
