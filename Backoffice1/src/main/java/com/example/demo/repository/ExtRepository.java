package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Ext;

public interface ExtRepository extends JpaRepository<Ext, Integer> {

	/*@Query("select e from Ext where e.extId = ?1")
	Ext verifyExtByid(int extid);
*/	
	@Query(value = "select * from exts where ext_id = ?1", nativeQuery = true)
	Optional<Ext> verifyExtById(@Param("extid")  String extid);
	
	/*@Query(value = "select * from users  where email = ?1 and password = ?2", nativeQuery = true)
	Optional<User> dbloginwithquery(String email,String password);*/
	
	//select * from exts where ext_id = 022
	
//	@Query("SELECT u from User u where u.email = ?1 and u.password = ?2")
//	Optional<User> dbloginwithquery(String email,String password);
	
}
