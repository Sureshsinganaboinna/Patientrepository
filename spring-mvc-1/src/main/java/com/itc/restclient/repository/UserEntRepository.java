package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.UserEntr;


public interface UserEntRepository extends JpaRepository<UserEntr, Long> {

}
