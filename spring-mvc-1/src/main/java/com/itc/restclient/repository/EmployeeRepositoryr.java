package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.EmployeeTable;

public interface EmployeeRepositoryr extends JpaRepository<EmployeeTable, Integer> {

}
