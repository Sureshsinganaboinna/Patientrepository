package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vechicle;


public interface VechicleRepository extends JpaRepository<Vechicle, Integer> {

}
