package com.itc.restclient.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
	
	
	//Account getById(Long id);
}
