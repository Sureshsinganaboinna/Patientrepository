package com.itelecenter.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itelecenter.backoffice.entity.User;

public interface UserEntRepository extends JpaRepository<User, Long> {

}
