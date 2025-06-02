package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SubEntity;

public interface SubEntityRepository extends JpaRepository<SubEntity, Long> {

}
