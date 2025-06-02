package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Vechicle;




public interface VechicleRepository extends JpaRepository<Vechicle, Integer> {

}
