package com.itc.restclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.SaveUser;
import java.util.List;




@Repository
public interface SaveRepository extends JpaRepository<SaveUser, Integer> {

  Optional<SaveUser> findByEmail(String email);
  Optional<SaveUser> findByAccountnumber(String accountnumber);

	
}
