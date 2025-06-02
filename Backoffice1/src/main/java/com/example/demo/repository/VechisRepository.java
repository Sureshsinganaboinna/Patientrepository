package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vechi;

public interface VechisRepository extends JpaRepository<Vechi, Integer> {

}
